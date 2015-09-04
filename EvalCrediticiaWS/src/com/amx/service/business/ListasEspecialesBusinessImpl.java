package com.amx.service.business;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.amx.service.adapter.SpecialListAdapter;
import com.amx.service.bean.AmdocsResTO;
import com.amx.service.bean.AmdocsTO;
import com.amx.service.bean.CredScoreInfoTO;
import com.amx.service.bean.ListaEspecialTO;
import com.amx.service.bean.ParametroTO;
import com.amx.service.bean.ReadListaTypeTO;
import com.amx.service.bean.ReadParametroTypeTO;
import com.amx.service.bean.ReadRequestTypeTO;
import com.amx.service.bean.ResourcesTO;
import com.amx.service.dao.ReadListaDAO;
import com.amx.service.dao.ReadParametroDAO;
import com.amx.service.util.Constantes;
import com.amx.service.util.LoggerFacade;

import javax.xml.ws.Service;
import cl.claro.speciallist.SpecialList;
import cl.claro.speciallist.SpecialListWS;
import cl.claro.xsd.speciallist.ListaType;
import cl.claro.xsd.speciallist.ParametroType;
import cl.claro.xsd.speciallist.ReadListaType;
import cl.claro.xsd.speciallist.ReadParametroType;
import cl.claro.xsd.speciallist.ReadRequestType;
import cl.claro.xsd.speciallist.ResponseType;

//Lista especial para consumir(servicio)
@org.springframework.stereotype.Service
public class ListasEspecialesBusinessImpl implements ListasEspecialesBusiness {

	private static Logger logger = Logger
			.getLogger(ListasEspecialesBusinessImpl.class);

	@Autowired
	ListaEspecialBusiness lista;

	// @Autowired
	static private Service service;

	@Autowired
	ReadListaDAO readListaDao;

	@Autowired
	ReadParametroDAO readParametroDAO;

	@Autowired
	ParametroBusiness parametroBusiness;

	@Autowired
	private ParametroBusiness parametroBusinessImpl;

	@Autowired
	private ResourcesBusiness resourcesBusiness;

	@Override
	public List<ReadListaTypeTO> obtenerRespuestaListasEspeciales(
			CredScoreInfoTO creditInfo) throws Exception {

		List<ReadListaTypeTO> readListaTypeTOs;
		List<ParametroTO> orden = parametroBusinessImpl
				.buscarParametroPorNomb("odse_listas_especiales_");
		try {
			readListaTypeTOs = ejecutarPaso(orden.get(0).getNombreParametro(),
					creditInfo);
		} catch (Exception e) {
			try {
				readListaTypeTOs = ejecutarPaso(orden.get(0)
						.getNombreParametro(), creditInfo);

			} catch (Exception j) {
				try {
					readListaTypeTOs = ejecutarPaso(orden.get(0)
							.getNombreParametro(), creditInfo);

				} catch (Exception k) {

					logger.error("No se pudo acceder a los datos a través de ninguno de los medios");
					throw new Exception(k);
				}

			}

		}
		return readListaTypeTOs;

	}

	public List<ReadListaTypeTO> ejecutarPaso(String tipo,
			CredScoreInfoTO creditInfo) throws Exception {
		ReadRequestType readRequestType = new ReadRequestType();
		ReadRequestTypeTO readRequestTypeTO = new ReadRequestTypeTO();
		ListaEspecialTO lstEsp = new ListaEspecialTO();
		lstEsp.setStado("A");
		String valorPorDefecto = "";
		Integer usuario = Integer.parseInt(creditInfo.getDealerId());
		ArrayList<ListaEspecialTO> listaE = (ArrayList<ListaEspecialTO>) lista
				.listarListasEspeciales(lstEsp);
		if (tipo.equals("odse_listas_especiales_ws")) {

			int i = 0;
			readRequestType.setIdTransaccion("982");

			for (ListaEspecialTO listaEspecialTO : listaE) {
				ReadListaType m = new ReadListaType();
				m.setIdLista(listaEspecialTO.getTipoLista());
				ReadParametroType n = new ReadParametroType();
				n.setId(listaEspecialTO.getCampoConsulta());
				if (listaEspecialTO.getCampoConsulta() != null
						&& listaEspecialTO.getCampoConsulta().equals("OK"))
					valorPorDefecto = "S";
				else
					valorPorDefecto = "N";
				n.setValor(creditInfo.getUserId());
				m.getParametro().add(n);
				readRequestType.getLista().add(m);
				i++;
			}

			ResponseType response = new ResponseType();

			List<ReadListaType> listaPpal = new ArrayList<ReadListaType>();
			ReadListaType listT = null;
			List<ReadParametroType> listaParam = null;

			if (readRequestType.getLista() != null
					&& !readRequestType.getLista().isEmpty()) {
				for (ReadListaType listaTipos : readRequestType.getLista()) {
					if (listaTipos.getParametro() != null
							&& !listaTipos.getParametro().isEmpty()) {
						for (ReadParametroType parametros : listaTipos
								.getParametro()) {
							listaParam = new ArrayList<ReadParametroType>();
							if (parametros.getId() != null
									&& !parametros.getId().equals("")
									&& parametros.getValor() != null
									&& !parametros.getValor().equals("")) {
								listaParam.add(parametros);
							}
						}
					}
					if (listaParam.size() > 0) {
						if (listaTipos.getIdLista() != null) {
							if (!listaTipos.getIdLista().equals("")) {
								listT = new ReadListaType();
								listT.setIdLista(listaTipos.getIdLista());
								listT.getParametro().addAll(listaParam);
								listaPpal.add(listT);
							}
						}
					}
				}

				if (!listaPpal.isEmpty()) {
					readRequestType.getLista().removeAll(
							readRequestType.getLista());
					readRequestType.getLista().addAll(listaPpal);
					response = getEspecialList().read(readRequestType);
					response.getIdTransaccion();
				}
			}

			for (ReadListaType readType : readRequestType.getLista()) {
				for (ListaType list : response.getLista()) {
					if (list.getIdLista().equals(readType.getIdLista())) {
						for (ParametroType type : list.getParametro()) {
							if (type.getId().equals("114")) {
								readRequestTypeTO = SpecialListAdapter
										.specialListReadRequestTypeToBean(
												readRequestType, "NOK");
							} else {
								readRequestTypeTO = SpecialListAdapter
										.specialListReadRequestTypeToBean(
												readRequestType, "OK");
							}
						}
					}
				}
			}

			for (ReadListaTypeTO obj : readRequestTypeTO.getLista()) {
				obj.setCodUsuario(usuario);
				readListaDao.insertarSpecialList(obj);
				for (ReadParametroTypeTO obj2 : obj.getParametro()) {
					obj2.setCodUsuario(usuario);
					obj2.setCodListaEspecial(obj.getCodListaEspecial());
					readParametroDAO.insertarParametro(obj2);
				}
			}

		} else if (tipo.equals("odse_listas_especiales_dh")) {
			
			
			throw new Exception("No hay datos en la base de datos");
		} else if (tipo.equals("odse_listas_especiales_vd")) {
			int i = 0;
			readRequestType.setIdTransaccion(null);

			for (ListaEspecialTO listaEspecialTO : listaE) {
				ReadListaTypeTO m = new ReadListaTypeTO();
				m.setIdLista(listaEspecialTO.getTipoLista());
				m.setCodUsuario(usuario);
				ReadParametroTypeTO n = new ReadParametroTypeTO();
				n.setCodUsuario(usuario);
				if (listaEspecialTO.getCampoConsulta() != null
						&& listaEspecialTO.getCampoConsulta().equals("OK"))
					valorPorDefecto = "S";
				else
					valorPorDefecto = "N";
				n.setIdParam(valorPorDefecto);
				n.setValor(creditInfo.getUserId());
				m.setRespuesta(listaEspecialTO.getValorDefecto());
				m.getParametro().add(n);
				readRequestTypeTO.getLista().add(m);
				i++;
			}
			for (ReadListaTypeTO obj : readRequestTypeTO.getLista()) {
				obj.setCodUsuario(usuario);
				readListaDao.insertarSpecialList(obj);
				for (ReadParametroTypeTO obj2 : obj.getParametro()) {
					obj2.setCodUsuario(usuario);
					obj2.setCodListaEspecial(obj.getCodListaEspecial());
					readParametroDAO.insertarParametro(obj2);
				}
			}
		}

		return readRequestTypeTO.getLista();

	}

	public SpecialListWS getEspecialList() throws MalformedURLException,
			WebServiceException {

		ResourcesTO resourcesTO = null;
		if (service == null) {
			try {
				resourcesTO = new ResourcesTO();
				resourcesTO.setResourceName(Constantes.SPECIAL_LIST);
				resourcesTO = resourcesBusiness
						.searchResourcesByName(resourcesTO);
				URL url_wsdl = new URL(resourcesTO.getValor().concat("?wsdl"));
				service = Service.create(url_wsdl, new QName(
						Constantes.Q_NAME_SL, Constantes.SPECIAL_LIST));
			} catch (WebServiceException ex) {
				LoggerFacade.registerError(String.valueOf(ex.getClass()), ex);
				throw ex;
			} catch (Exception e) {
				LoggerFacade.registerError(String.valueOf(e.getClass()), e);
			}
		}

		SpecialListWS port = service.getPort(SpecialListWS.class);

		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				resourcesTO.getValor());

		return port;
	}

}
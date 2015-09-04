package com.amx.service.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.AmdocsResTO;
import com.amx.service.bean.AmdocsTO;
import com.amx.service.bean.EquifaxDetalleTO;
import com.amx.service.bean.EquifaxTO;
import com.amx.service.bean.ParametroTO;
import com.amx.service.dao.EquifaxDAO;


@Service
public class EquifaxBusinessImpl implements EquifaxBusiness {

	private static Logger logger = Logger.getLogger(EquifaxBusinessImpl.class);

	@Autowired
	private EquifaxDAO equifaxDAO;

	@Autowired
	private EquifaxDetalleBusiness equifaxDetalleBL;

	@Autowired
	private ParametroBusiness parametroBL;

	@SuppressWarnings("unchecked")
	@Override
	public EquifaxTO buscarEquifax(String codigoE) throws Exception {
		List<EquifaxTO> lstEquifax = null;
		List<EquifaxDetalleTO> lstEquifaxDetalleTO = null;
		Map<String, Object> mapEquifax = new HashMap<String, Object>();

		try {
			mapEquifax.put("codigoEquifax", codigoE);
			equifaxDAO.listarEquifax(mapEquifax);
			lstEquifax = (List<EquifaxTO>) mapEquifax.get("resultados");
			if (!lstEquifax.isEmpty()) {
				for (EquifaxTO ls : lstEquifax) {
					lstEquifaxDetalleTO = equifaxDetalleBL
							.listarDetalleEquifax(ls.getCodigoEquifax()
									.toString());
					ls.getListEquifaxDetalle().addAll(lstEquifaxDetalleTO);
				}

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public EquifaxTO ConsultarEquifax(String rutCliente) throws Exception {
		EquifaxTO miEquifaxTO =null;
		List<ParametroTO> orden = parametroBL.buscarParametroPorNomb("odse_cheque_");
		try {
			miEquifaxTO=ejecutarPaso(rutCliente, orden.get(0).getNombreParametro());
		} catch (Exception e) {
			try{
				miEquifaxTO=ejecutarPaso(rutCliente, orden.get(1).getNombreParametro());
				
				}catch (Exception j){
				try{
					miEquifaxTO=ejecutarPaso(rutCliente, orden.get(2).getNombreParametro());	
					
				}catch(Exception k){
					
					logger.error("No se pudo acceder a los datos a través de ninguno de los medios");					
					throw new Exception(k);
				}
				
				
			}
			

		}
		return miEquifaxTO;
	}

	@Override
	public void insertarEquifax(EquifaxTO equifaxTO) throws Exception {
		try {
			equifaxDAO.insertarEquifax(equifaxTO);
			for (EquifaxDetalleTO ds : equifaxTO.getListEquifaxDetalle()) {
				ds.setCodigoEquifax(equifaxTO.getCodigoEquifax());
				equifaxDetalleBL.insertarDetalleEquifax(ds);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public EquifaxTO buscarEquifaxByRut(String rutCliente) throws Exception {
		EquifaxTO miEquifaxTO = null;
		List<EquifaxDetalleTO> lstEquifaxDetalleTO = null;
		Map<String, Object> mapEquifax = new HashMap<String, Object>();

		try {
			lstEquifaxDetalleTO = equifaxDetalleBL.listarDetalleEquifaxByRut(rutCliente);
			if (!lstEquifaxDetalleTO.isEmpty() && lstEquifaxDetalleTO.get(0).getCodigoEquifax()!=null) {
			mapEquifax.put("codigoEquifax", lstEquifaxDetalleTO.get(0).getCodigoEquifax());
				equifaxDAO.listarEquifax(mapEquifax);
			miEquifaxTO =((List<EquifaxTO>) mapEquifax.get("resultados")).get(0);
			miEquifaxTO.getListEquifaxDetalle().addAll(lstEquifaxDetalleTO);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return miEquifaxTO;
	}
	
	public EquifaxTO ejecutarPaso(String rut, String tipo) throws Exception {
		EquifaxTO miEquifax = null;
		EquifaxDetalleTO miDetalleEquifax = null;
		ParametroTO miParametroTO = null;
		Map<String, Object> mapEquifax = new HashMap<String, Object>();
		List<EquifaxDetalleTO> lstEquifaxDetalleTO = null;
		
		if (tipo.equals("odse_cheque_ws")) {
			// Consumo Web Service Amdocs
		} else if (tipo.equals("odse_cheque_dh")) {
			lstEquifaxDetalleTO = equifaxDetalleBL.listarDetalleEquifaxByRut(rut);
			if (!lstEquifaxDetalleTO.isEmpty() && lstEquifaxDetalleTO.get(0).getCodigoEquifax()!=null) {
			mapEquifax.put("codigoEquifax", lstEquifaxDetalleTO.get(0).getCodigoEquifax());
				equifaxDAO.listarEquifax(mapEquifax);
			miEquifax =((List<EquifaxTO>) mapEquifax.get("resultados")).get(0);
			miEquifax.getListEquifaxDetalle().addAll(lstEquifaxDetalleTO);
			miEquifax.setOrigen("Datos Historicos");
			}

			if(miEquifax == null || miEquifax.getCodigoEquifax()==null) {
				throw new Exception("No hay datos en la base de datos");
			}			
			
		} else if (tipo.equals("odse_cheque_vd")) {
			miEquifax = new EquifaxTO();
			miDetalleEquifax = new EquifaxDetalleTO();

			miEquifax.setOrigen("Valor por defecto");

			miParametroTO = parametroBL
					.buscarParametroPorNombre("prm_LCE_CHEQUE_AUTORIZADO");
			miEquifax.setAutorizacion(miParametroTO.getValorParametro());

			miParametroTO = parametroBL
					.buscarParametroPorNombre("prm_LCE_CHEQUE_CODIGO_DETALLE_CHEQUE");
			miDetalleEquifax.setCodigoDetalleEquifax(Long.valueOf(miParametroTO
					.getValorParametro()));

			miParametroTO = parametroBL
					.buscarParametroPorNombre("prm_LCE_CHEQUE_COD_RESPUESTA_CHEQUE");
			miDetalleEquifax.setCodigoRespuesta(miParametroTO
					.getValorParametro());

			miParametroTO = parametroBL
					.buscarParametroPorNombre("prm_LCE_CHEQUE_COD_RECHAZO_CHEQUE");
			miDetalleEquifax.setCodigoRechazo(miParametroTO
					.getValorParametro());

			miEquifax.getListEquifaxDetalle().add(miDetalleEquifax);
		}

		return miEquifax;

	}

}

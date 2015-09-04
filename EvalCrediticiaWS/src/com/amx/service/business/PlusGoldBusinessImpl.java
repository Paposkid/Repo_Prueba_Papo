package com.amx.service.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.adapter.SpecialListAdapter;
import com.amx.service.bean.CredScoreInfoTO;
import com.amx.service.bean.ListaEspecialTO;
import com.amx.service.bean.ParametroTO;
import com.amx.service.bean.PlusGoldTO;
import com.amx.service.bean.ReadListaTypeTO;
import com.amx.service.bean.ReadParametroTypeTO;
import com.amx.service.bean.ReadRequestTypeTO;
import com.amx.service.bean.SubSistema00TO;
import com.amx.service.bean.SubSistema01TO;
import com.amx.service.bean.SubSistema02TO;
import com.amx.service.bean.SubSistema03TO;
import com.amx.service.bean.SubSistema05TO;
import com.amx.service.bean.SubSistema06TO;
import com.amx.service.bean.SubSistema07TO;
import com.amx.service.bean.SubSistema08TO;
import com.amx.service.bean.SubSistema09TO;
import com.amx.service.bean.SubSistema10TO;
import com.amx.service.dao.PlusGoldDAO;
import com.amx.service.util.Util;

import cl.claro.xsd.speciallist.ListaType;
import cl.claro.xsd.speciallist.ParametroType;
import cl.claro.xsd.speciallist.ReadListaType;
import cl.claro.xsd.speciallist.ReadParametroType;
import cl.claro.xsd.speciallist.ReadRequestType;
import cl.claro.xsd.speciallist.ResponseType;

@Service
public class PlusGoldBusinessImpl implements PlusGoldBusiness {

	private static Logger logger = Logger.getLogger(PlusGoldBusinessImpl.class);

	@Autowired
	private PlusGoldDAO plusGoldDAO;

	@Autowired
	private Subsistema00Business subSis00BL;

	@Autowired
	private Subsistema01Business subSis01BL;

	@Autowired
	private Subsistema02Business subSis02BL;

	@Autowired
	private Subsistema03Business subSis03BL;

	@Autowired
	private Subsistema05Business subSis05BL;

	@Autowired
	private Subsistema06Business subSis06BL;

	@Autowired
	private Subsistema07Business subSis07BL;

	@Autowired
	private Subsistema08Business subSis08BL;

	@Autowired
	private Subsistema09Business subSis09BL;

	@Autowired
	private Subsistema10Business subSis10BL;

	@Autowired
	private ParametroBusiness parametroBL;

	@SuppressWarnings("unchecked")
	@Override
	public PlusGoldTO buscarPlusGold(String codigoE) throws Exception {

		List<PlusGoldTO> lstPlusGold = null;
		PlusGoldTO miPlusGold = null;

		Map<String, Object> mapEquifax = new HashMap<String, Object>();

		try {
			mapEquifax.put("serialVersionUId", codigoE);
			plusGoldDAO.listarPlusGold(mapEquifax);
			lstPlusGold = (List<PlusGoldTO>) mapEquifax.get("resultados");
			if (!lstPlusGold.isEmpty()) {
				miPlusGold = lstPlusGold.get(0);

				SubSistema00TO subSis00 = null;
				subSis00 = subSis00BL.searchListSys0(miPlusGold
						.getSerialVersion());
				miPlusGold.setSubsistema00(subSis00);

				SubSistema01TO subSis01 = null;
				subSis01 = subSis01BL.searchListSys1(miPlusGold
						.getSerialVersion());
				miPlusGold.setSubsistema01(subSis01);

				SubSistema02TO subSis02 = null;
				subSis02 = subSis02BL.searchListSys2(miPlusGold
						.getSerialVersion());
				miPlusGold.setSubsistema02(subSis02);

				SubSistema03TO subSis03 = null;
				subSis03 = subSis03BL.buscarSubsistema03(miPlusGold
						.getSerialVersion());
				miPlusGold.setSubsistema03(subSis03);

				SubSistema05TO subSis05 = null;
				subSis05 = subSis05BL.searchListSys5(miPlusGold
						.getSerialVersion());
				miPlusGold.setSubsistema05(subSis05);

				SubSistema06TO subSis06 = null;
				subSis06 = subSis06BL.buscarSubsistema06(miPlusGold
						.getSerialVersion());
				miPlusGold.setSubsistema06(subSis06);

				SubSistema07TO subSis07 = null;
				subSis07 = subSis07BL.buscarSubsistema07(miPlusGold
						.getSerialVersion());
				miPlusGold.setSubsistema07(subSis07);

				SubSistema08TO subSis08 = null;
				subSis08 = subSis08BL.searchListSys8(miPlusGold
						.getSerialVersion());
				miPlusGold.setSubsistema08(subSis08);

				SubSistema09TO subSis09 = null;
				subSis09 = subSis09BL.buscarSubsistema09(miPlusGold
						.getSerialVersion());
				miPlusGold.setSubsistema09(subSis09);

				SubSistema10TO subSis10 = null;
				subSis10 = subSis10BL.buscarSubsistema10(miPlusGold
						.getSerialVersion());
				miPlusGold.setSubsistema10(subSis10);

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return miPlusGold;
	}

	@Override
	public void insertarPlusGold(PlusGoldTO plusGoldTO) throws Exception {
		try {
			plusGoldDAO.insertarPlusGold(plusGoldTO);
			if (plusGoldTO.getSubsistema00() != null) {
				plusGoldTO.getSubsistema00().setSerialVersion(
						plusGoldTO.getSerialVersion());

				subSis00BL.insertarSubSys0(plusGoldTO.getSubsistema00());
			}
			if (plusGoldTO.getSubsistema01() != null) {
				plusGoldTO.getSubsistema01().setSerialVersion(
						plusGoldTO.getSerialVersion());

				subSis01BL.insertarSubSys1(plusGoldTO.getSubsistema01());
			}
			if (plusGoldTO.getSubsistema02() != null) {
				plusGoldTO.getSubsistema02().setSerialVersion(
						plusGoldTO.getSerialVersion());

				subSis02BL.insertarSubSys2(plusGoldTO.getSubsistema02());
			}
			if (plusGoldTO.getSubsistema03() != null) {
				plusGoldTO.getSubsistema03().setSerialVersion(
						plusGoldTO.getSerialVersion());

				subSis03BL.insertarSubsistema03(plusGoldTO.getSubsistema03());
			}
			if (plusGoldTO.getSubsistema05() != null) {
				plusGoldTO.getSubsistema05().setSerialVersion(
						plusGoldTO.getSerialVersion());

				subSis05BL.insertarSubSys5(plusGoldTO.getSubsistema05());
			}
			if (plusGoldTO.getSubsistema06() != null) {
				plusGoldTO.getSubsistema06().setSerialVersion(
						plusGoldTO.getSerialVersion());

				subSis06BL.insertarSubsistema06(plusGoldTO.getSubsistema06());
			}
			if (plusGoldTO.getSubsistema07() != null) {
				plusGoldTO.getSubsistema07().setSerialVersion(
						plusGoldTO.getSerialVersion());

				subSis07BL.insertarSubsistema07(plusGoldTO.getSubsistema07());
			}
			if (plusGoldTO.getSubsistema08() != null) {
				plusGoldTO.getSubsistema08().setSerialVersion(
						plusGoldTO.getSerialVersion());

				subSis08BL.insertarSubSys8(plusGoldTO.getSubsistema08());
			}
			if (plusGoldTO.getSubsistema09() != null) {
				plusGoldTO.getSubsistema09().setSerialVersion(
						plusGoldTO.getSerialVersion());

				subSis09BL.insertarSubsistema09(plusGoldTO.getSubsistema09());
			}
			if (plusGoldTO.getSubsistema10() != null) {
				plusGoldTO.getSubsistema10().setSerialVersion(
						plusGoldTO.getSerialVersion());

				subSis10BL.insertarSubsistema10(plusGoldTO.getSubsistema10());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public PlusGoldTO buscarPlusGoldbByRut(String rut) throws Exception {
		PlusGoldTO plusGoldTO = null;
		List<ParametroTO> orden = parametroBL
				.buscarParametroPorNomb("odse_dicom_");

		try {
			plusGoldTO = ejecutarPaso(orden.get(0).getNombreParametro(), rut);

		} catch (Exception e) {
			try {
				plusGoldTO = ejecutarPaso(orden.get(1).getNombreParametro(),
						rut);
			} catch (Exception j) {
				try {
					plusGoldTO = ejecutarPaso(
							orden.get(2).getNombreParametro(), rut);

				} catch (Exception k) {
					try {
						plusGoldTO = ejecutarPaso(orden.get(3)
								.getNombreParametro(), rut);

					} catch (Exception l) {
						throw new Exception(
								"Ha sido imposible recuperar los datos");
					}

				}

			}

		}

		return plusGoldTO;
	}

	public PlusGoldTO ejecutarPaso(String tipo, String rut) throws Exception {
		Integer diasVigencia = 0;
		Date fechaActual = new Date();
		Date fechaExpiracion = null;
		Date FechaUltima = null;
		ParametroTO miParametroTO = null;
		PlusGoldTO plusGoldTO = null;
		List<SubSistema00TO> lstSubs0 = null;
		List<PlusGoldTO> lstPlusGold = new ArrayList<PlusGoldTO>();
		if (tipo.equals("odse_dicom_dh")) {

			lstSubs0 = subSis00BL.listSubSys0ByRut(rut);
			if (!lstSubs0.isEmpty()) {
				for (SubSistema00TO sd : lstSubs0) {
					lstPlusGold.add(buscarPlusGold(sd.getSerialVersion()
							.toString()));
				}
				miParametroTO = parametroBL
						.buscarParametroPorNombre("vigencia_dicom");
				diasVigencia = Integer.parseInt(miParametroTO
						.getValorParametro());

				FechaUltima = lstPlusGold.get(0).getFechConsultado();
				plusGoldTO = lstPlusGold.get(0);
				for (PlusGoldTO ds : lstPlusGold) {
					if (FechaUltima.compareTo(ds.getFechConsultado()) < 0) {
						plusGoldTO = ds;
					}
				}
				fechaExpiracion = Util.SumarDiasDate(
						plusGoldTO.getFechConsultado(), diasVigencia);
				plusGoldTO.setOrigen("Datos Historicos");

				if (fechaExpiracion.compareTo(fechaActual) < 0) {
					plusGoldTO = null;
					throw new Exception(
							"Ha expirado la vigencia del registro historico");
				}

			}
		} else if (tipo.equals("odse_dicom_ws_dicom")) {

		} else if (tipo.equals("odse_dicom_vd")) {
			plusGoldTO = new PlusGoldTO();
			SubSistema00TO subSistema00TO = new SubSistema00TO();
			miParametroTO = parametroBL
					.buscarParametroPorNombre("prm_LCE_CONSULTO_DICOM");
			subSistema00TO.setUsodDico(miParametroTO.getValorParametro());

			SubSistema03TO subSistema03TO = new SubSistema03TO();
			miParametroTO = parametroBL
					.buscarParametroPorNombre("prm_LCE_DICOM_SCORE");
			subSistema03TO.setCaliExpl(miParametroTO.getValorParametro());

			miParametroTO = parametroBL
					.buscarParametroPorNombre("prm_LCE_DICOM_MONTO_DEUDA_TOTAL");
			subSistema00TO.setMontImpa(Integer.parseInt(miParametroTO
					.getValorParametro()));

			SubSistema10TO subSistema10TO = new SubSistema10TO();
			miParametroTO = parametroBL
					.buscarParametroPorNombre("prm_LCE_DICOM_ANTIGUEDAD_DEUDA");

			subSistema10TO.setMaxImpa(Integer.parseInt(miParametroTO
					.getValorParametro()));

			SubSistema05TO subSistema05TO = new SubSistema05TO();
			miParametroTO = parametroBL
					.buscarParametroPorNombre("prm_LCE_DICOM_TIPO_DEUDA_ULT_IMPAGO");
			if (miParametroTO.getValorParametro().equals("null")) {
				subSistema05TO.setFultImpa(null);
			} else {
				subSistema05TO.setFultImpa(Integer.parseInt(miParametroTO
						.getValorParametro()));
			}

			plusGoldTO.setSubsistema00(subSistema00TO);
			plusGoldTO.setSubsistema03(subSistema03TO);
			plusGoldTO.setSubsistema05(subSistema05TO);
			plusGoldTO.setSubsistema10(subSistema10TO);
			plusGoldTO.setOrigen("Datos por defecto");

		} else if (tipo.equals("odse_dicom_ws_siisa")) {

		}

		return plusGoldTO;

	}

}

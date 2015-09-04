package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.DetallePreviredTO;
import com.amx.service.bean.ParametroTO;
import com.amx.service.bean.PreviredTO;
import com.amx.service.bean.ResourcesTO;
import com.amx.service.dao.DetallePreviredDAO;
import com.amx.service.dao.PreviredDAO;



@Service
public class PreviredBussinesImpl implements PreviredBussines {

	private static Logger logger = Logger.getLogger(PreviredBussinesImpl.class);

	@Autowired
	private ParametroBusiness parametroBusinessImpl;
	
	@Autowired
	private PreviredDAO previredDao;

	@Autowired
	private DetallePreviredDAO detPreviredDao;

	@Autowired
	private DetallePreviredBussines detallePreviredBL;

	@Autowired
	private ParametroBusiness parametroBL;

	@Override
	public void insertarPrevired(PreviredTO previredTO) throws Exception {

		try {
			previredDao.insertarPrevired(previredTO);
			for (DetallePreviredTO ds : previredTO.getListDetallePrevired()) {
				ds.setCodPrevired(previredTO.getCodPrevired());
				detPreviredDao.insertarDetallePrevired(ds);

			}
			;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public PreviredTO consultarPreviredByCodigo(PreviredTO previredTO) throws Exception {

		PreviredTO previred = new PreviredTO();
		List<ParametroTO> orden = parametroBusinessImpl.buscarParametroPorNomb("odse_previred_");
		try {
			previred=ejecutarPaso(previredTO.getRutCliente(), orden.get(0).getNombreParametro());
		} catch (Exception e) {
			try{
				previred=ejecutarPaso(previredTO.getRutCliente(), orden.get(1).getNombreParametro());
				
				}catch (Exception j){
				try{
					previred=ejecutarPaso(previredTO.getRutCliente(), orden.get(2).getNombreParametro());	
					
				}catch(Exception k){
					
					logger.error("No se pudo acceder a los datos a través de ninguno de los medios");					
					throw new Exception(k);
				}
				
				
			}
			

		}
		
		return previred;
	}

	@Override
	@SuppressWarnings("unchecked")
	public PreviredTO consultarPreviredByRut(PreviredTO previredTO) throws Exception {

		PreviredTO previred = new PreviredTO();
		List<PreviredTO> listPrevired = new ArrayList<PreviredTO>();
		Map<String, Object> mapPreviredTO = new HashMap<String, Object>();
		try {
			mapPreviredTO.put("rutCliente", previredTO.getRutCliente());
			previredDao.consultarPreviredByRut(mapPreviredTO);
			listPrevired = (ArrayList<PreviredTO>) mapPreviredTO.get("resultados");
			if (!listPrevired.isEmpty()) {
				previred = listPrevired.get(0);
				DetallePreviredTO detallePrev = new DetallePreviredTO();
				List<DetallePreviredTO> lstDetallePrev = null;
				detallePrev.setCodPrevired(previred.getCodPrevired());
				lstDetallePrev = detallePreviredBL.consultarDetallePreviredByCodigo(detallePrev);
				previred.getListDetallePrevired().addAll(lstDetallePrev);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return previred;
	}

	@Override
	public PreviredTO consultarPrevired(String rutCLiente) throws Exception {

		ParametroTO miParametroTO = null;
		PreviredTO previred = null;
		try {
			previred = new PreviredTO();

			miParametroTO = parametroBL.buscarParametroPorNombre("prm_LCE_PREVIRED_PROM_REMU_IMPONIBLE");
			previred.setPrevMontoPromedio(miParametroTO.getValorParametro());

			miParametroTO = parametroBL.buscarParametroPorNombre("prm_LCE_PREVIRED_CONTINUIDAD_LABORAL");
			previred.setPrevContinuidadLaboral(miParametroTO.getValorParametro());

			previred.setOrigen("Datos por defecto");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return previred;
	}

	public PreviredTO ejecutarPaso(String rut, String tipo) throws Exception {
		ParametroTO miParametroTO = null;
		PreviredTO previred = null;
		List<PreviredTO> listPrevired = new ArrayList<PreviredTO>();
		Map<String, Object> mapPreviredTO = new HashMap<String, Object>();

		if (tipo.equals("odse_previred_ws")) {
			//llamado a WS
			ResourcesTO resourcesTO = new ResourcesTO();
			
			
			throw new Exception("No hay datos en la base de datos");
		} else if (tipo.equals("odse_previred_dh")) {
			mapPreviredTO.put("rutCliente", rut);
			previredDao.consultarPreviredByRut(mapPreviredTO);
			listPrevired = (ArrayList<PreviredTO>) mapPreviredTO.get("resultados");
			if (!listPrevired.isEmpty()) {
				previred = listPrevired.get(0);
				
				DetallePreviredTO detallePrev = new DetallePreviredTO();
				List<DetallePreviredTO> lstDetallePrev = null;
				detallePrev.setCodPrevired(previred.getCodPrevired());
				lstDetallePrev = detallePreviredBL.consultarDetallePreviredByCodigo(detallePrev);
				previred.getListDetallePrevired().addAll(lstDetallePrev);
				previred.setOrigen("Datos por defecto");
			}
			if (previred == null || previred.getCodPrevired() == 0) {
				throw new Exception("No hay datos en la base de datos");
			}
		} else if (tipo.equals("odse_previred_vd")) {
			previred = new PreviredTO();

			miParametroTO = parametroBL.buscarParametroPorNombre("prm_LCE_PREVIRED_PROM_REMU_IMPONIBLE");
			previred.setPrevMontoPromedio(miParametroTO.getValorParametro());

			miParametroTO = parametroBL.buscarParametroPorNombre("prm_LCE_PREVIRED_CONTINUIDAD_LABORAL");
			previred.setPrevContinuidadLaboral(miParametroTO.getValorParametro());

			previred.setOrigen("Datos por defecto");

		}
		return previred;
	}

}

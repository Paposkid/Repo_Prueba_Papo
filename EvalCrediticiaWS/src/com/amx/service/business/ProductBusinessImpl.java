package com.amx.service.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.service.bean.CompdifinfoTO;
import com.amx.service.bean.OrderactionTO;
import com.amx.service.bean.ProductTO;
import com.amx.service.dao.ProductDAO;


@Service
public class ProductBusinessImpl implements ProductBusiness {

	private static Logger logger = Logger.getLogger(ProductBusinessImpl.class);

	@Autowired
	ProductDAO productDao;

	@Autowired
	CompdifinfoBusiness compdifinfoBL;

	@Autowired
	OrderactionBusiness orderactionBL;

	@Override
	public void insertarProduct(ProductTO productTO) throws Exception {
		try {
			productDao.ingresarProduct(productTO);
			if (!productTO.getComponent().isEmpty()) {
				for (CompdifinfoTO ds : productTO.getComponent()) {
					ds.setCodigoProductdifinfo(productTO.getCorrProduct());
					compdifinfoBL.insertarCompdifinfo(ds);
				}
			}
			productTO.getOrderAction().setCorrProduct(
					productTO.getCorrProduct());
			orderactionBL.insertarLceOrderaction(productTO.getOrderAction());

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ProductTO buscarProduct(long codProduct) throws Exception {
		List<ProductTO> listaProduct = null;
		ProductTO productTO = null;
		List<CompdifinfoTO> listaCompdifinfo = null;
		List<OrderactionTO> listOrderaction = null;
		Map<String, Object> mapProduct = new HashMap<String, Object>();
		try {

			mapProduct.put("codProduct", codProduct);
			productDao.buscarProduct(mapProduct);
			listaProduct = (List<ProductTO>) mapProduct.get("resultados");
			if (!listaProduct.isEmpty()) {
				productTO = listaProduct.get(0);
				listaCompdifinfo = compdifinfoBL
						.listarCompdifinfoByProducto((productTO
								.getCorrProduct().toString()));
				if (!listaCompdifinfo.isEmpty()) {
					productTO.getComponent().addAll(listaCompdifinfo);
				}
				listOrderaction = orderactionBL.buscarOrderaction(codProduct);
				if (!listOrderaction.isEmpty()) {
					productTO.setOrderAction(listOrderaction.get(0));
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return productTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductTO> buscarProductByEFCE(long codProductEFCE)
			throws Exception {
		List<ProductTO> listaProduct = null;
		List<ProductTO> productFCE = null;
		Map<String, Object> mapProduct = new HashMap<String, Object>();
		try {

			mapProduct.put("codProductEFCE", codProductEFCE);
			productDao.buscarProduct(mapProduct);
			listaProduct = (List<ProductTO>) mapProduct.get("resultados");
			if (!listaProduct.isEmpty()) {
				productFCE = new ArrayList<ProductTO>();
				for (ProductTO ds : listaProduct) {
					productFCE.add(buscarProduct(ds.getCorrProduct()));
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return productFCE;
	}

}

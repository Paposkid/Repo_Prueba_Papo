package com.amx.service.business;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceClient;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amx.creditevaluation.ar7creditevaluation.Ar7CreditEvaluation;
import com.amx.creditevaluation.ar7creditevaluation.Ar7CreditEvaluationService;
import com.amx.schema.creditevaluation.ar7creditevaluation.Ar7CreditEvaluationRequest;
import com.amx.schema.creditevaluation.ar7creditevaluation.Ar7CreditEvaluationResponse;
import com.amx.service.bean.Ar7CreditEvaluationSalidaTO;
import com.amx.service.bean.Ar7CreditEvaluationTO;
import com.amx.service.bean.CustomerEntityListSalidaTO;
import com.amx.service.bean.ResourcesTO;
import com.amx.service.util.Constantes;
import com.amx.service.util.LoggerFacade;

import cl.clarochile.aplicaciones.evalcrediticia.adapter.Ar7CreditEvaluationAdapter;

@Service
public class Ar7CreditEvaluationBusinessImpl implements Ar7CreditEvaluationBusiness {

	private static Logger logger = Logger.getLogger(Ar7CreditEvaluationBusinessImpl.class);

	@Autowired
	private ResourcesBusiness resourcesBusiness;

	@Override
	public Ar7CreditEvaluationSalidaTO consultaAr7(List<CustomerEntityListSalidaTO> listCBP) throws Exception {

		Ar7CreditEvaluationSalidaTO miAr7CreditEvaluationSalidaTO = null;
		Ar7CreditEvaluationTO miAr7CreditEvaluationTO = null;
		Ar7CreditEvaluationRequest requestAR7 = new Ar7CreditEvaluationRequest();
		Ar7CreditEvaluationResponse responseAR7 = new Ar7CreditEvaluationResponse();
		ResourcesTO resourcesTOAR7 = new ResourcesTO();
		Double sumaAmountDue = 0d;
		short antigüedadCliente = 0;

		try {

			resourcesTOAR7.setResourceName(Constantes.ENDPOINT_AR7_CREDIT_EVALUATION);
			resourcesTOAR7 = resourcesBusiness.searchResourcesByName(resourcesTOAR7);
			LoggerFacade.registerLog(Constantes.INFO_LLAMADO + "AMDOCS AR7CREDIT EVALUATION");

			WebServiceClient clienteWSAR7 = Ar7CreditEvaluationService.class.getAnnotation(WebServiceClient.class);
			URL endPointAR7 = new URL(resourcesTOAR7.getValor());
			QName serviNameAr7 = new QName(clienteWSAR7.targetNamespace(), clienteWSAR7.name());
			Ar7CreditEvaluationService webServiceAr7 = new Ar7CreditEvaluationService(endPointAR7, serviNameAr7);
			Ar7CreditEvaluation portAr7 = webServiceAr7.getAr7CreditEvaluationPort();

			for (CustomerEntityListSalidaTO customerEntityListSalidaTO : listCBP) {
				miAr7CreditEvaluationSalidaTO = new Ar7CreditEvaluationSalidaTO();
				miAr7CreditEvaluationTO = new Ar7CreditEvaluationTO();
				miAr7CreditEvaluationTO.setCustomerNo(Integer.parseInt(customerEntityListSalidaTO.getCustomerId()));
				requestAR7 = Ar7CreditEvaluationAdapter.beanToRequest(miAr7CreditEvaluationTO);
				responseAR7 = portAr7.ar7CreditEvaluation(requestAR7);
				miAr7CreditEvaluationSalidaTO = Ar7CreditEvaluationAdapter.responseToBean(responseAR7);

				sumaAmountDue = miAr7CreditEvaluationSalidaTO.getAmountDue() + sumaAmountDue;

				antigüedadCliente = miAr7CreditEvaluationSalidaTO.getL7SubSeniority();
				if (antigüedadCliente < miAr7CreditEvaluationSalidaTO.getL7SubSeniority()) {
					antigüedadCliente = miAr7CreditEvaluationSalidaTO.getL7SubSeniority();
				}

				if (miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("1")) {
					miAr7CreditEvaluationSalidaTO.setL7PaymentBehavior(miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior());
				} else if (miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("0")) {
					if (!miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("1")) {
						miAr7CreditEvaluationSalidaTO.setL7PaymentBehavior(miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior());
					}
				} else if (miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("2")) {
					if (!miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("1") && !miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("0")) {
						miAr7CreditEvaluationSalidaTO.setL7PaymentBehavior(miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior());
					}
				} else if (miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("3")) {
					if (!miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("1") && !miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("0")
							&& !miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("2")) {
						miAr7CreditEvaluationSalidaTO.setL7PaymentBehavior(miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior());
					}
				} else if (miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("4")) {
					if (!miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("1") && !miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("0")
							&& !miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("2") && !miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("3")) {
						miAr7CreditEvaluationSalidaTO.setL7PaymentBehavior(miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior());
					}
				} else if (miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("5")) {
					if (!miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("1") && !miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("0")
							&& !miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("2") && !miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("3")
							&& !miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior().equals("4")) {
						miAr7CreditEvaluationSalidaTO.setL7PaymentBehavior(miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior());
					}
				}

			}

			miAr7CreditEvaluationSalidaTO.setAmountDue(sumaAmountDue);
			miAr7CreditEvaluationSalidaTO.setL7SubSeniority(antigüedadCliente);
			miAr7CreditEvaluationSalidaTO.setL7PaymentBehavior(miAr7CreditEvaluationSalidaTO.getL7PaymentBehavior());

		} catch (Exception e) {

			logger.error(e.getMessage());
			throw e;
		}

		return miAr7CreditEvaluationSalidaTO;
	}

}

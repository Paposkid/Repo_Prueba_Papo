package com.amx.service.validator;

import java.util.StringTokenizer;

import com.amx.service.bean.AmdocsTO;
import com.amx.service.bean.DetSubsistema10TO;
import com.amx.service.bean.EquifaxDetalleTO;
import com.amx.service.bean.EquifaxTO;
import com.amx.service.bean.PlusGoldTO;
import com.amx.service.bean.PreviredTO;

import cl.clarochile.aplicaciones.evalcrediticia.getcreditscorebycustomer.estructura.AccreditationData;
import cl.clarochile.aplicaciones.evalcrediticia.getcreditscorebycustomer.estructura.AccreditationDocument;
import cl.clarochile.aplicaciones.evalcrediticia.getcreditscorebycustomer.estructura.BiometricValidation;
import cl.clarochile.aplicaciones.evalcrediticia.getcreditscorebycustomer.estructura.GetCreditScoreByCustomerRequest;
import cl.clarochile.aplicaciones.evalcrediticia.performfullcreditevaluation.estructura.AttributeDiffInfo;
import cl.clarochile.aplicaciones.evalcrediticia.performfullcreditevaluation.estructura.ComponentDiffInfo;
import cl.clarochile.aplicaciones.evalcrediticia.performfullcreditevaluation.estructura.PerformFullCreditEvaluationRequest;
import cl.clarochile.aplicaciones.evalcrediticia.performfullcreditevaluation.estructura.ProductDiffInfo;

/**
 * Clase que valida que los datos de la LCE y FCE no esten vacios.
 * 
 * @author Jorge Armando Montoya Jaramillo jorge.montoyajaramillo@tcs.com
 * @since 4/04/2013
 * @version 1.0
 */
public class Validator {

	public static StringBuilder validateFCE(
			PerformFullCreditEvaluationRequest fullCreditEvaluation) {
		StringBuilder str = new StringBuilder();

		// E_FCE_CANT_TOTAL_LINEAS

		for (ProductDiffInfo pdt : fullCreditEvaluation.getProductDiffInfo()) {
			for (ComponentDiffInfo comp : pdt.getComponentDiffInfoList()) {
				if (comp.getDiffAction().equals("")) {
					str.append("DiffAction esta vacio");
				}
				if (comp.getDiffAction().trim().length() > 20) {
					str.append("DiffAction no cumple con lo máximo de 20 posiciones");
				}
				if (comp.getComponentCId().equals("")) {
					str.append("ComponentCId esta vacio");
				}
				if (comp.getComponentCId().trim().length() > 20) {
					str.append("ComponentCId no cumple con lo máximo de 20 posiciones");
				}
				for (AttributeDiffInfo attrib : comp.getAttributeDiffInfoList()) {
					if (attrib.getAttributePropertyId().equals("")) {
						str.append("AttributePropertyId esta vacio");
					}
					if (attrib.getAttributePropertyId().trim().length() > 20) {
						str.append("AttributePropertyId no cumple con lo máximo de 20 posiciones");
					}
					if (attrib.getAttributeValue().equals("")) {
						str.append("AttributeValue esta vacio");
					}
					if (attrib.getAttributeValue().trim().length() > 20) {
						str.append("AttributeValue no cumple con lo máximo de 20 posiciones");
					}
				}
			}
		}
		// E_FCE_VALOR_TOTAL_CARGO_UNICO
		for (ProductDiffInfo pdt : fullCreditEvaluation.getProductDiffInfo()) {
			if (pdt.getSumOfOC().equals("")) {
				str.append("SumOfOC esta vacio");
			}
			if (pdt.getSumOfOC().trim().length() > 20) {
				str.append("SumOfOC no cumple con lo máximo de 20 posiciones");
			}
		}

		// E_FCE_VALOR_TOTAL_RECURRENTE
		for (ProductDiffInfo pdt : fullCreditEvaluation.getProductDiffInfo()) {
			if (pdt.getSumOfCurrentRC().equals("")) {
				str.append("SumOfCurrentRC esta vacio");
			}
			if (pdt.getSumOfCurrentRC().trim().length() > 20) {
				str.append("SumOfCurrentRC no cumple con lo máximo de 20 posiciones");
			}
		}

		// E_FCE_CODIGO_OFERTA
		for (ProductDiffInfo pdt : fullCreditEvaluation.getProductDiffInfo()) {
			if (pdt.getOffername().equals("")) {
				str.append("Offername esta vacio");
			}
			if (pdt.getOffername().trim().length() > 15) {
				str.append("Offername no cumple con lo máximo de 15 posiciones");
			}
		}

		// E_FCE_ACTIVACION_INMEDIATA
		for (ProductDiffInfo pdt : fullCreditEvaluation.getProductDiffInfo()) {
			if (pdt.getOrderActionInfo().getOasrd().toGregorianCalendar()
					.getTime().equals("")) {
				str.append("OrderActionInfo no cumple formato");
			}
		}

		// E_FCE_ORDER_ACTION_TYPE
		for (ProductDiffInfo pdt : fullCreditEvaluation.getProductDiffInfo()) {
			if (pdt.getOrderActionInfo().getOrderActionType().equals("")) {
				str.append("OrderActionType esta vacio");
			}
			if (pdt.getOrderActionInfo().getOrderActionType().trim().length() > 20) {
				str.append("Offername no cumple con lo máximo de 20 posiciones");
			}

		}

		return str;
	}

	public static StringBuilder validateLCE(
			GetCreditScoreByCustomerRequest lightCreditEvaluation) {

		StringBuilder str = new StringBuilder();

		if (lightCreditEvaluation.getCreditScoreInformation().getOrderId()
				.equals("")) {
			str.append("OrderId es vacio,");
		}
		StringTokenizer st = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getOrderId());
		if (st.countTokens() > 10) {
			str.append("OrderId no cumple el tamaño requerido 10 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation().getOaType()
				.equals("")) {
			str.append("OaType es vacio,");
		}
		StringTokenizer st1 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getOaType());
		if (st1.countTokens() > 10) {
			str.append("OaType no cumple el tamaño requerido 10 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation().getSalesChannel()
				.equals("")) {
			str.append("SalesChannel es vacio,");
		}
		StringTokenizer st2 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getSalesChannel());
		if (st2.countTokens() > 50) {
			str.append("SalesChannel no cumple el tamaño requerido 50 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation().getLocation()
				.equals("")) {
			str.append("Location es vacio,");
		}
		StringTokenizer st3 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getLocation());
		if (st3.countTokens() > 100) {
			str.append("Location no cumple el tamaño requerido 100 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation()
				.getDealerOnBehalf().equals("")) {
			str.append("DealerOnBehalf es vacio,");
		}
		StringTokenizer st4 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getDealerOnBehalf());
		if (st4.countTokens() > 50) {
			str.append("DealerOnBehalf no cumple el tamaño requerido 50 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation().getUserId()
				.equals("")) {
			str.append("UserId es vacio,");
		}
		StringTokenizer st5 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getUserId());
		if (st5.countTokens() > 50) {
			str.append("UserId no cumple el tamaño requerido 50 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation().getRegion()
				.equals("")) {
			str.append("Region es vacio,");
		}
		StringTokenizer st6 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getRegion());
		if (st6.countTokens() > 20) {
			str.append("Region no cumple el tamaño requerido 20 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation()
				.getIdentifierNumber().equals("")) {
			str.append("IdentifierNumber es vacio,");
		}
		StringTokenizer st7 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getIdentifierNumber());
		if (st7.countTokens() > 20){
			str.append("IdentifierNumber no cumple el tamaño requerido 20 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation()
				.getIdentifierType().equals("")) {
			str.append("IdentifierType es vacio,");
		}
		StringTokenizer st8 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getIdentifierType());
		if (st8.countTokens() > 20){
			str.append("IdentifierType no cumple el tamaño requerido 20 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation()
				.getAddressInfoDetails().getCity().equals("")) {
			str.append("City es vacio,");
		}
		StringTokenizer st10 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getAddressInfoDetails().getCity());
		if (st10.countTokens() > 40){
			str.append("City no cumple el tamaño requerido 40 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation()
				.getAddressInfoDetails().getDistrict().equals("")) {
			str.append("District es vacio,");
		}
		StringTokenizer st11 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getAddressInfoDetails()
				.getDistrict());
		if (st11.countTokens() > 40){
			str.append("District no cumple el tamaño requerido 40 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation()
				.getAddressInfoDetails().getState().equals("")) {
			str.append("State es vacio,");
		}
		StringTokenizer st12 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getAddressInfoDetails().getState());
		if (st12.countTokens() > 40){
			str.append("State no cumple el tamaño requerido 40 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation()
				.getAddressInfoDetails().getCountry().equals("")) {
			str.append("Country es vacio,");
		}
		StringTokenizer st13 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getAddressInfoDetails()
				.getCountry());
		if (st13.countTokens() > 40){
			str.append("Country no cumple el tamaño requerido 40 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation().getPhoneNumber()
				.equals("")) {
			str.append("PhoneNumber es vacio,");
		}
		StringTokenizer st14 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getPhoneNumber());
		if (st14.countTokens() > 20){
			str.append("PhoneNumber no cumple el tamaño requerido 20 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation().getDateOfBirth()
				.toGregorianCalendar().getTime().equals("")) {
			str.append("PhoneNumber es vacio,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation().getCustomerType()
				.equals("")) {
			str.append("CustomerType es vacio,");
		}
		StringTokenizer st16 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getCustomerType());
		if (st16.countTokens() > 50)
		{
			str.append("CustomerType no cumple el tamaño requerido 50 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation()
				.getCustomerSubtype().equals("")) {
			str.append("CustomerSubtype es vacio,");
		}
		StringTokenizer st17 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getCustomerSubtype());
		if (st17.countTokens() > 50)
		{
			str.append("CustomerSubtype no cumple el tamaño requerido 50 posiciones,");
		}
		if (lightCreditEvaluation.getCreditScoreInformation().getCustomerId()
				.equals("")) {
			str.append("CustomerId es vacio,");
		}
		StringTokenizer st18 = new StringTokenizer(lightCreditEvaluation
				.getCreditScoreInformation().getCustomerId());
		if (st18.countTokens() > 20)
		{
			str.append("CustomerId no cumple el tamaño requerido 20 posiciones,");
		}
		if (lightCreditEvaluation.getAccreditationInfo().getAccreditationType()
				.equals("")) {
			str.append("getAccreditationType es vacio,");
		}
		StringTokenizer st19 = new StringTokenizer(lightCreditEvaluation
				.getAccreditationInfo().getAccreditationType());
		if (st19.countTokens() > 50)
		{
			str.append("AccreditationType no cumple el tamaño requerido 50 posiciones,");
		}
		if (lightCreditEvaluation.getAccreditationInfo()
				.getOnBehalfSaleChannel().equals("")) {
			str.append("OnBehalfSaleChannel es vacio,");
		}
		StringTokenizer st20 = new StringTokenizer(lightCreditEvaluation
				.getAccreditationInfo().getOnBehalfSaleChannel());
		if (st20.countTokens() > 50)
		{
			str.append("OnBehalfSaleChannel no cumple el tamaño requerido 50 posiciones,");
		}
		for (AccreditationData accData : lightCreditEvaluation
				.getAccreditationInfo().getAccreditationData()) {
			if (accData.getAccreditationValue().equals("")) {
				str.append("AccrValue esta vacio");
			}
			if (accData.getAccreditationValue().length() > 100) {
				str.append("AccrValue no cumple con lo máximo de 100 posiciones");
			}
			if (accData.getAccreditationName().equals("")) {
				str.append("AccrValue esta vacio");
			}
			if (accData.getAccreditationName().length() > 1) {
				str.append("AccrValue no cumple con lo máximo de 1 posiciones");
			}

		}
		for (AccreditationDocument accDocu : lightCreditEvaluation
				.getAccreditationInfo().getAccreditationDocuments()) {
			if (accDocu.getDocumentName().equals("")) {
				str.append("AccrValue esta vacio");
			}
			if (accDocu.getDocumentName().length() > 100) {
				str.append("AccrValue no cumple con lo máximo de 100 posiciones");
			}
		}
		if (lightCreditEvaluation.getAffiliateInformation().getAffiliate()
				.equals("")) {
			str.append("getAffiliate es vacio,");
		}
		StringTokenizer st23 = new StringTokenizer(lightCreditEvaluation
				.getAffiliateInformation().getAffiliate());
		if (st23.countTokens() > 30)
		{
			str.append("Affiliate no cumple el tamaño requerido 30 posiciones,");
		}
		if (lightCreditEvaluation.getAffiliateInformation().getMarket()
				.equals("")) {
			str.append("Market es vacio,");
		}
		StringTokenizer st24 = new StringTokenizer(lightCreditEvaluation
				.getAffiliateInformation().getMarket());
		if (st24.countTokens() > 30)
		{
			str.append("Market no cumple el tamaño requerido 30 posiciones,");
		}

//		if (lightCreditEvaluation.getCreditApprovalID().equals("")) {
//			str.append("AccreditationValue es vacio,");
//		}
		StringTokenizer st28 = new StringTokenizer(
				lightCreditEvaluation.getCreditApprovalID());
		if (st28.countTokens() > 15)
		{
			str.append("AccreditationValue no cumple el tamaño requerido 1 posiciones,");
		}
		for (BiometricValidation biometric : lightCreditEvaluation
				.getBiometricValidation()) {
			if (biometric.getType().equals("")) {
				str.append("Type esta vacio");
			}
			if (biometric.getType().length() > 1) {
				str.append("Type no cumple con lo máximo de 1 posiciones");
			}
		}
		return str;
	}

	public static StringBuilder validateAmdocs(AmdocsTO amdocs) {

		StringBuilder strBld = new StringBuilder();

		if (amdocs.getClienteAntiguo().equals("")) {
			strBld.append("ClienteAntiguo es vacio,");
		}
		StringTokenizer st1 = new StringTokenizer(amdocs.getClienteAntiguo());
		if (st1.countTokens() > 1) {
			strBld.append("ClienteAntiguo no cumple el tamaño requerido 1 posiciones,");
		}
		if (amdocs.getAntiguedaLineasAct().equals("")) {
			strBld.append("AntiguedaLineasAct es vacio,");
		}
		StringTokenizer st2 = new StringTokenizer(amdocs
				.getAntiguedaLineasAct().toString());														
														
		if (st2.countTokens() > 10) {
			strBld.append("AntiguedaLineasAct no cumple el tamaño requerido 10 posiciones,");
		}
		if (amdocs.getDeudaVencida().equals("")) {
			strBld.append("DeudaVencida es vacio,");
		}
		StringTokenizer st3 = new StringTokenizer(amdocs.getDeudaVencida()
				.toString());
		if (st3.countTokens() > 20) {
			strBld.append("DeudaVencida no cumple el tamaño requerido 20 posiciones,");
		}
		if (amdocs.getNotaComportamiento().equals("")) {
			strBld.append("NotaComportamiento es vacio,");
		}
		StringTokenizer st4 = new StringTokenizer(
				amdocs.getNotaComportamiento());
		if (st4.countTokens() > 5) {
			strBld.append("NotaComportamiento no cumple el tamaño requerido 10 posiciones,");
		}
		if (amdocs.getCantLineasAct().equals("")) {
			strBld.append("CantLineasAct es vacio,");
		}
		StringTokenizer st5 = new StringTokenizer(amdocs.getCantLineasAct()
				.toString());
		if (st5.countTokens() > 5) {
			strBld.append("CantLineasAct no cumple el tamaño requerido 5 posiciones,");
		}
		if (amdocs.getPagoRecurrenteAct().equals("")) {
			strBld.append("PagoRecurrenteAct es vacio,");
		}
		StringTokenizer st6 = new StringTokenizer(amdocs.getPagoRecurrenteAct()
				.toString());
		if (st6.countTokens() > 5) {
			strBld.append("PagoRecurrenteAct no cumple el tamaño requerido 5 posiciones,");
		}

		return strBld;
	}

	public StringBuilder validatePrevired(PreviredTO previred) {

		StringBuilder strBldr = new StringBuilder();

		if (previred.getPrevContinuidadLaboral().equals("")) {
			strBldr.append("PrevContinuidadLaboral es vacio,");
		}
		StringTokenizer st1 = new StringTokenizer(
				previred.getPrevContinuidadLaboral());
		if (st1.countTokens() > 1) {
			strBldr.append("PrevContinuidadLaboral no cumple el tamaño requerido 1 posiciones,");
		}

		return strBldr;
	}

	public StringBuilder validatePlusGold(PlusGoldTO plusGold) {

		StringBuilder strBldr = new StringBuilder();

		if (plusGold.getSubsistema00().getMontImpa().equals("")) {
			strBldr.append("MontImpa es vacio,");
		}
		StringTokenizer st1 = new StringTokenizer(plusGold.getSubsistema00()
				.getMontImpa().toString());
		if (st1.countTokens() > 1) {
			strBldr.append("MontImpa no cumple el tamaño requerido 1 posiciones,");
		}
		if (plusGold.getSubsistema03().getCaliExpl().equals("")) {
			strBldr.append("CaliExpl es vacio,");
		}
		StringTokenizer st2 = new StringTokenizer(plusGold.getSubsistema03()
				.getCaliExpl().toString());
		if (st2.countTokens() > 5) {
			strBldr.append("CaliExpl no cumple el tamaño requerido 5 posiciones,");
		}
		if (plusGold.getSubsistema05().getTultImpa().equals("")) {
			strBldr.append("TultImpa es vacio,");
		}
		StringTokenizer st3 = new StringTokenizer(plusGold.getSubsistema05()
				.getTultImpa().toString());
		if (st3.countTokens() > 5) {
			strBldr.append("TultImpa no cumple el tamaño requerido 5 posiciones,");
		}
		if (plusGold.getSubsistema10().getListDetSubSistema10().isEmpty()) {
			strBldr.append("ListDetSubSistema10 la lista esta vacia");
		}
		for (DetSubsistema10TO detalleSubSis10 : plusGold.getSubsistema10()
				.getListDetSubSistema10()) {
			if (detalleSubSis10.getFechImpa() > 0) {
				strBldr.append("Type esta vacio");
			}
		}

		return strBldr;
	}

	public static StringBuilder validateEquifax(EquifaxTO equifax) {

		StringBuilder strBldr = new StringBuilder();

		if (equifax.getAutorizacion().equals("")) {
			strBldr.append("Autorizacion es vacio,");
		}
		StringTokenizer st1 = new StringTokenizer(equifax.getAutorizacion());
		if (st1.countTokens() > 1) {
			strBldr.append("Autorizacion no cumple el tamaño requerido 1 posiciones,");
		}
		for (EquifaxDetalleTO detalleEquifax : equifax.getListEquifaxDetalle()) {
			if (detalleEquifax.getAutorizado().length() > 1) {
				strBldr.append("Autorizado esta vacio,");
			}
			if (detalleEquifax.getCodigoRespuesta().length() > 3) {
				strBldr.append("CodigoRespuesta esta vacio,");
			}
			if (detalleEquifax.getCodigoRechazo().length() > 3) {
				strBldr.append("CodigoRespuesta esta vacio");
			}
		}

		return strBldr;
	}
}

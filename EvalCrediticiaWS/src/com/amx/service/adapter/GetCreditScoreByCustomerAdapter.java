package com.amx.service.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;

import org.apache.log4j.Logger;

import com.amx.service.bean.ADDRInfoDetTO;
import com.amx.service.bean.AccrdocumentTO;
import com.amx.service.bean.AccreditationDataTO;
import com.amx.service.bean.BiomTO;
import com.amx.service.bean.EntLceTO;
import com.amx.service.bean.NlineSallopGaptTO;
import com.amx.service.bean.SalLceTO;

import cl.clarochile.aplicaciones.evalcrediticia.getcreditscorebycustomer.estructura.AccreditationData;
import cl.clarochile.aplicaciones.evalcrediticia.getcreditscorebycustomer.estructura.AccreditationDocument;
import cl.clarochile.aplicaciones.evalcrediticia.getcreditscorebycustomer.estructura.BiometricValidation;
import cl.clarochile.aplicaciones.evalcrediticia.getcreditscorebycustomer.estructura.GetCreditScoreByCustomerRequest;
import cl.clarochile.aplicaciones.evalcrediticia.getcreditscorebycustomer.estructura.GetCreditScoreByCustomerResponse;
import cl.clarochile.aplicaciones.evalcrediticia.getcreditscorebycustomer.estructura.GetCreditScoreResponseInfo;
import cl.clarochile.aplicaciones.evalcrediticia.getcreditscorebycustomer.estructura.NumberOfLinesAllowedPerGamaAndProductType;

public class GetCreditScoreByCustomerAdapter {

	private static Logger logger = Logger.getLogger(GetCreditScoreByCustomerAdapter.class);

	public static EntLceTO typeToBean(GetCreditScoreByCustomerRequest creditScore) {

		EntLceTO response = new EntLceTO();
		Integer usuario = Integer.parseInt(creditScore.getCreditScoreInformation().getDealerId());
		response.setUsuario(usuario);

		List<AccreditationData> listaAcreditD = new ArrayList<AccreditationData>();
		listaAcreditD = creditScore.getAccreditationInfo().getAccreditationData();
		List<AccreditationDataTO> listdata = new ArrayList<AccreditationDataTO>();

		for (AccreditationData accr : listaAcreditD) {
			AccreditationDataTO data = new AccreditationDataTO();
			data.setUsuario(usuario);
			data.setAccrName(accr.getAccreditationName());
			data.setAccrValue(accr.getAccreditationValue());
			listdata.add(data);
		}
		response.getAccrInfo().getAccrData().addAll(listdata);

		// response.getAccrInfo ya realize este objeto

		List<AccreditationDocument> listaAcreditDoc = new ArrayList<AccreditationDocument>();
		listaAcreditDoc = creditScore.getAccreditationInfo().getAccreditationDocuments();
		List<AccrdocumentTO> listDoc = new ArrayList<AccrdocumentTO>();
		for (AccreditationDocument accr : listaAcreditDoc) {
			AccrdocumentTO data = new AccrdocumentTO();
			data.setUsuario(usuario);
			data.setDocCategory(accr.getDocumentCategory());
			data.setDocName(accr.getDocumentName());
			data.setDocType(accr.getDocumentType());
			listDoc.add(data);
		}
		response.getAccrInfo().getAccrdocumentTO().addAll(listDoc);

		response.getAccrInfo().setOnBehalf(creditScore.getAccreditationInfo().getOnBehalfSaleChannel());
		response.getAccrInfo().setAccrType(creditScore.getAccreditationInfo().getAccreditationType());
		response.getAccrInfo().setUsuario(usuario);

		// response.getAccrInfo ya realize este objeto

		response.getAffInfo().setAffiliate(creditScore.getAffiliateInformation().getAffiliate());
		response.getAffInfo().setMarket(creditScore.getAffiliateInformation().getMarket());
		response.getAffInfo().setUsuario(usuario);

		// ya se realizo este objeto

		response.getCredScoreInfo().setOrderID(creditScore.getCreditScoreInformation().getOrderId());
		response.getCredScoreInfo().setCredRefNumber(creditScore.getCreditScoreInformation().getCreditRefNumber());
		response.getCredScoreInfo().setSaleChannel(creditScore.getCreditScoreInformation().getSalesChannel());
		response.getCredScoreInfo().setLocation(creditScore.getCreditScoreInformation().getLocation());
		response.getCredScoreInfo().setDealerOnBehalf(creditScore.getCreditScoreInformation().getDealerOnBehalf());
		response.getCredScoreInfo().setDealerId(creditScore.getCreditScoreInformation().getDealerId());
		response.getCredScoreInfo().setUserId(creditScore.getCreditScoreInformation().getUserId());
		response.getCredScoreInfo().setRegion(creditScore.getCreditScoreInformation().getRegion());
		response.getCredScoreInfo().setIdenNumber(creditScore.getCreditScoreInformation().getIdentifierNumber());
		response.getCredScoreInfo().setIdenType(creditScore.getCreditScoreInformation().getIdentifierType());
		response.getCredScoreInfo().setFirstName(creditScore.getCreditScoreInformation().getFirstName());
		response.getCredScoreInfo().setLastName(creditScore.getCreditScoreInformation().getLastName());

		if (creditScore.getCreditScoreInformation().isCreditCheckApproved()) {
			response.getCredScoreInfo().setCredCheckapprovel("S");
		} else {
			response.getCredScoreInfo().setCredCheckapprovel("N");
		}

		if (creditScore.getCreditScoreInformation().isNuncaIndication()) {
			response.getCredScoreInfo().setNuncaIndication("S");
		} else {
			response.getCredScoreInfo().setNuncaIndication("N");
		}

		if (creditScore.getCreditScoreInformation().isVipIndication()) {
			response.getCredScoreInfo().setvIPIndication("S");
		} else {
			response.getCredScoreInfo().setvIPIndication("N");
		}

		ADDRInfoDetTO addrInfoDetTO = new ADDRInfoDetTO();
		addrInfoDetTO.setAddrText(creditScore.getCreditScoreInformation().getAddressInfoDetails().getAddressText());
		addrInfoDetTO.setCity(creditScore.getCreditScoreInformation().getAddressInfoDetails().getCity());
		addrInfoDetTO.setDistric(creditScore.getCreditScoreInformation().getAddressInfoDetails().getDistrict());
		addrInfoDetTO.setState(creditScore.getCreditScoreInformation().getAddressInfoDetails().getState());
		addrInfoDetTO.setCostCenterRegion(creditScore.getCreditScoreInformation().getAddressInfoDetails().getCostCenterRegion());
		addrInfoDetTO.setCountry(creditScore.getCreditScoreInformation().getAddressInfoDetails().getCountry());
		addrInfoDetTO.setArea(creditScore.getCreditScoreInformation().getAddressInfoDetails().getArea());
		addrInfoDetTO.setQuarter(creditScore.getCreditScoreInformation().getAddressInfoDetails().getQuarter());
		addrInfoDetTO.setStName(creditScore.getCreditScoreInformation().getAddressInfoDetails().getStreetName());
		addrInfoDetTO.setStType(creditScore.getCreditScoreInformation().getAddressInfoDetails().getStreetType());
		addrInfoDetTO.setStSuffix(creditScore.getCreditScoreInformation().getAddressInfoDetails().getStreetSuffix());
		addrInfoDetTO.setStPrefix(creditScore.getCreditScoreInformation().getAddressInfoDetails().getStreetPrefix());
		addrInfoDetTO.setStNumber(creditScore.getCreditScoreInformation().getAddressInfoDetails().getStreetNumber());
		addrInfoDetTO.setStIntersection(creditScore.getCreditScoreInformation().getAddressInfoDetails().getStreetIntersection());
		addrInfoDetTO.setStIntersectionSuffix(creditScore.getCreditScoreInformation().getAddressInfoDetails().getStreetIntersectionSuffix());
		addrInfoDetTO.setAddiInfo(creditScore.getCreditScoreInformation().getAddressInfoDetails().getAdditionalInfo());
		addrInfoDetTO.setBuildType(creditScore.getCreditScoreInformation().getAddressInfoDetails().getBuildingType());
		addrInfoDetTO.setBuildNumber(creditScore.getCreditScoreInformation().getAddressInfoDetails().getBuildingNumber());
		addrInfoDetTO.setIntBuildingNumber(creditScore.getCreditScoreInformation().getAddressInfoDetails().getInternalBuildingNumber());
		addrInfoDetTO.setIntBuildingNumberSuffix(creditScore.getCreditScoreInformation().getAddressInfoDetails().getInternalBuildingNumberSuffix());
		addrInfoDetTO.setAptNumber(creditScore.getCreditScoreInformation().getAddressInfoDetails().getApartmentNumber());
		addrInfoDetTO.setTotalNumOffLoors(creditScore.getCreditScoreInformation().getAddressInfoDetails().getTotalNumOfFloors());
		addrInfoDetTO.setNeighborhood(creditScore.getCreditScoreInformation().getAddressInfoDetails().getNeighborhood());
		addrInfoDetTO.setPoBox(creditScore.getCreditScoreInformation().getAddressInfoDetails().getPoBox());
		addrInfoDetTO.setPostalCode(creditScore.getCreditScoreInformation().getAddressInfoDetails().getPostalCode());
		addrInfoDetTO.setSocioEconomicalRank(creditScore.getCreditScoreInformation().getAddressInfoDetails().getSocioEconomicalRank());
		addrInfoDetTO.setCodUsuarioAlta(usuario);

		response.getCredScoreInfo().setCodUsuarioAlta(usuario);
		response.getCredScoreInfo().setDireccionInfo(addrInfoDetTO);
		response.getCredScoreInfo().setOaType(creditScore.getCreditScoreInformation().getOaType());
		response.getCredScoreInfo().setPhoneNumber(creditScore.getCreditScoreInformation().getPhoneNumber());

		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("DD-MM-YYYY");
			response.getCredScoreInfo().setDateBirth(formatoFecha.parse(creditScore.getCreditScoreInformation().getDateOfBirth().toString()));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		response.getCredScoreInfo().setCustType(creditScore.getCreditScoreInformation().getCustomerType());
		response.getCredScoreInfo().setCustSubtype(creditScore.getCreditScoreInformation().getCustomerSubtype());
		response.getCredScoreInfo().setCustId(creditScore.getCreditScoreInformation().getCustomerId());

		// ya se hizo credit proval id

		response.setCredApprovalid(creditScore.getCreditApprovalID());

		// Ya se realizo la lista de Biometria solo queda revizarla

		List<BiometricValidation> listaBiomValidation = new ArrayList<BiometricValidation>();
		listaBiomValidation = creditScore.getBiometricValidation();
		List<BiomTO> lstBiomTO = new ArrayList<BiomTO>();
		for (BiometricValidation bion : listaBiomValidation) {
			BiomTO biomVar = new BiomTO();
			biomVar.setUsuario(usuario);
			biomVar.setAuditNumber(bion.getAuditNumber());
			biomVar.setErrorCode(bion.getErrorCode());
			biomVar.setErrorDesc(bion.getErrorDesc());
			biomVar.setIsPrevire(bion.getIsPreviredAllowed());
			biomVar.setType(bion.getType());
			lstBiomTO.add(biomVar);
		}
		response.getListBiom().addAll(lstBiomTO);

		return response;
	}

	public static GetCreditScoreByCustomerResponse beanToType(SalLceTO object) {

		GetCreditScoreByCustomerResponse response = new GetCreditScoreByCustomerResponse();
		GregorianCalendar c = new GregorianCalendar();

		
		response.setNumberOfFinancedActiveLines(object.getNumbOffinancedActiveLines());
		
		GetCreditScoreResponseInfo getCredit = new GetCreditScoreResponseInfo();
		getCredit.setAcquisitionType(object.getCredScoreResInfo().getAcquType());
		getCredit.setAgeRange(object.getCredScoreResInfo().getAgeRange());
		getCredit.setCeRejectMessage(object.getCredScoreResInfo().getCeRejectMEessage());
		getCredit.setCreditRefNumber(object.getCredScoreResInfo().getCerdRefNumber());
		getCredit.setCreditScoreCode(object.getCredScoreResInfo().getCredScoreCode());
		getCredit.setCreditScoreDescription(object.getCredScoreResInfo().getCredScoreDescription());
		response.setReglasAplicadas(object.getReglas());

		try {

			c.setTime(object.getCredScoreResInfo().getDateCredBureaouConsulted());
			getCredit.setDateCreditBureauConsulted(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));

			c.setTime(object.getCredScoreResInfo().getIdExpirationDate());
			getCredit.setIdExpirationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));

			c.setTime(object.getCredScoreResInfo().getIssueDateofid());
			getCredit.setIssueDateOfId(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));

			c.setTime(object.getCredScoreResInfo().getScoreExpiryDate());
			getCredit.setScoreExpiryDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		if (object.getCredScoreResInfo().getEquiInmediatePaymentRequired().equals("S")) {
			getCredit.setEquipmentImmediatePaymentRequired(true);
		} else {
			getCredit.setEquipmentImmediatePaymentRequired(false);
		}
		if (object.getCredScoreResInfo().getEvidAlreadyValid() == "S") {
			getCredit.setEvidentaAlreadyValid(true);
		} else {
			getCredit.setEvidentaAlreadyValid(false);
		}
		if (object.getCredScoreResInfo().getPayMeansRequired() == "S") {
			getCredit.setPayMeansRequired(true);
		} else {
			getCredit.setPayMeansRequired(false);
		}
		if (object.getCredScoreResInfo().getRcPaymentinaVancedRequied() == "S") {
			getCredit.setRcPaymentInAdvancedRequired(true);
		} else {
			getCredit.setRcPaymentInAdvancedRequired(false);
		}

		getCredit.setEvaluationStatus(object.getCredScoreResInfo().getEvaStatus());
		getCredit.setFirstName(object.getCredScoreResInfo().getFistName());
		getCredit.setGama(object.getCredScoreResInfo().getGama());
		getCredit.setIdPlaceOfIssue(object.getCredScoreResInfo().getIdPlaceOfissue());
		getCredit.setLastName(object.getCredScoreResInfo().getLastName());
		getCredit.setPastDueAmount(object.getCredScoreResInfo().getPastDueamount());
		getCredit.setPaymentBehavior(object.getCredScoreResInfo().getPaynBehavior());
		getCredit.setPlanType(object.getCredScoreResInfo().getPlanType());
		getCredit.setPurchaseLimit(object.getCredScoreResInfo().getPurcLimit());
		getCredit.setSecondLastName(object.getCredScoreResInfo().getSecondLastName());
		getCredit.setSecondName(object.getCredScoreResInfo().getSecondName());
		getCredit.setTotalNumberOfLines(object.getCredScoreResInfo().getTotalNumerRofline());
		getCredit.setUrl(object.getCredScoreResInfo().getUrl());
		response.setGetCreditScoreResponseInfo(getCredit);

		List<NlineSallopGaptTO> listaNumberLineTo = new ArrayList<NlineSallopGaptTO>();
		listaNumberLineTo = object.getNumOfLinAllowedPerGamaAndPro();
		List<NumberOfLinesAllowedPerGamaAndProductType> lstNumberLineType = new ArrayList<NumberOfLinesAllowedPerGamaAndProductType>();
		for (NlineSallopGaptTO number : listaNumberLineTo) {
			NumberOfLinesAllowedPerGamaAndProductType numberOfLines = new NumberOfLinesAllowedPerGamaAndProductType();
			numberOfLines.setGama(number.getGama());
			numberOfLines.setProductType(number.getProdType());
			numberOfLines.setTotalNumberOfLinesAllowed(number.getTotalNumbLineSallowed());
			lstNumberLineType.add(numberOfLines);
		}
		response.getNumberOfLinesAllowedPerGamaAndProductType().addAll(lstNumberLineType);

		return response;
	}

}

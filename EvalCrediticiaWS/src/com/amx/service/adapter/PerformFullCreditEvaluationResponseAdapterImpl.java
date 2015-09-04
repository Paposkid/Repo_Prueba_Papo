package com.amx.service.adapter;

import java.util.ArrayList;
import java.util.List;

import com.amx.service.bean.ADDRInfoDetTO;
import com.amx.service.bean.AffiinformationTO;
import com.amx.service.bean.AttrdifinfoTO;
import com.amx.service.bean.ChargesinfoTO;
import com.amx.service.bean.CompdifinfoTO;
import com.amx.service.bean.ConditionFCETO;
import com.amx.service.bean.ContactInfoTO;
import com.amx.service.bean.CredScoreInfoTO;
import com.amx.service.bean.EntFceTO;
import com.amx.service.bean.OrderactionTO;
import com.amx.service.bean.ProductTO;
import com.amx.service.bean.SalFceTO;

import cl.clarochile.aplicaciones.evalcrediticia.performfullcreditevaluation.estructura.AttributeDiffInfo;
import cl.clarochile.aplicaciones.evalcrediticia.performfullcreditevaluation.estructura.ChangesInfo;
import cl.clarochile.aplicaciones.evalcrediticia.performfullcreditevaluation.estructura.ComponentDiffInfo;
import cl.clarochile.aplicaciones.evalcrediticia.performfullcreditevaluation.estructura.Conditions;
import cl.clarochile.aplicaciones.evalcrediticia.performfullcreditevaluation.estructura.PerformFullCreditEvaluationRequest;
import cl.clarochile.aplicaciones.evalcrediticia.performfullcreditevaluation.estructura.PerformFullCreditEvaluationResponse;
import cl.clarochile.aplicaciones.evalcrediticia.performfullcreditevaluation.estructura.ProductDiffInfo;

public class PerformFullCreditEvaluationResponseAdapterImpl {

	public static PerformFullCreditEvaluationResponse datosCasoBeanToType(
			SalFceTO object) {

		PerformFullCreditEvaluationResponse response = new PerformFullCreditEvaluationResponse();
		response.setStatus(object.getStatus());
		response.setDescription(object.getDescription());
		response.getExceptions().addAll(object.getExceptions());
		response.setCreditRefNumber(object.getCreditRefNumber());

		if (object.getHomeVisitRequired().equals("S")) {
			response.setHomeVisitRequired(true);
		} else {
			response.setHomeVisitRequired(false);
		}
		if (object.getIsOverrideImmediatePayment().equals("S")) {
			response.setIsOverrideImmediatePayment(true);
		} else {
			response.setIsOverrideImmediatePayment(false);
		}

		List<ConditionFCETO> condFceto = new ArrayList<ConditionFCETO>();
		condFceto = object.getConditions();
		List<Conditions> lstConditions = new ArrayList<Conditions>();
		for (ConditionFCETO cond : condFceto) {
			Conditions miConditions = new Conditions();
			miConditions.setDeposit(cond.getDeposit());
			miConditions.setInstallmentAmount(cond.getAmount());
			miConditions.setInstallmentZero(cond.getInstZero());
			miConditions.setNumOfInstallments(cond.getCantCuotas());
			miConditions.setNumRCInAdvanced(cond.getMesesAdelanto());
			miConditions.setOrderActionId(cond.getCodOrdenActionInfo()
					.toString());
			lstConditions.add(miConditions);
		}
		response.setReglasAplicadas(object.getReglas());
		response.getConditions().addAll(lstConditions);
		response.getDocuments().addAll(object.getDocuments());
		response.getExtraDocuments().addAll(object.getExtraDocuments());
		response.setCreditApprovalIDOutput(object.getCreditApprovalIDOutput());

		return response;
	}

	public static EntFceTO casoRequestTypeToBean(
			PerformFullCreditEvaluationRequest objeto) {

		EntFceTO response = new EntFceTO();
		Integer usuario = Integer.parseInt(objeto.getCreditScoreInformation()
				.getDealerId());
		// producto
		List<ProductTO> listProd = new ArrayList<ProductTO>();
		List<ProductDiffInfo> listObjectProd = objeto.getProductDiffInfo();

		for (ProductDiffInfo productDiffInfo : listObjectProd) {
			ProductTO product = new ProductTO();
			product.setUsuario(usuario);

			product.setOfferName(productDiffInfo.getOffername());
			product.setSumCurrentrc(productDiffInfo.getSumOfCurrentRC());
			product.setSumOc(productDiffInfo.getSumOfOC());
			product.setCampId(productDiffInfo.getCampaignId());
			product.setCampDescription(productDiffInfo.getCampaignDescription());

			OrderactionTO orderaction = new OrderactionTO();

			orderaction.setOaSrd(productDiffInfo.getOrderActionInfo()
					.getOasrd().toGregorianCalendar().getTime());
			orderaction.setOrderActionid(productDiffInfo.getOrderActionInfo()
					.getOrderActionId());
			orderaction.setOrderActiontype(productDiffInfo.getOrderActionInfo()
					.getOrderActionType());
			orderaction.setUsuario(usuario);

			ContactInfoTO contactInfo = new ContactInfoTO();

			// contactInfo.setAddress(productDiffInfo.getOrderActionInfo().getContactInformation().ge);
			contactInfo.setAddrId(productDiffInfo.getOrderActionInfo()
					.getContactInformation().getAddressId());
			contactInfo.setBirthDate(productDiffInfo.getOrderActionInfo()
					.getContactInformation().getBirthDate()
					.toGregorianCalendar().getTime());
			contactInfo.setBusiPhone(productDiffInfo.getOrderActionInfo()
					.getContactInformation().getBusinessPhone());
			contactInfo.setContId(productDiffInfo.getOrderActionInfo()
					.getContactInformation().getContactID());
			contactInfo.setCorrUsuarioAlta(usuario);
			contactInfo.setFistName(productDiffInfo.getOrderActionInfo()
					.getContactInformation().getFirstName());
			contactInfo.setHomePhone(productDiffInfo.getOrderActionInfo()
					.getContactInformation().getHomePhone());
			contactInfo.setIdenNumber(productDiffInfo.getOrderActionInfo()
					.getContactInformation().getIdentifierNumber());
			contactInfo.setIdenType(productDiffInfo.getOrderActionInfo()
					.getContactInformation().getIdentifierType());
			contactInfo.setLastName(productDiffInfo.getOrderActionInfo()
					.getContactInformation().getLastName());
			contactInfo.setMobilPhone(productDiffInfo.getOrderActionInfo()
					.getContactInformation().getMobilePhone());
			contactInfo.setNunca(productDiffInfo.getOrderActionInfo()
					.getContactInformation().getNUNCA());
			List<String> lstTitle = new ArrayList<String>();
			for (String ds : productDiffInfo.getOrderActionInfo()
					.getContactInformation().getTitle()) {
				lstTitle.add(ds);
			}
			contactInfo.getListTittle().addAll(lstTitle);
			contactInfo.setVip(productDiffInfo.getOrderActionInfo()
					.getContactInformation().getVIP());//

			orderaction.setContactInfo(contactInfo);
			product.setOrderAction(orderaction);//

			List<CompdifinfoTO> listCompInfo = new ArrayList<CompdifinfoTO>();
			List<ComponentDiffInfo> listObjectComp = productDiffInfo
					.getComponentDiffInfoList();
			for (ComponentDiffInfo componentDiffInfo : listObjectComp) {
				CompdifinfoTO compdifinfoTO = new CompdifinfoTO();
				compdifinfoTO.setUsuario(usuario);
				compdifinfoTO = guardarListas(componentDiffInfo, usuario);
				listCompInfo.add(compdifinfoTO);
			}
			product.getComponent().addAll(listCompInfo);
			listProd.add(product);

		}
		response.getProducto().addAll(listProd);//

		// afiliado
		AffiinformationTO affiinformationTO = new AffiinformationTO();
		affiinformationTO.setUsuario(usuario);
		affiinformationTO.setMarket(objeto.getAffiliateInformation().getMarket());
		affiinformationTO.setAffiliate(objeto.getAffiliateInformation().getAffiliate());
		
		response.setAfiliado(affiinformationTO);

		// credScoreInfo
		CredScoreInfoTO credScoreInfoTO = new CredScoreInfoTO();
		credScoreInfoTO.setCodUsuarioAlta(usuario);
		credScoreInfoTO.setOrderID(objeto.getCreditScoreInformation().getOrderId());
		credScoreInfoTO.setOaType(objeto.getCreditScoreInformation().getOaType());

		if (objeto.getCreditScoreInformation().isCreditCheckApproved()) {
			credScoreInfoTO.setCredCheckapprovel("S");
		} else {
			credScoreInfoTO.setCredCheckapprovel("N");
		}
		
		
		credScoreInfoTO.setCredRefNumber(
				objeto.getCreditScoreInformation().getCreditRefNumber());
		credScoreInfoTO.setSaleChannel(
				objeto.getCreditScoreInformation().getSalesChannel());
		credScoreInfoTO.setLocation(
				objeto.getCreditScoreInformation().getLocation());
		credScoreInfoTO.setDealerOnBehalf(
				objeto.getCreditScoreInformation().getDealerOnBehalf());
		credScoreInfoTO.setDealerId(
				objeto.getCreditScoreInformation().getDealerId());
		credScoreInfoTO.setUserId(
				objeto.getCreditScoreInformation().getUserId());
		credScoreInfoTO.setRegion(
				objeto.getCreditScoreInformation().getRegion());
		credScoreInfoTO.setIdenNumber(
				objeto.getCreditScoreInformation().getIdentifierNumber());
		credScoreInfoTO.setIdenType(
				objeto.getCreditScoreInformation().getIdentifierType());
		credScoreInfoTO.setFirstName(
				objeto.getCreditScoreInformation().getFirstName());
		credScoreInfoTO.setLastName(
				objeto.getCreditScoreInformation().getLastName());

		if (objeto.getCreditScoreInformation().isVipIndication()) {
			credScoreInfoTO.setvIPIndication("S");
		} else {
			credScoreInfoTO.setvIPIndication("N");
		}

		if (objeto.getCreditScoreInformation().isNuncaIndication()) {
			credScoreInfoTO.setNuncaIndication("S");
		} else {
			credScoreInfoTO.setNuncaIndication("N");
		}

		ADDRInfoDetTO addrInfoDetTO = new ADDRInfoDetTO();
		addrInfoDetTO.setCodUsuarioAlta(usuario);
		addrInfoDetTO.setAddrText(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getAddressText());
		addrInfoDetTO.setCity(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getCity());
		addrInfoDetTO.setDistric(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getDistrict());
		addrInfoDetTO.setState(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getState());
		addrInfoDetTO.setCostCenterRegion(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getCostCenterRegion());
		addrInfoDetTO.setCountry(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getCountry());
		addrInfoDetTO.setArea(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getArea());
		addrInfoDetTO.setQuarter(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getQuarter());
		addrInfoDetTO.setStName(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getStreetName());
		addrInfoDetTO.setStType(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getStreetType());
		addrInfoDetTO.setStSuffix(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getStreetSuffix());
		addrInfoDetTO.setStPrefix(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getStreetPrefix());
		addrInfoDetTO.setStNumber(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getStreetNumber());
		addrInfoDetTO.setStIntersection(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getStreetIntersection());
		addrInfoDetTO.setStIntersectionSuffix(objeto
				.getCreditScoreInformation().getAddressInfoDetails()
				.getStreetIntersectionSuffix());
		addrInfoDetTO.setAddiInfo(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getAdditionalInfo());
		addrInfoDetTO.setBuildType(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getBuildingType());
		addrInfoDetTO.setBuildNumber(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getBuildingNumber());
		addrInfoDetTO.setIntBuildingNumber(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getInternalBuildingNumber());
		addrInfoDetTO.setIntBuildingNumberSuffix(objeto
				.getCreditScoreInformation().getAddressInfoDetails()
				.getInternalBuildingNumberSuffix());
		addrInfoDetTO.setAptNumber(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getApartmentNumber());
		addrInfoDetTO.setTotalNumOffLoors(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getTotalNumOfFloors());
		addrInfoDetTO.setNeighborhood(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getNeighborhood());
		addrInfoDetTO.setPoBox(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getPoBox());
		addrInfoDetTO.setPostalCode(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getPostalCode());
		addrInfoDetTO.setSocioEconomicalRank(objeto.getCreditScoreInformation()
				.getAddressInfoDetails().getSocioEconomicalRank());

		credScoreInfoTO.setDireccionInfo(addrInfoDetTO);
		credScoreInfoTO.setPhoneNumber(
				objeto.getCreditScoreInformation().getPhoneNumber());

		credScoreInfoTO.setDateBirth(
				objeto.getCreditScoreInformation().getDateOfBirth()
						.toGregorianCalendar().getTime());
		credScoreInfoTO.setCustType(
				objeto.getCreditScoreInformation().getCustomerType());
		credScoreInfoTO.setCustSubtype(
				objeto.getCreditScoreInformation().getCustomerSubtype());
		credScoreInfoTO.setCustId(
				objeto.getCreditScoreInformation().getCustomerId());

		response.setCredScoreInfo(credScoreInfoTO);
		response.setCredApproValidInput(objeto.getCreditApprovalIDInput());
		response.setUsuario(usuario);

		return response;
	}

	private static CompdifinfoTO guardarListas(
			ComponentDiffInfo componentDiffInfo, Integer usuario) {
		CompdifinfoTO miComp = new CompdifinfoTO();
		CompdifinfoTO elComp;

		List<AttrdifinfoTO> listAttrdifinfo = new ArrayList<AttrdifinfoTO>();
		List<ChargesinfoTO> listChargesinfo = new ArrayList<ChargesinfoTO>();
		List<AttributeDiffInfo> attributeDiffInfoList;
		List<ChangesInfo> changesInfo;
		List<ComponentDiffInfo> listCompo;
		List<CompdifinfoTO> listcompTO = new ArrayList<CompdifinfoTO>();

		if (componentDiffInfo.getSubComponents() == null
				|| componentDiffInfo.getSubComponents().isEmpty()) {

			if (componentDiffInfo.getAttributeDiffInfoList() == null
					|| componentDiffInfo.getAttributeDiffInfoList().isEmpty()) {
				listAttrdifinfo = new ArrayList<AttrdifinfoTO>();
			} else {
				attributeDiffInfoList = componentDiffInfo
						.getAttributeDiffInfoList();
				for (AttributeDiffInfo att : attributeDiffInfoList) {
					AttrdifinfoTO miAtt = new AttrdifinfoTO();
					miAtt.setAccion(att.getDiffAction());
					miAtt.setAntiguoValor(att.getAttributeOldValue());
					miAtt.setNombre(att.getAttributeName());
					miAtt.setIdatributo(att.getAttributePropertyId());
					miAtt.setValor(att.getAttributeValue());
					miAtt.setUsuario(usuario);
					listAttrdifinfo.add(miAtt);
				}

			}
			if (componentDiffInfo.getChangesInfo() == null
					|| componentDiffInfo.getChangesInfo().isEmpty()) {
				listChargesinfo = new ArrayList<ChargesinfoTO>();
			} else {
				changesInfo = componentDiffInfo.getChangesInfo();
				for (ChangesInfo chan : changesInfo) {
					ChargesinfoTO miChan = new ChargesinfoTO();
					miChan.setId(chan.getAPID());
					miChan.setMontoActual(chan.getActualAmount());
					miChan.setRenuncia(chan.getIsWaived());
					miChan.setTipoCarga(chan.getChargeType());
					miChan.setUsuario(usuario);
					listChargesinfo.add(miChan);
				}

			}
			miComp.getListsubComponente().addAll(listcompTO);
			miComp.setAccion(componentDiffInfo.getDiffAction());
			miComp.setCid(componentDiffInfo.getComponentCId());
			miComp.setNombre(componentDiffInfo.getComponentName());
			miComp.setUsuario(usuario);
			miComp.getListChargesinfo().addAll(listChargesinfo);
			miComp.getListAttrdifinfo().addAll(listAttrdifinfo);
			return miComp;

		} else {
			if (componentDiffInfo.getAttributeDiffInfoList() == null
					|| componentDiffInfo.getAttributeDiffInfoList().isEmpty()) {
				listAttrdifinfo = new ArrayList<AttrdifinfoTO>();
			} else {

				attributeDiffInfoList = componentDiffInfo
						.getAttributeDiffInfoList();
				for (AttributeDiffInfo att : attributeDiffInfoList) {

					AttrdifinfoTO miAtt = new AttrdifinfoTO();
					miAtt.setUsuario(usuario);
					miAtt.setAccion(att.getDiffAction());
					miAtt.setAntiguoValor(att.getAttributeOldValue());
					miAtt.setNombre(att.getAttributeName());
					miAtt.setIdatributo(att.getAttributePropertyId());
					miAtt.setValor(att.getAttributeValue());
					listAttrdifinfo.add(miAtt);
				}

			}
			if (componentDiffInfo.getChangesInfo() == null
					|| componentDiffInfo.getChangesInfo().isEmpty()) {

				listChargesinfo = new ArrayList<ChargesinfoTO>();
			} else {
				changesInfo = componentDiffInfo.getChangesInfo();
				for (ChangesInfo chan : changesInfo) {
					ChargesinfoTO miChan = new ChargesinfoTO();
					miChan.setUsuario(usuario);
					miChan.setId(chan.getAPID());
					miChan.setMontoActual(chan.getActualAmount());
					miChan.setRenuncia(chan.getIsWaived());
					miChan.setTipoCarga(chan.getChargeType());
					listChargesinfo.add(miChan);
				}

			}
			listCompo = componentDiffInfo.getSubComponents();
			for (ComponentDiffInfo comp : listCompo) {
				elComp = new CompdifinfoTO();
				elComp = guardarListas(comp, usuario);
				listcompTO.add(elComp);
			}
			miComp.getListsubComponente().addAll(listcompTO);
			miComp.setAccion(componentDiffInfo.getDiffAction());
			miComp.setCid(componentDiffInfo.getComponentCId());
			miComp.setNombre(componentDiffInfo.getComponentName());
			miComp.getListChargesinfo().addAll(listChargesinfo);
			miComp.getListAttrdifinfo().addAll(listAttrdifinfo);
			miComp.setUsuario(usuario);
			return miComp;
		}
	}

}

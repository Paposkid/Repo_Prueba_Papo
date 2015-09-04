package com.amx.service.adapter;

import org.apache.log4j.Logger;

import com.amx.schema.charge.getdocumentcharges.ChargeSelectionInfo;
import com.amx.schema.charge.getdocumentcharges.DocIdInfo;
import com.amx.schema.charge.getdocumentcharges.EntityIdInfo;
import com.amx.schema.charge.getdocumentcharges.GetDocumentChargesRequest;
import com.amx.schema.charge.getdocumentcharges.GetDocumentChargesResponse;
import com.amx.schema.charge.getdocumentcharges.PaginationInfo;
import com.amx.schema.charge.getdocumentcharges.PcnIdInfo;
import com.amx.service.bean.DocumentChargesSalidaTO;
import com.amx.service.bean.DocumentChargesTO;


public class DocumentChargesAdapter {

	private static Logger logger = Logger.getLogger(DocumentChargesAdapter.class);

	public static GetDocumentChargesRequest beanToRequest(DocumentChargesTO documentCharges) throws Exception {

		GetDocumentChargesRequest documentChargesRequest = new GetDocumentChargesRequest();
		ChargeSelectionInfo chargeSelect = new ChargeSelectionInfo();
		DocIdInfo docInfo = new DocIdInfo();
		EntityIdInfo entity = new EntityIdInfo();
		PaginationInfo pagiInfo = new PaginationInfo();
		PcnIdInfo pcnId = new PcnIdInfo(); 

		try {
			if (documentChargesRequest.getChargeSelectionInfo() != null) {
				documentChargesRequest.getChargeSelectionInfo().setBilledChargesIsolated(documentCharges.getChargeSelectionInfo().getBilledChargesIsolated());
				documentChargesRequest.getChargeSelectionInfo().setBilledChargesIsolated(documentCharges.getChargeSelectionInfo().getChargeCode());
				documentChargesRequest.getChargeSelectionInfo().setBilledChargesIsolated(documentCharges.getChargeSelectionInfo().getChargeOrigin());
				documentChargesRequest.getChargeSelectionInfo().setBilledChargesIsolated(documentCharges.getChargeSelectionInfo().getDateRange());
				documentChargesRequest.getChargeSelectionInfo().setBilledChargesIsolated(documentCharges.getChargeSelectionInfo().getRevenueCode());
			} else {
				documentChargesRequest.setChargeSelectionInfo(chargeSelect);
				documentChargesRequest.getChargeSelectionInfo().setBilledChargesIsolated(documentCharges.getChargeSelectionInfo().getBilledChargesIsolated());
				documentChargesRequest.getChargeSelectionInfo().setBilledChargesIsolated(documentCharges.getChargeSelectionInfo().getChargeCode());
				documentChargesRequest.getChargeSelectionInfo().setBilledChargesIsolated(documentCharges.getChargeSelectionInfo().getChargeOrigin());
				documentChargesRequest.getChargeSelectionInfo().setBilledChargesIsolated(documentCharges.getChargeSelectionInfo().getDateRange());
				documentChargesRequest.getChargeSelectionInfo().setBilledChargesIsolated(documentCharges.getChargeSelectionInfo().getRevenueCode());
			}
			if (documentChargesRequest.getDocIdInfo() != null) {
				documentChargesRequest.getDocIdInfo().setDocumentId(documentCharges.getDocIdInfo().getDocumentId());
			}else {
				documentChargesRequest.setDocIdInfo(docInfo);
				documentChargesRequest.getDocIdInfo().setDocumentId(documentCharges.getDocIdInfo().getDocumentId());
			}
			if (documentChargesRequest.getEntityIdInfo() != null) {
				documentChargesRequest.getEntityIdInfo().setEntityId(documentCharges.getEntityIdInfo().getEntityId());
				documentChargesRequest.getEntityIdInfo().setEntityType(documentCharges.getEntityIdInfo().getEntityType());
			}else {
				documentChargesRequest.setEntityIdInfo(entity);
				documentChargesRequest.getEntityIdInfo().setEntityId(documentCharges.getEntityIdInfo().getEntityId());
				documentChargesRequest.getEntityIdInfo().setEntityType(documentCharges.getEntityIdInfo().getEntityType());
			}
			if (documentChargesRequest.getPaginationInfo() != null) {
				documentChargesRequest.getPaginationInfo().setNumberOfRows(documentCharges.getPaginationInfo().getNumberOfRows());
				documentChargesRequest.getPaginationInfo().setPageNumber(documentCharges.getPaginationInfo().getPageNumber());
				documentChargesRequest.getPaginationInfo().setPageSize(documentCharges.getPaginationInfo().getPageSize());
			}else {
				documentChargesRequest.setPaginationInfo(pagiInfo);
				documentChargesRequest.getPaginationInfo().setNumberOfRows(documentCharges.getPaginationInfo().getNumberOfRows());
				documentChargesRequest.getPaginationInfo().setPageNumber(documentCharges.getPaginationInfo().getPageNumber());
				documentChargesRequest.getPaginationInfo().setPageSize(documentCharges.getPaginationInfo().getPageSize());
			}
			if (documentChargesRequest.getPcnIdInfo() != null) {
				documentChargesRequest.getPcnIdInfo().setPayChannelId(documentCharges.getPcnIdInfo().getPayChannelId());
			}else {
				documentChargesRequest.setPcnIdInfo(pcnId);
				documentChargesRequest.getPcnIdInfo().setPayChannelId(documentCharges.getPcnIdInfo().getPayChannelId());
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return documentChargesRequest;
	}

	public static DocumentChargesSalidaTO responseToBean(GetDocumentChargesResponse documentList) throws Exception {

		DocumentChargesSalidaTO documentChargesSalidaTO = new DocumentChargesSalidaTO();
		try {
			
		
			documentChargesSalidaTO.getChargeAllDetailsInfo().setAmountIncludeTax(documentList.getChargeAllDetailsInfo().getAmountIncludeTax());
			documentChargesSalidaTO.getChargeAllDetailsInfo().setTaxRelation(documentList.getChargeAllDetailsInfo().getTaxRelation());
						
			
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return documentChargesSalidaTO;
	}

}

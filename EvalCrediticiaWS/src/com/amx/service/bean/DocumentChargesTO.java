package com.amx.service.bean;

import com.amx.schema.charge.getdocumentcharges.ChargeSelectionInfo;
import com.amx.schema.charge.getdocumentcharges.DocIdInfo;
import com.amx.schema.charge.getdocumentcharges.EntityIdInfo;
import com.amx.schema.charge.getdocumentcharges.PaginationInfo;
import com.amx.schema.charge.getdocumentcharges.PcnIdInfo;

public class DocumentChargesTO {
	
	private DocIdInfo docIdInfo;
	private PcnIdInfo pcnIdInfo;
	private EntityIdInfo entityIdInfo;
	private ChargeSelectionInfo chargeSelectionInfo;
	private PaginationInfo paginationInfo;
	
	
	public DocumentChargesTO() {
		
	}
	public DocIdInfo getDocIdInfo() {
		if (docIdInfo ==null) {
			docIdInfo= new DocIdInfo();
		}
		return docIdInfo;
	}
	public void setDocIdInfo(DocIdInfo docIdInfo) {
		this.docIdInfo = docIdInfo;
	}
	public PcnIdInfo getPcnIdInfo() {
		if (pcnIdInfo==null) {
			pcnIdInfo= new PcnIdInfo();
		}
		return pcnIdInfo;
	}
	public void setPcnIdInfo(PcnIdInfo pcnIdInfo) {
		this.pcnIdInfo = pcnIdInfo;
	}
	public EntityIdInfo getEntityIdInfo() {
		if (entityIdInfo==null) {
			entityIdInfo = new EntityIdInfo();
		}
		return entityIdInfo;
	}
	public void setEntityIdInfo(EntityIdInfo entityIdInfo) {
		this.entityIdInfo = entityIdInfo;
	}
	public ChargeSelectionInfo getChargeSelectionInfo() {
		if (chargeSelectionInfo==null) {
			chargeSelectionInfo = new ChargeSelectionInfo();
		}
		return chargeSelectionInfo;
	}
	public void setChargeSelectionInfo(ChargeSelectionInfo chargeSelectionInfo) {
		this.chargeSelectionInfo = chargeSelectionInfo;
	}
	public PaginationInfo getPaginationInfo() {
		if (paginationInfo==null) {
			paginationInfo= new  PaginationInfo();
		}
		return paginationInfo;
	}
	public void setPaginationInfo(PaginationInfo paginationInfo) {
		this.paginationInfo = paginationInfo;
	}
	@Override
	public String toString() {
		return "DocumentChargesTO [docIdInfo=" + docIdInfo + ", pcnIdInfo="
				+ pcnIdInfo + ", entityIdInfo=" + entityIdInfo
				+ ", chargeSelectionInfo=" + chargeSelectionInfo
				+ ", paginationInfo=" + paginationInfo + "]";
	}
	
	

}

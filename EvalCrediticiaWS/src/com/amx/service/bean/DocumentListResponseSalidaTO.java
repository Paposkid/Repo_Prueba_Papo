package com.amx.service.bean;

import java.util.ArrayList;

import com.amx.schema.billinginquiry.getdocumentlist.DocInfo;
import com.amx.schema.billinginquiry.getdocumentlist.PaginationInfo;

public class DocumentListResponseSalidaTO {
	
	private ArrayList<DocInfo> docInfo;
	private PaginationInfo paginationInfo;
	private Boolean notAssignedAll;
	
	public DocumentListResponseSalidaTO() {
		
	}

	/**
	 * @return the docInfo
	 */
	public ArrayList<DocInfo> getDocInfo() {
		return docInfo;
	}

	/**
	 * @param docInfo the docInfo to set
	 */
	public void setDocInfo(ArrayList<DocInfo> docInfo) {
		this.docInfo = docInfo;
	}

	/**
	 * @return the paginationInfo
	 */
	public PaginationInfo getPaginationInfo() {
		return paginationInfo;
	}

	/**
	 * @param paginationInfo the paginationInfo to set
	 */
	public void setPaginationInfo(PaginationInfo paginationInfo) {
		this.paginationInfo = paginationInfo;
	}

	/**
	 * @return the notAssignedAll
	 */
	public Boolean getNotAssignedAll() {
		return notAssignedAll;
	}

	/**
	 * @param notAssignedAll the notAssignedAll to set
	 */
	public void setNotAssignedAll(Boolean notAssignedAll) {
		this.notAssignedAll = notAssignedAll;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DocumentListResponseSalidaTO [docInfo=" + docInfo
				+ ", paginationInfo=" + paginationInfo + ", notAssignedAll="
				+ notAssignedAll + "]";
	}
	
	

}

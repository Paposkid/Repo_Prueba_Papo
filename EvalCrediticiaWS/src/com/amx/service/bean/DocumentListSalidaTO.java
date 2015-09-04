package com.amx.service.bean;

import java.util.ArrayList;

public class DocumentListSalidaTO {
	
	
	private ArrayList<DocInfoTO> docInfo;
	private PaginationInfoTO paginationInfo;
	private Boolean notAssignedAll;
	
	public DocumentListSalidaTO() {
		
	}
	/**
	 * @return the docInfo
	 */
	public ArrayList<DocInfoTO> getDocInfo() {
		if (docInfo == null) {
	        docInfo = new ArrayList<DocInfoTO>();
	    }
		return docInfo;
	}
	/**
	 * @param docInfo the docInfo to set
	 */
	public void setDocInfo(ArrayList<DocInfoTO> docInfo) {
		this.docInfo = docInfo;
	}
	/**
	 * @return the paginationInfo
	 */
	public PaginationInfoTO getPaginationInfo() {
		if (paginationInfo==null) {
			paginationInfo = new PaginationInfoTO();
		}
		return paginationInfo;
	}
	/**
	 * @param paginationInfo the paginationInfo to set
	 */
	public void setPaginationInfo(PaginationInfoTO paginationInfo) {
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
		return "DocumentListSalidaTO [docInfo=" + docInfo + ", paginationInfo="
				+ paginationInfo + ", notAssignedAll=" + notAssignedAll + "]";
	}

	
	
	

}

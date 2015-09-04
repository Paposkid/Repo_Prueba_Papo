package com.amx.service.bean;

public class DocIdInfoTO {
	
	private long documentId;

	public DocIdInfoTO() {
		
	}

	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	@Override
	public String toString() {
		return "DocIdInfoTO [documentId=" + documentId + "]";
	}
	
	

}

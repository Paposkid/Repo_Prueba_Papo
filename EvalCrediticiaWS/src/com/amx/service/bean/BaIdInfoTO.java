package com.amx.service.bean;

public class BaIdInfoTO {
	
	private long baId;

	public BaIdInfoTO() {
		
	}

	public long getBaId() {
		return baId;
	}

	public void setBaId(long baId) {
		this.baId = baId;
	}

	@Override
	public String toString() {
		return "BaIdInfoTO [baId=" + baId + "]";
	}
	
	
}

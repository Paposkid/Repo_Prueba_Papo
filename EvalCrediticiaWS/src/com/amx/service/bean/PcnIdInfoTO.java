package com.amx.service.bean;

public class PcnIdInfoTO {
	
	private Long payChannelId;

	public PcnIdInfoTO() {
		super();
	}

	public Long getPayChannelId() {
		return payChannelId;
	}

	public void setPayChannelId(Long payChannelId) {
		this.payChannelId = payChannelId;
	}

	@Override
	public String toString() {
		return "PcnIdInfoTO [payChannelId=" + payChannelId + "]";
	}
	
	

}

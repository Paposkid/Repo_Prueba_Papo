package com.amx.service.bean;

import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.ApplicationContext;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.MaskInfo;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.OrderingContext;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.RetrieveLineStatisticsInput;

public class RetrieveLineStatisticsTypeTO {
	
	private ApplicationContext arg0;
	private OrderingContext arg1;
	private RetrieveLineStatisticsInput arg2;
	private MaskInfo arg3;
	
	public RetrieveLineStatisticsTypeTO() {
		
	}

	/**
	 * @return the arg0
	 */
	public ApplicationContext getArg0() {
		return arg0;
	}

	/**
	 * @param arg0 the arg0 to set
	 */
	public void setArg0(ApplicationContext arg0) {
		this.arg0 = arg0;
	}

	/**
	 * @return the arg1
	 */
	public OrderingContext getArg1() {
		return arg1;
	}

	/**
	 * @param arg1 the arg1 to set
	 */
	public void setArg1(OrderingContext arg1) {
		this.arg1 = arg1;
	}

	/**
	 * @return the arg2
	 */
	public RetrieveLineStatisticsInput getArg2() {
		return arg2;
	}

	/**
	 * @param arg2 the arg2 to set
	 */
	public void setArg2(RetrieveLineStatisticsInput arg2) {
		this.arg2 = arg2;
	}

	/**
	 * @return the arg3
	 */
	public MaskInfo getArg3() {
		return arg3;
	}

	/**
	 * @param arg3 the arg3 to set
	 */
	public void setArg3(MaskInfo arg3) {
		this.arg3 = arg3;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RetrieveLineStatisticsTypeTO [arg0=" + arg0 + ", arg1=" + arg1
				+ ", arg2=" + arg2 + ", arg3=" + arg3 + "]";
	}

	

	
	
}

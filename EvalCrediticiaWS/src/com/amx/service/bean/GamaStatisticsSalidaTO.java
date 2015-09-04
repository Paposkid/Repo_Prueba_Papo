package com.amx.service.bean;

import java.util.ArrayList;
import java.util.List;


public class GamaStatisticsSalidaTO {
	
	
    private String gamaTypeX11;
    private List<PlanCategoryLineSalidaTO> planCategoryLinesX11;
    private String totalActiveLinesX11;
    private String totalAssignedLinesX11;
    private String totalPendingProvideX11;
    
	public GamaStatisticsSalidaTO() {
		
	}

	/**
	 * @return the gamaTypeX11
	 */
	public String getGamaTypeX11() {
		return gamaTypeX11;
	}

	/**
	 * @param gamaTypeX11 the gamaTypeX11 to set
	 */
	public void setGamaTypeX11(String gamaTypeX11) {
		this.gamaTypeX11 = gamaTypeX11;
	}

	/**
	 * @return the planCategoryLinesX11
	 */
	public List<PlanCategoryLineSalidaTO> getPlanCategoryLinesX11() {
		if (planCategoryLinesX11 == null) {
            planCategoryLinesX11 = new ArrayList<PlanCategoryLineSalidaTO>();
        }
		return planCategoryLinesX11;
	}

	/**
	 * @param planCategoryLinesX11 the planCategoryLinesX11 to set
	 */
	public void setPlanCategoryLinesX11(List<PlanCategoryLineSalidaTO> planCategoryLinesX11) {
		this.planCategoryLinesX11 = planCategoryLinesX11;
	}

	/**
	 * @return the totalActiveLinesX11
	 */
	public String getTotalActiveLinesX11() {
		return totalActiveLinesX11;
	}

	/**
	 * @param totalActiveLinesX11 the totalActiveLinesX11 to set
	 */
	public void setTotalActiveLinesX11(String totalActiveLinesX11) {
		this.totalActiveLinesX11 = totalActiveLinesX11;
	}

	/**
	 * @return the totalAssignedLinesX11
	 */
	public String getTotalAssignedLinesX11() {
		return totalAssignedLinesX11;
	}

	/**
	 * @param totalAssignedLinesX11 the totalAssignedLinesX11 to set
	 */
	public void setTotalAssignedLinesX11(String totalAssignedLinesX11) {
		this.totalAssignedLinesX11 = totalAssignedLinesX11;
	}

	/**
	 * @return the totalPendingProvideX11
	 */
	public String getTotalPendingProvideX11() {
		return totalPendingProvideX11;
	}

	/**
	 * @param totalPendingProvideX11 the totalPendingProvideX11 to set
	 */
	public void setTotalPendingProvideX11(String totalPendingProvideX11) {
		this.totalPendingProvideX11 = totalPendingProvideX11;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GamaStatisticsSalidaTO [gamaTypeX11=" + gamaTypeX11 + ", planCategoryLinesX11=" + planCategoryLinesX11 + ", totalActiveLinesX11=" + totalActiveLinesX11 + ", totalAssignedLinesX11="
				+ totalAssignedLinesX11 + ", totalPendingProvideX11=" + totalPendingProvideX11 + "]";
	}
    
	
    

}

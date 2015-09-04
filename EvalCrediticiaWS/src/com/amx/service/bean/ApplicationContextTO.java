package com.amx.service.bean;



import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.ApplicationContext;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.ApplicationUITYPEXML;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.NavBinding;
import com.amdocs.cih.services.oms.interfaces.retrievelinestatistics.NavigationTYPEXML;

public class ApplicationContextTO {

	private NavBinding enforcedTargetBinding;
	private String forcedTargetSystem;
	private String formatLocale;
	private String initiatorSystemId;
    private ApplicationContext.NavData navData;
    private NavigationTYPEXML navType;
    private String operationDomain;
    private ApplicationUITYPEXML uiType;
    
	public ApplicationContextTO() {
		super();
	}

	/**
	 * @return the enforcedTargetBinding
	 */
	public NavBinding getEnforcedTargetBinding() {
		return enforcedTargetBinding;
	}

	/**
	 * @param enforcedTargetBinding the enforcedTargetBinding to set
	 */
	public void setEnforcedTargetBinding(NavBinding enforcedTargetBinding) {
		this.enforcedTargetBinding = enforcedTargetBinding;
	}

	/**
	 * @return the forcedTargetSystem
	 */
	public String getForcedTargetSystem() {
		return forcedTargetSystem;
	}

	/**
	 * @param forcedTargetSystem the forcedTargetSystem to set
	 */
	public void setForcedTargetSystem(String forcedTargetSystem) {
		this.forcedTargetSystem = forcedTargetSystem;
	}

	/**
	 * @return the formatLocale
	 */
	public String getFormatLocale() {
		return formatLocale;
	}

	/**
	 * @param formatLocale the formatLocale to set
	 */
	public void setFormatLocale(String formatLocale) {
		this.formatLocale = formatLocale;
	}

	/**
	 * @return the initiatorSystemId
	 */
	public String getInitiatorSystemId() {
		return initiatorSystemId;
	}

	/**
	 * @param initiatorSystemId the initiatorSystemId to set
	 */
	public void setInitiatorSystemId(String initiatorSystemId) {
		this.initiatorSystemId = initiatorSystemId;
	}

	/**
	 * @return the navData
	 */
	public ApplicationContext.NavData getNavData() {
		return navData;
	}

	/**
	 * @param navData the navData to set
	 */
	public void setNavData(ApplicationContext.NavData navData) {
		this.navData = navData;
	}

	/**
	 * @return the navType
	 */
	public NavigationTYPEXML getNavType() {
		return navType;
	}

	/**
	 * @param navType the navType to set
	 */
	public void setNavType(NavigationTYPEXML navType) {
		this.navType = navType;
	}

	/**
	 * @return the operationDomain
	 */
	public String getOperationDomain() {
		return operationDomain;
	}

	/**
	 * @param operationDomain the operationDomain to set
	 */
	public void setOperationDomain(String operationDomain) {
		this.operationDomain = operationDomain;
	}

	/**
	 * @return the uiType
	 */
	public ApplicationUITYPEXML getUiType() {
		return uiType;
	}

	/**
	 * @param uiType the uiType to set
	 */
	public void setUiType(ApplicationUITYPEXML uiType) {
		this.uiType = uiType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ApplicationContextTO [enforcedTargetBinding="
				+ enforcedTargetBinding + ", forcedTargetSystem="
				+ forcedTargetSystem + ", formatLocale=" + formatLocale
				+ ", initiatorSystemId=" + initiatorSystemId + ", navData="
				+ navData + ", navType=" + navType + ", operationDomain="
				+ operationDomain + ", uiType=" + uiType + "]";
	}
    
    
}

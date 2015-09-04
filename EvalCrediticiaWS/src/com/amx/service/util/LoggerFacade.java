package com.amx.service.util;

import org.apache.log4j.Logger;

import com.amx.service.bean.LogTO;


public class LoggerFacade {

	private static Logger logger = Logger.getLogger(LoggerFacade.class);

	/**
	 * 
	 * @param log
	 */
	@SuppressWarnings("unused")
	private static void logInfo(LogTO log) {

		StringBuilder builder = new StringBuilder();
		builder.append(log.getId());
		builder.append(log.getServiceName());
		builder.append(log.getLevel());
		builder.append(log.getMessage());
		builder.append(log.getIsBusiness());
		builder.append(log.getVar());

		logger.debug(log.getId().concat(builder.toString()));
	}

	/**
	 * 
	 * @param transactionId
	 * @param serviceName
	 * @param level
	 * @param message
	 * @param type
	 * @param objectVar
	 */
	public static void registerLog(String transactionId, String serviceName, String level, String typeMessage, String isBusiness, String objectVar) {

		StringBuilder builder = new StringBuilder();
		builder.append(transactionId);
		builder.append("|");
		builder.append(serviceName);
		builder.append("|");
		builder.append(level);
		builder.append("|");
		builder.append(typeMessage);
		builder.append("|");
		builder.append(isBusiness);
		logger.debug(builder);
	}

	/**
	 * 
	 * @param transactionId
	 * @param serviceName
	 * @param level
	 * @param message
	 * @param type
	 * @param objectVar
	 */
	public static void registerLog(String log) {

		logger.debug(log);
	}

	/**
	 * 
	 * @param transactionId
	 * @param serviceName
	 * @param level
	 * @param message
	 * @param type
	 * @param objectVar
	 */
	public static void registerError(String log, Exception e) {

		logger.error(log, e);
	}
}
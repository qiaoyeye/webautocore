package com.core.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/** 
* @ClassName: Log 
* @Description: TODO(日志类) 
* @author qiaojiafei 
* @date 2015年10月22日 下午5:57:44 
*  
*/
public class Log {
	public final Class<?> clazz;
	public Logger logger;

	public Log(Class<?> clazz) {
		this.clazz = clazz;
		this.logger = LogManager.getLogger(this.clazz);
	}

	public void info(String message) {
		logger.info(clazz.getCanonicalName() + ": " + message);
	}

	public void debug(String message) {
		logger.debug(clazz.getCanonicalName() + ": " + message);
	}

	public void error(String message) {
		logger.error(clazz.getCanonicalName() + ": " + message);
	}

	public void trace(String message) {
		logger.trace(clazz.getCanonicalName() + ": " + message);
	}

	public void warn(String message) {
		logger.warn(clazz.getCanonicalName() + ": " + message);
	}

	public void fatal(String message) {
		logger.fatal(clazz.getCanonicalName() + ": " + message);
	}
	public static void main(String args[]) {
		Log log = new Log(Log.class);
		log.debug("sdfsdfds");
		
	}
}

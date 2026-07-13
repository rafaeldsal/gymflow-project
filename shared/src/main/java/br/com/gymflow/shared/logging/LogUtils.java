package br.com.gymflow.shared.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Map;
import java.util.UUID;

public class LogUtils {

  public static Logger getLogger(Class<?> clazz) {
    return LoggerFactory.getLogger(clazz);
  }

  public static Logger getModule(String moduleName) {
    return LoggerFactory.getLogger("com.gymflow." + moduleName);
  }

  public static void logBusiness(Logger log, String operation, Object... args) {
    log.info("BUSINESS: {} - {}", operation, args);
  }

  public static void logSecurity(Logger log, String operation, Object... args) {
    log.info("SECURITY: {} - {}", operation, args);
  }

  public static void logPerformance(Logger log, String operation, long duration, Object... args) {
    log.info("PERFORMANCE: {} took {}ms - {}", operation, duration, args);
  }

  public static String generateCorrelationId() {
    return UUID.randomUUID().toString();
  }

  public static void addToMDC(String key, String value) {
    if (value != null) {
      MDC.put(key, value);
    }
  }

  public static void removeFromMDC(String key) {
    if (key != null) {
      MDC.remove(key);
    }
  }

  public static Map<String, String> getMDCContext() {
    return MDC.getCopyOfContextMap();
  }

}

package br.com.gymflow.bootstrap.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    // Log da requisição
    log.info("REQUEST: {} {} - CorrelationId: {}, Tenant: {}",
        request.getMethod(),
        request.getRequestURI(),
        MDC.get("correlationId"),
        MDC.get("tenantId"));

    // Adiciona tempo de início para medir duração
    request.setAttribute("startTime", System.currentTimeMillis());

    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                              Object handler, Exception ex) {

    Long startTime = (Long) request.getAttribute("startTime");
    if (startTime != null) {
      long duration = System.currentTimeMillis() - startTime;

      // Log da resposta com duração
      log.info("RESPONSE: {} {} - Status: {}, Duration: {}ms, CorrelationId: {}",
          request.getMethod(),
          request.getRequestURI(),
          response.getStatus(),
          duration,
          MDC.get("correlationId"));

      // Se tiver erro, loga
      if (ex != null) {
        log.error("ERROR in request: {} {} - {}",
            request.getMethod(),
            request.getRequestURI(),
            ex.getMessage(),
            ex);
      }
    }
  }
}

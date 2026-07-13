package br.com.gymflow.bootstrap.filter;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.util.StringUtil;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorrelationIdFilter implements Filter {

  private static final String CORRELATION_ID_HEADER = "X-Correlation-Id";
  private static final String CORRELATION_ID_MDC = "correlationId";
  private static final String TRACE_ID_MDC = "traceId";

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    try {
      String correlationId = httpRequest.getHeader(CORRELATION_ID_HEADER);

      if (!StringUtils.hasText(correlationId)) {
        correlationId = UUID.randomUUID().toString();
      }

      MDC.put(CORRELATION_ID_MDC, correlationId);
      MDC.put(TRACE_ID_MDC, correlationId); // Usamos o mesmo ID para trace simplificado

      httpResponse.addHeader(CORRELATION_ID_HEADER, correlationId);

      chain.doFilter(request, response);
    } finally {
      MDC.remove(CORRELATION_ID_MDC);
      MDC.remove(TRACE_ID_MDC);
    }
  }
}

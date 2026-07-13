package br.com.gymflow.bootstrap.filter;

import br.com.gymflow.shared.context.TenantContext;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class TenantContextFilter implements Filter {

  private static final String TENANT_HEADER = "X-Tenant-Id";
  private static final String USER_ID_HEADER = "X-User-Id";
  private static final String TENANT_MDC = "tenantId";
  private static final String USER_MDC = "userId";

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;

    try {
      String tenantId = httpRequest.getHeader(TENANT_HEADER);

      if (StringUtils.hasText(tenantId)) {
        MDC.put(TENANT_MDC, tenantId);
        TenantContext.setCurrentTenant(tenantId);
      }

      String userId = httpRequest.getHeader(USER_ID_HEADER);
      if (StringUtils.hasText(userId)) {
        MDC.put(USER_MDC, userId);
        TenantContext.setCurrentUser(userId);
      }

      chain.doFilter(request, response);
    } finally {
      MDC.remove(TENANT_MDC);
      MDC.remove(USER_MDC);
      TenantContext.clear();
    }
  }
}

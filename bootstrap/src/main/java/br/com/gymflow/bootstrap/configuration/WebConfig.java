package br.com.gymflow.bootstrap.configuration;

import br.com.gymflow.bootstrap.filter.CorrelationIdFilter;
import br.com.gymflow.bootstrap.filter.TenantContextFilter;
import br.com.gymflow.bootstrap.interceptor.LoggingInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

  private final CorrelationIdFilter correlationIdFilter;
  private final TenantContextFilter tenantContextFilter;
  private final LoggingInterceptor loggingInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loggingInterceptor)
        .addPathPatterns("/api/**");
  }
}

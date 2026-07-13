package br.com.gymflow.shared.context;

public class TenantContext {

  private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();
  private static final ThreadLocal<String> currentUser = new ThreadLocal<>();

  public static void setCurrentTenant(String tenantId) {
    currentTenant.set(tenantId);
  }

  public static String getCurrentTenant() {
    return currentTenant.get();
  }

  public static void setCurrentUser(String userId) {
    currentUser.set(userId);
  }

  public static String getCurrentUser() {
    return currentUser.get();
  }

  public static void clear() {
    currentTenant.remove();
    currentUser.remove();
  }
}

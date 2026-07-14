  package br.com.gymflow.shared.logging;

  public enum LogMessage {
    // ===== OPERAÇÕES CRUD =====
    ENTITY_CREATED("{} created successfully: {}"),
    ENTITY_CREATE_FAILED("Failed to create {}: {}"),
    ENTITY_UPDATED("{} updated successfully: {}"),
    ENTITY_UPDATE_FAILED("Failed to update {}: {}"),
    ENTITY_DELETED("{} deleted successfully: {}"),
    ENTITY_DELETE_FAILED("Failed to delete {}: {}"),
    ENTITY_FOUND("{} found: {}"),
    ENTITY_NOT_FOUND("{} not found: {}"),

    // ===== PROCESSOS DE NEGÓCIO =====
    BUSINESS_PROCESS_START("Starting {} process: {}"),
    BUSINESS_PROCESS_END("{} process completed: {}"),
    BUSINESS_VALIDATION("Business validation {}: {}"),
    BUSINESS_RULE_APPLIED("Business rule applied: {} - {}"),

    // ===== INTEGRAÇÕES =====
    INTEGRATION_CALL("Calling external service: {} - {}"),
    INTEGRATION_RESPONSE("Response from {}: {}"),
    INTEGRATION_ERROR("Error calling {}: {}"),

    // ===== EVENTOS =====
    EVENT_PUBLISHED("Event published: {} - {}"),
    EVENT_CONSUMED("Event consumed: {} - {}"),
    EVENT_PROCESSED("Event processed: {} - {}"),

    // ===== PERFORMANCE =====
    PERFORMANCE_OPERATION("Performance - {}: {}ms"),

    // ===== SEGURANÇA =====
    SECURITY_AUTHENTICATION("Authentication - {}: {}"),
    SECURITY_AUTHORIZATION("Authorization - {}: {}");

    private final String message;

    LogMessage(String message) {
      this.message = message;
    }

    public String getMessage() {
      return this.message;
    }

    public String format(Object... args) {
      return String.format(this.message, args);
    }

  }

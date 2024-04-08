package dev.langchain4j.example.chat.healthCheck;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.Readiness;
import dev.langchain4j.example.chat.ChatService;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@Readiness
@ApplicationScoped
public class ChatReadinessCheck implements HealthCheck {

  private static final String READINESS_CHECK = ChatService.class.getSimpleName()
                                               + " Readiness Check";
  @Override
  public HealthCheckResponse call() {
    if (!System.getProperty("wlp.server.name").equals("defaultServer")) {
      return HealthCheckResponse.down(READINESS_CHECK);
    }
    return HealthCheckResponse.up(READINESS_CHECK);
  }
}
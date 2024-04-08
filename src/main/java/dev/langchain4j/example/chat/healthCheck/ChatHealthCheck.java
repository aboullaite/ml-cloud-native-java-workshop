package dev.langchain4j.example.chat.healthCheck;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

import dev.langchain4j.example.chat.ChatService;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.Startup;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@Startup
@ApplicationScoped
public class ChatHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean)
        ManagementFactory.getOperatingSystemMXBean();
        double cpuUsed = bean.getSystemCpuLoad();
        String cpuUsage = String.valueOf(cpuUsed);
        return HealthCheckResponse.named(ChatService.class
                                            .getSimpleName() + " Startup Check")
                                            .status(cpuUsed < 0.95).build();
    }
}

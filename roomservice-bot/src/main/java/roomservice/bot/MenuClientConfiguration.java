package roomservice.bot;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.http.client.HttpClientConfiguration;
import io.micronaut.runtime.ApplicationConfiguration;

import java.time.Duration;

@ConfigurationProperties(MenuClientConfiguration.PREFIX)
public class MenuClientConfiguration extends HttpClientConfiguration {
    public static final String PREFIX = "menu_service";
    private String url;
    private String path;
    private final MenuClientConnectionPoolConfiguration connectionPoolConfiguration;

    public MenuClientConfiguration(
            final ApplicationConfiguration applicationConfiguration,
            final MenuClientConnectionPoolConfiguration connectionPoolConfiguration) {
        super(applicationConfiguration);
        this.connectionPoolConfiguration = connectionPoolConfiguration;
    }
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public ConnectionPoolConfiguration getConnectionPoolConfiguration() {
        return connectionPoolConfiguration;
    }

    @ConfigurationProperties(ConnectionPoolConfiguration.PREFIX)
    public static class MenuClientConnectionPoolConfiguration extends ConnectionPoolConfiguration {
    }

    /**
     * Extra configuration properties to set the values
     * for the @Retryable annotation on the MenuClient.
     */
    @ConfigurationProperties(MenuClientRetryConfiguration.PREFIX)
    public static class MenuClientRetryConfiguration {

        public static final String PREFIX = "retry";

        private Duration delay;

        private int attempts;

        public Duration getDelay() {
            return delay;
        }

        public void setDelay(final Duration delay) {
            this.delay = delay;
        }

        public int getAttempts() {
            return attempts;
        }

        public void setAttempts(final int attempts) {
            this.attempts = attempts;
        }
    }
}

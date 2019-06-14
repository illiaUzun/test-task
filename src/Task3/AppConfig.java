package Task3;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Method to allow to but brackets into URL as PaquestParam
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatCustomizer() {
        return (tomcat) -> {
            tomcat.addConnectorCustomizers((connector) ->
                    ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setRelaxedQueryChars("[]{}()<>"));
        };
    }
}
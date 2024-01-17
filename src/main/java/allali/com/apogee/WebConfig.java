package allali.com.apogee;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Autoriser les requêtes de n'importe quelle origine
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Autoriser les méthodes spécifiées
                .allowedHeaders("*")  // Autoriser tous les en-têtes
                .allowedOrigins("*");  // Autoriser toutes les origines
    }
}

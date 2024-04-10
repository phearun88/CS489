/**
 * Author : PhearunPhin
 * Date : 4/5/2024
 */

package phearun.thds_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {


        registry.addMapping("/**") // Allow CORS for all endpoints
                .allowedOrigins("*")    // Allow requests from any origin (replace with your specific origin if needed)
                .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS") // Allow specific HTTP methods  //, "POST", "PUT", "DELETE", "OPTIONS"
                .allowedHeaders("*");   // Allow all headers in the request
    }
}

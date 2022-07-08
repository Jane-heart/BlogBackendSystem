package online.tuanzi.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 解决跨域问题
 */
@Log4j2
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // When allowCredentials is true, allowedOrigins cannot contain the special value "*" since that
        // cannot be set on the "Access-Control-Allow-Origin" response header. To allow credentials to a set of origins,
        // list them explicitly or consider using "allowedOriginPatterns" instead.
        registry.addMapping("/**")
//                .allowedOrigins("*")
                .allowedOrigins("http://localhost:1024")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

}

package mt.megatrend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Authorization",
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.APIKEY
)
@OpenAPIDefinition(
        info = @Info(
                title = "Api Documentation for MegaTrend",
                description = "MegaTrend is a online shop",
                contact = @Contact(name = "Karimjon Xakimjonov", email = "xakimjonovkarimjon37@gmail.com", url = "https://t.me/Karimjon_Xakimjonov"),
                version = "1.0.0"
        ),
        security = @SecurityRequirement(name = "Authorization")
)

public class SwaggerConfig {
}
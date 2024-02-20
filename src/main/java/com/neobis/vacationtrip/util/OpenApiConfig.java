package com.neobis.vacationtrip.util;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Akzhol",
                        email = "akzholbek0096@gmail.com",
                        url = "https://t.me/akzholbek"
                ),
                title = "Vacation trip web app to search and book a trip",
                description = "OpenApi documentation for Vacation Trip App",
                version = "0.0.1"
        ),
        servers = {
                @Server(
                        description = "Remote server",
                        url = "https://phobic-honey-production.up.railway.app"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
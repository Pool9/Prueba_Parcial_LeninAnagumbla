package com.distribuida;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@ApplicationPath("/")
@OpenAPIDefinition(info = @Info(title="app-books", version = "1.0.0", description = "Operaciones CRUD Books"))
public class RestApp extends Application {
}

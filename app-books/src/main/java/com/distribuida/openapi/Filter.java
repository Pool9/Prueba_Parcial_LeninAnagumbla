package com.distribuida.openapi;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.OASFilter;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.info.Info;

import java.util.*;

public class Filter implements OASFilter {

    @Override
    public void filterOpenAPI(OpenAPI openAPI) {
        List<String> tags = new ArrayList<>();
        tags.add("Books");
        openAPI.setInfo(
                OASFactory.createObject(Info.class).title("app-books").version("1.0.0")
                        .description(
                                "Operaciones CRUD Books")
        );
        openAPI.setPaths(OASFactory.createPaths()
                .addPathItem("/books", OASFactory.createPathItem()
                        .GET(OASFactory.createOperation()
                                .description("Book por id")
                                .tags(tags))));

    }

}

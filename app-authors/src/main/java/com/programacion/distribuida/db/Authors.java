package com.programacion.distribuida.db;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;

@Entity
@Schema(name = "Author", description = "Informacion Author")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @Column(name = "first_name")
    @Schema(required = true)
    @Getter @Setter private String firtName;

    @Column(name = "last_name")
    @Schema(required = true)
    @Getter @Setter private String lastName;
}

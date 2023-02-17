package com.programacion.distribuida.servicios;

import com.programacion.distribuida.db.Authors;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthorRepository implements PanacheRepositoryBase<Authors, Integer> {
}

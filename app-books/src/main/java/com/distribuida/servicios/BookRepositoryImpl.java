package com.distribuida.servicios;

import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext(unitName = "PruebaPU")
    private EntityManager entity;

    @Override
    public List<Book> findAll() {
        return entity.createQuery("SELECT b FROM Book b").getResultList();

    }

    @Override
    public Book findById(Integer id) {
        Book book = entity.find(Book.class, id);
        return book;
    }

    @Override
    @Transactional
    public void insert(Book book) {
        entity.persist(book);
    }

    @Override
    @Transactional
    public void update(Book book) {
        Book aux = entity.find(Book.class, book.getId());
        if (null != aux){
            entity.merge(book);
        }
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Book book = entity.find(Book.class, id);
        if (null != book){
            entity.remove(book);
        }
    }


}

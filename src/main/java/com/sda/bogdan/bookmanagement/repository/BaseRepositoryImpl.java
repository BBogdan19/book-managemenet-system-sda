package com.sda.bogdan.bookmanagement.repository;

import com.sda.bogdan.bookmanagement.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

public class BaseRepositoryImpl<T> implements BaseRepository <T> {
    private Class<T> entityClass;

    public BaseRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Optional<T> findById(Integer id) {
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            T entity = session.find(entityClass, id);
            return Optional.ofNullable(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public void create(T entity) {
        Transaction transaction = null;

        try (Session session = SessionManager.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(entity);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;

        try (Session session = SessionManager.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(entity);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }

    }

    @Override
    public void delete(T entity) {Transaction transaction = null;

        try (Session session = SessionManager.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.delete(entity);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }

    }
}
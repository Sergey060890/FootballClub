package footballclub.dao.implementations;

import footballclub.dao.interfaces.EntityDao;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
@RequiredArgsConstructor
public class EntityDaoImpl<T> implements EntityDao<T>, Serializable {

    private final Class<T> clazz;
    protected final EntityManager entityManager;

    @Override
    public T findOne(Integer id) throws SQLException {
        T entity = entityManager.find(clazz, id);
        if(entity==null){
            throw new SQLException("No such id found!");
        }
        return entity;
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Override
    public T create(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public T update(T incomingEntity) {
        entityManager.getTransaction().begin();
        T entity = entityManager.merge(incomingEntity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteById(Integer entityId) throws SQLException {
        final T entity = findOne(entityId);
        delete(entity);
    }
}

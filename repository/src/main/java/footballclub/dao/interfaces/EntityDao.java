package footballclub.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface EntityDao<T> {
        T findOne(Integer id) throws SQLException;

        List<T> findAll();

        T create(T entity);

        T update(T incomingEntity);

        void delete(T entity);

        void deleteById(Integer entityId) throws SQLException;
}



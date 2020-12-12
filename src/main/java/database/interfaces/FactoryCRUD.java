package database.interfaces;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class FactoryCRUD<T> {
    abstract public T getById(Integer id);
    abstract public List<T> select();
    abstract public void insert(T t);
    abstract public void update(T t);
    abstract public void delete(T t);
}

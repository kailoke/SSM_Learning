package A7_AnnotationIOC.DAO;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

public abstract class Dao<T> {
    @Resource(name = "runner")
    QueryRunner runner;
    private Class<T> clazz;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paraType = (ParameterizedType) genericSuperclass;
        Type[] types = paraType.getActualTypeArguments();
        clazz = (Class<T>) types[0];
    }

    public void update(String sql, Object... args) throws SQLException {
        runner.update(sql, args);
    }

    public T query(String sql, Object... args) throws SQLException {
        return runner.query(sql, new BeanHandler<>(clazz), args);
    }

    public List<T> queryList(String sql) throws SQLException {
        return runner.query(sql, new BeanListHandler<>(clazz));
    }
}

package smartrc.infrastructure.dao;

import java.util.List;

public interface IJdbcWrapper {
    public <T> List<T> findList(String sql, IModelMapper<T> mapper, Object... params);
}

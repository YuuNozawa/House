package smartrc.infrastructure.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IModelMapper<T> {
    public T map(ResultSet rs) throws SQLException;
}

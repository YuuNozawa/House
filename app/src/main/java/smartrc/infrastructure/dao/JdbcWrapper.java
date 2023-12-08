package smartrc.infrastructure.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JdbcWrapper implements IJdbcWrapper {
    private static final String url = "jdbc:mysql://localhost:3306/room";
    private static final String user = "trams";
    private static final String password = "moor";

    public <T> List<T> findList(String sql, IModelMapper<T> mapper, Object... params) {
        try(
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            try(ResultSet rs = stmt.executeQuery();) {
                return resultSetToModels(rs, mapper);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> List<T> resultSetToModels(ResultSet rs, IModelMapper<T> mapper) throws SQLException {
        List<T> list = new ArrayList<T>();
        while(rs.next()) {
            T obj = mapper.map(rs);
            list.add(obj);
        }
        return list;
    }
}

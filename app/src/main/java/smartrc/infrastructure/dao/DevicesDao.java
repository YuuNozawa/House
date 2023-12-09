package smartrc.infrastructure.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.model.LightModel;

@Component
public class DevicesDao {
    private static final String url = "jdbc:mysql://localhost:3306/room";
    private static final String user = "trams";
    private static final String password = "moor";

    @Autowired
    private int propsRoomNo;

    @Autowired
    private IJdbcWrapper iJdbcWrapper;

    @Autowired
    private LightModelMapper lightModelMapper;

    public Optional<LightModel> getByDeviceId(String deviceId) {
        String sql = "select * from devices where room = " + propsRoomNo + " and device_id = 'ML001'";
        return Optional.ofNullable(iJdbcWrapper.findList(sql, lightModelMapper, "").get(0));
    }

    public void updateByDeviceId(String deviceId) {
        String sql = "update devices set status = NOT status where room = " + propsRoomNo + " and device_id = ?";
        try(
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = con.prepareStatement(sql);
        ) {
            stmt.setString(1, deviceId);
            stmt.executeUpdate();

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

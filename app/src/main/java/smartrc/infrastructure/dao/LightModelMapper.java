package smartrc.infrastructure.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import smartrc.model.LightModel;

@Component
public class LightModelMapper implements IModelMapper<LightModel> {

    public LightModel map(ResultSet rs) throws SQLException {
        int roomNo = rs.getInt(1);
        // String deviceId = rs.getString(2);
        boolean isOn = rs.getBoolean(3);
        return new LightModel(roomNo, isOn);
    }
}

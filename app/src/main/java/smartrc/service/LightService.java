package smartrc.service;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.infrastructure.dao.DevicesDao;
import smartrc.model.LightModel;

@Component
public class LightService {
    @Autowired
    DevicesDao devicesDao;

    public LightModel getLight() throws NoSuchElementException {
        return devicesDao.getByDeviceId("ML001").orElseThrow();
    }

    public void update() throws IOException {
        devicesDao.updateByDeviceId("ML001");
    }
}

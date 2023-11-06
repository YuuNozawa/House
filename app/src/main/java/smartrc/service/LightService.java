package smartrc.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import smartrc.model.LightModel;

@Component
public class LightService {
    private static final String DATA_DIR = System.getProperty("user.dir") + "/build/resources/main/";
    private static final String LIGHT_CSV = DATA_DIR + "light.csv";
    private static final String CSV_DELIMITER = ",";

    public Boolean isOn(int roomNo) throws IOException {
        try(Stream<String> stream = Files.lines(Paths.get(LIGHT_CSV), StandardCharsets.UTF_8)) {
            return stream
            .map(line -> {
                String[] values = line.split(CSV_DELIMITER);
                return new LightModel(Integer.parseInt(values[0]), Boolean.valueOf(values[1]));
            })
            .filter(light -> light.getRoomNo() == roomNo)
            .map(light -> light.getIsOn())
            .findFirst()
            .orElse(false);
        }
    }

    public LightModel getLight(int roomNo) throws IOException {
        try(Stream<String> stream = Files.lines(Paths.get(LIGHT_CSV), StandardCharsets.UTF_8)) {
            return stream
            .map(line -> {
                String[] values = line.split(CSV_DELIMITER);
                return new LightModel(Integer.parseInt(values[0]), Boolean.valueOf(values[1]));
            })
            .filter(l -> l.getRoomNo() == roomNo)
            .findFirst()
            .orElse(null);
        }
    }
}

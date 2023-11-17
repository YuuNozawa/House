package smartrc.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    private static final String ERR_MSG = "something went wrong";

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

    public void insert(int roomNo) throws IOException {
        boolean isOn = isOn(roomNo);
        File lightCSV = new File(LIGHT_CSV);
        try (
            FileWriter fw = new FileWriter(lightCSV);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
        ) {
            if(isOn) {
                pw.println(roomNo + CSV_DELIMITER + false);
            } else {
                pw.println(roomNo + CSV_DELIMITER + true);
            }
        } catch(IOException e) {
            System.out.println(ERR_MSG);
        }
    }
}

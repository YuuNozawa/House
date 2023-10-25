package smartrc.presentation.controller;

import smartrc.service.LightService;
import smartrc.view.LightView;
import smartrc.view.View;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.IOException;

import smartrc.model.LightModel;

public class LightController implements Controller {
    private LightService lightService = new LightService();

    private static final String DATA_DIR = System.getProperty("user.dir") + "/build/resources/main/";
    private static final String LIGHT_CSV = DATA_DIR + "light.csv";
    private static final String CSV_DELIMITER = ",";
    private static final String ERR_MSG = "something went wrong";

    @Override
    public void start() {
        try {
            LightModel model = lightService.getLight(828);
            View view = new LightView(model);
            view.show();
        } catch(IOException e) {

        }
    }

    public void save() {
        boolean isOn = false;
        try {
            isOn = lightService.isOn(828);
        } catch(IOException e) {
            System.out.println(ERR_MSG);
        }
        File lightCSV = new File(LIGHT_CSV);
        try (
            FileWriter fw = new FileWriter(lightCSV);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
        ) {
            if(isOn) {
                pw.println(828 + CSV_DELIMITER + false);
            } else {
                pw.println(828 + CSV_DELIMITER + true);
            }
        } catch(IOException e) {
            System.out.println(ERR_MSG);
        }

    }
}

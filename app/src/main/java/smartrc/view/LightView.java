package smartrc.view;

import smartrc.model.LightModel;

public class LightView implements View {
    private LightModel model;

    public LightView(LightModel lightModel) {
        this.model = lightModel;
    }

    public void show() {
        String str = model.getIsOn() ? "on " : "off";
        System.out.println("+------------------+");
        System.out.println("| Main Light: " + str + "  |");
        System.out.println("| 1: on/off        |");
        System.out.println("| 9: back          |");
        System.out.println("+------------------+");
    }
}

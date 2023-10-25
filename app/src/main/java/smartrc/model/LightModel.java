package smartrc.model;

public class LightModel {
    private int roomNo;
    private boolean isOn;

    public LightModel(int roomNo, boolean isOn) {
        this.roomNo = roomNo;
        this.isOn = isOn;
    }

    public int getRoomNo() {
        return this.roomNo;
    }
    
    public boolean getIsOn() {
        return this.isOn;
    }
}

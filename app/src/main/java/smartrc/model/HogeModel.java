package smartrc.model;

public class HogeModel implements Model {
    private int roomNo;
    private boolean isOn;

    public HogeModel(int roomNo, boolean isOn) {
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

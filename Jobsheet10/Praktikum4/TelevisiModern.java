package Jobsheet10.Praktikum4;

public class TelevisiModern extends  Elektronik {
    private String modeInput;

    public TelevisiModern() {
        this.modeInput = "HDMI";
        this.voltase = 220;
    }

    public String getModeInput() {
        return modeInput;
    }
}

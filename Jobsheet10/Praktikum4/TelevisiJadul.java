package Jobsheet10.Praktikum4;

public class TelevisiJadul extends Elektronik {
    private String modeInput;

    public TelevisiJadul() {
        this.modeInput = "DVI";
        this.voltase = 220;
    }

    public String getModeInput() {
        return modeInput;
    }
}

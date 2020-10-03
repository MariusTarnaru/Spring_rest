package main.java;

public class PS4 {

    private boolean power = false;

    void powerToggle() {
        power = !power;
    }

    public boolean isPowered() {
        return power;
    }
}

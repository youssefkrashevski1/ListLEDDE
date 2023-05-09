package co.edu.umanizales.listledde.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
public class Led {
    private int ID;
    private boolean state;
    private LocalDateTime on;
    private LocalDateTime off;
    private Led next;
    private Led head;

    public Led(int ID, boolean b) {
    }

    // Constructor
    public Led(int ID, boolean state, LocalDateTime on, LocalDateTime off) {
        this.ID = ID;
        this.state = state;
        this.on = on;
        this.off = off;
    }

    // Getters y setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public LocalDateTime getOn() {
        return on;
    }

    public void setOn(LocalDateTime on) {
        this.on = on;
    }

    public LocalDateTime getOff() {
        return off;
    }

    public void setOff(LocalDateTime off) {
        this.off = off;
    }
    public void reboot() {
        this.state = false;
        this.on = null;
        this.off = null;
    }

    public void turnOn() {
    }
}




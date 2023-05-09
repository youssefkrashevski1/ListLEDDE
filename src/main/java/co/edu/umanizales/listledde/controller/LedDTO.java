package co.edu.umanizales.listledde.controller;

import lombok.Data;
import java.time.LocalDateTime;
@Data
public class LedDTO {
    private int ID;
    private boolean state;
    private LocalDateTime on;
    private LocalDateTime off;
}

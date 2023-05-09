package co.edu.umanizales.listledde.controller;
import co.edu.umanizales.listledde.model.ListDE;
import co.edu.umanizales.listledde.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.time.LocalTime;
import java.util.Collections;

@RestController
@RequestMapping(path = "listde")
public class ControllerDE {
    @Autowired
    private ListDEService listDEService;

    public void ListDEService(){
        ListDE led = new ListDE();
    }
    @GetMapping
    public ResponseEntity<ResponseDTO> getLed() {
        return new ResponseEntity<>(new ResponseDTO(
                200, listDEService.getLed().getHead(), null), HttpStatus.OK);
    }
    @GetMapping("/leds")
    public ResponseEntity<ResponseDTO> listLeds() {
         listDEService.getLed().getAll();
        ErrorDTO leds = null;
        return new ResponseEntity<>(new ResponseDTO(
                200, "Lista de leds obtenida exitosamente",
                Collections.singletonList(null)), HttpStatus.OK);
    }

    @GetMapping(path = "/add_led_start_off")
    public ResponseEntity<ResponseDTO> addLedStartOff() {
        int Letter = 0;
        listDEService.getLed().addLedStartOff(Letter);
        return new ResponseEntity<>(new ResponseDTO(
                200,"El nuevo LED ha sido agregado exitosamente con estado apagado",
                null), HttpStatus.OK);
    }

    @GetMapping(path = "/reboot_leds")
    public ResponseEntity<ResponseDTO> getreboot() {
         listDEService.getLed().getreboot();
        return new ResponseEntity<>(new ResponseDTO(
                200,"Los LEDs han sido reiniciados exitosamente",
                null), HttpStatus.OK);
    }
    @GetMapping("/led_middle")
    public ResponseEntity<ResponseDTO> getMiddle() {
         listDEService.getLed().findMiddle();
        boolean middle = false;
        return new ResponseEntity<>(new ResponseDTO(
                200, "El nodo central de la lista de LEDs ha sido encontrado",
                null), HttpStatus.OK);
    }
    @GetMapping("/turn_on_middle_led")
    public ResponseEntity<ResponseDTO> turnOnMiddleLed() {
        listDEService.getLed().findMiddle();
        boolean middle = false;
        return new ResponseEntity<>(new ResponseDTO(
                200, "Se ha encendido el LED de la mitad de la lista",
                null), HttpStatus.OK);
    }
    @GetMapping("/wait_one_second")
    public ResponseEntity<ResponseDTO> waitOneSecond() {
        listDEService.getLed().waitOneSecond();
        try {
            Thread.sleep(1000); // Esperar 1 segundo (1000 ms)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaurar la interrupción
        }
        return new ResponseEntity<>(new ResponseDTO(
                200, "Se ha esperado 1 segundo",
                null), HttpStatus.OK);
    }
    @GetMapping("/turn_off_leds")
    public ResponseEntity<ResponseDTO> turnOffLeds() {
        try {
            listDEService.getLed().turnOffLeds();
            return new ResponseEntity<>(new ResponseDTO(
                    200, "Todos los LEDs han sido apagados",
                    null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(
                    500, "Ocurrió un error al apagar los LEDs",
                    null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

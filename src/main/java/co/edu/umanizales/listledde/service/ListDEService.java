package co.edu.umanizales.listledde.service;
import co.edu.umanizales.listledde.model.ListDE;
import co.edu.umanizales.listledde.model.NodeDE;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListDEService {
    private ListDE Led;
    public ListDEService(){
        ListDE led = new ListDE();
    }

    public ListDE getListLed() {
        ListDE listLed = null;
        return null;
    }

    public void setListLed(ListDE listLed) {
        this.Led = listLed;
    }
}

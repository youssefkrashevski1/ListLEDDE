package co.edu.umanizales.listledde.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NodeDE {
    public NodeDE prev;
    public int value;
    public Led led;
    public NodeDE head;
    private Led data;
    private NodeDE next;
    private NodeDE previous;

    // Constructor
    public NodeDE(Led data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    // Getters y setters
    public Led getData() {
        return data;
    }

    public void setData(Led data) {
        this.data = data;
    }

    public NodeDE getNext() {
        return next;
    }

    public void setNext(NodeDE next) {
        this.next = next;
    }

    public NodeDE getPrevious() {
        return previous;
    }

    public void setPrevious(NodeDE previous) {
        this.previous = previous;
    }
}



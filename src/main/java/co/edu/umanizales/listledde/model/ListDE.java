package co.edu.umanizales.listledde.model;

import lombok.Data;

@Data
public class ListDE {
    private NodeDE head;

    // Constructor
    public ListDE() {
        head = null;
    }

    // Método para agregar un nodo al final de la lista
    public void add(Led led) {
        NodeDE newNode = new NodeDE(led);
        if (head == null) {
            head = newNode;
        } else {
            NodeDE current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setPrevious(current);
        }
    }

    // Método para agregar un nodo al inicio de la lista
    public void addToStart(Led led) {
        NodeDE newNode = new NodeDE(led);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
    }

    // Método para reiniciar la lista
    public void reboot() {
        head = null;
    }

    // Getters y setters
    public NodeDE getHead() {
        return head;
    }

    public void setHead(NodeDE head) {
        this.head = head;
    }

    public void addLedStartOff(int ID) {
        // Creamos un nuevo objeto Led con el ID especificado y estado apagado (false)
        Led newLed = new Led(ID, false);

        // Si la lista está vacía, establecemos el nuevo LED como la cabeza
        if (head == null) {
            head = new NodeDE(newLed);
            return;
        }
        // Agregamos el nuevo LED al inicio de la lista
        NodeDE newNode = new NodeDE(newLed);
        newNode.setNext(head);
        head.setPrevious(newNode);
        head = newNode;
    }

    public void getreboot() {
        NodeDE currentNode = null;
        while (currentNode != null) {
            currentNode.getData().reboot();
            currentNode = currentNode.getNext();
        }
    }

    public void getAll() {
    }
    // para encontrar el nodo en la mitad de la lista. Básicamente, dos punteros son inicializados en el primer nodo (head). El puntero lento se mueve un nodo a la vez, mientras que el puntero rápido se mueve dos nodos a la vez. De esta manera, cuando el puntero rápido llega al final de la lista, el puntero lento está en el nodo de la mitad.
    //
    //Este método devuelve el nodo que se encuentra en la mitad de la lista. Si la lista está vacía, devuelve null.
    public NodeDE findMiddle() {
        if (head == null) {
            return null;
        }
        NodeDE slow = head;
        NodeDE fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
    public void turnOnMiddleLed() {
        NodeDE middleNode = findMiddle();
        if (middleNode != null) {
            middleNode.getData().turnOn();
        }
    }
    public void waitForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Manejar la excepción en caso de interrupción
        }
    }

    public void waitOneSecond() {
    }

    public void  turnOffLeds() {
        boolean current = false;
        {
            boolean turnedOff = true;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // handle exception
            }
        }
    }
}



package ds.socket.server.model;


public class Message implements java.io.Serializable {
    
    private String value;
    
public Message(){
}

public Message(String value){
    this.value = value;
}

    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }
}

import java.util.ArrayList;

public abstract class Actor {

    private String name;
    protected PubSubService service;

    public Actor(String name, PubSubService service) {
        this.name = name;
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public abstract void callBack(Event e);

    //    public void generateEvent(Event e) {
//        dispatcher.postEvent(e);
//    }

}

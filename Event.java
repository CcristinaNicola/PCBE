
public class Event {

    private EventType eventType;
    private Message message;
    private String newText;
    private String oldText;

    public enum EventType{Added,Modified,Deleted,Read};

    public Event(EventType eventType, Message message) {
        this.eventType = eventType;
        this.message = message;
    }

    public Event(EventType eventType, Message message, String newText, String oldText) {
        this.eventType = eventType;
        this.message = message;
        this.newText = newText;
        this.oldText = oldText;
    }

    public EventType getType()
    {
        return eventType;
    }
    public String getEventType() {

        if (eventType.equals(EventType.Added))
            return "Added";
        if (eventType.equals(EventType.Modified))
            return "Modified";
        if (eventType.equals(EventType.Deleted))
            return "Deleted";
        if (eventType.equals(EventType.Read))
            return "Read";
        return null;
    }

    public Message getMessage() {
        return message;
    }

    public String getNewText() {
        return newText;
    }

    public void setNewText(String newText) {
        this.newText = newText;
    }

    public String getOldText() {
        return oldText;
    }

    public void setOldText(String oldText) {
        this.oldText = oldText;
    }
}
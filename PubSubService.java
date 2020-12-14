import java.sql.SQLOutput;
import java.util.*;

public class PubSubService implements Runnable{

    public Queue<Event> eventQueue = new LinkedList<Event>();
    public HashMap<String, ArrayList<SubscriptionOfTopic>> subscribersToEvent = new HashMap<String, ArrayList<SubscriptionOfTopic>>();
    //de citit despre hashmap!!!!!!!!!!

    public PubSubService()
    {
        subscribersToEvent.put("Added", new ArrayList<SubscriptionOfTopic>());
        subscribersToEvent.put("Modified", new ArrayList<SubscriptionOfTopic>());
        subscribersToEvent.put("Deleted", new ArrayList<SubscriptionOfTopic>());
        subscribersToEvent.put("Read", new ArrayList<SubscriptionOfTopic>());
    }

    public void addSubscriber(String eventType, Actor actor, String domain) {

        //subscriberul e interesatsi de domeniu si de eveniment
        SubscriptionOfTopic sub = new SubscriptionOfTopic(actor,domain); //creez subscriberul pt topicul dorit
        ArrayList<SubscriptionOfTopic> subscriptions = subscribersToEvent.get(eventType);
        subscriptions.add(sub); //adaug subscriberul in lista

    }


    public void sendEvent(Event e) {

                eventQueue.add(e);
                System.out.println("S-a inregistrat un eveniment de tipul " + e.getEventType() + " pentru mesajul din domeniul " + e.getMessage().getDomain());
    }


    public void broadcast() {

        //se ocupa pt fiecare eveniment sa apeleze met callback()
        try {
            while (true) {

                Event e = eventQueue.remove();
                String eventType = e.getEventType();

                ArrayList<SubscriptionOfTopic> subscriptions = new ArrayList<>(subscribersToEvent.get(eventType));

                Iterator<SubscriptionOfTopic> it =  subscriptions.iterator();
                while(it.hasNext())
                {
                    it.next().getActor().callBack(e);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }


    @Override
    public void run() {
        broadcast();
    }
}
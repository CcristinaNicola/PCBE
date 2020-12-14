import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class PublisherImpl extends Actor implements Runnable{

    HashMap<String, Integer> counter = new HashMap<>();
    public PublisherImpl(String name, PubSubService service)
    {
        super(name, service);
    }

    public void registerListener(String eventType, String domain) {

        service.addSubscriber(eventType, this, domain);
        System.out.println("Editorul "+ this.getName() + " s-a abonat pentru evenimente de tipul " + eventType);

    }
    //

    public void callBack(Event e)
    {
        Lock _mutex = new ReentrantLock(true);

        _mutex.lock();

        if(e.getEventType().equals("Read")) {
            //daca nu am nimic in Map pentru counter, adica daca nu a mai fost citita nicio stire din domeniu, il pun pe 1, altfel - incrementez
            if(counter.get(e.getMessage().getDomain()) == null){
                counter.put(e.getMessage().getDomain(), 1);
            }else {
                counter.put(e.getMessage().getDomain(), counter.get(e.getMessage().getDomain()) + 1);
            }

            System.out.println("Stirea "+ e.getMessage().getPayload() + " din domeniul " + e.getMessage().getDomain() + "a fost citita.");
            System.out.println("NUMARUL DE CITITORI pentru stirea din domeniul "+ e.getMessage().getDomain()  + " este: "+ counter.get(e.getMessage().getDomain()));
        }
        _mutex.unlock();
    }

    @Override
    public void run() {

        Message m1 = new Message("domain1","subdomain1","source1", this.getName(),"text1");
        Message m2 = new Message("domain2","subdomain2","source2", this.getName(),"text2");

        Event e1 = new Event(Event.EventType.Read,m1);
        Event e2 = new Event(Event.EventType.Read,m1);
        Event e3 = new Event(Event.EventType.Read,m2);

        this.registerListener("Read","domain1");
        this.registerListener("Read","domain1");
        this.registerListener("Read","domain2");

        callBack(e1);
        callBack(e2);
        callBack(e3);

    }
}


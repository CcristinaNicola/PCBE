
public class Main {
    public static void main(String[] args) {

        //Instantiate publishers, subscribers and PubSubService
        PubSubService service = new PubSubService();

        PublisherImpl pub1 = new PublisherImpl("Ana", service);
        PublisherImpl pub2 = new PublisherImpl("George", service);

        SubscriberImpl subs1 = new SubscriberImpl("Dana",service);
        SubscriberImpl subs2 = new SubscriberImpl("Andrei",service);


        System.out.println("\n");

        Thread p1=new Thread(pub1);
        Thread p2= new Thread(pub2);
        Thread s1 = new Thread(subs1);
        Thread s2 = new Thread(subs2);
        Thread services = new Thread(service);

        services.start();
        p1.start();
        p2.start();
        s1.start();
        s2.start();

//        pub1.addNews(m1);
//        pub1.registerListener("Read","domain1");
//
//        pub1.updateNews(m1,"Am modificat acest mesaaj");
//        pub1.updateNews(m1,"Am modificat acest mesaaj22222222222222222222222222");
//
//        subs1.registerListener("Added","domain1");
//        subs1.registerListener("Modified","domain1");
//        subs1.registerListener("Deleted","domain1");
//
//        subs1.readNews(m1);
//        subs2.readNews(m1);
//
//        pub1.deleteNews(m1);

         //pub1.noOfSubscribers("domain1");

       // service.see("domain1");
//        service.broadcast();


    }
}
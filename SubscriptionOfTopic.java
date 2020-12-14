public class SubscriptionOfTopic {

    private String domain;
    private Actor actor;

    //abonarea dpar in functie de actor si domain si nu conteaza evenimentul

    public SubscriptionOfTopic(Actor actor, String domain)
    {
        this.actor = actor;
        this.domain = domain;
    }

    public Actor getActor() {
        return actor;
    }
}

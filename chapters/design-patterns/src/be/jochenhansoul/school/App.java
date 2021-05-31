package be.jochenhansoul.school;

public class App {
    public static void main(String[] args) {
        Event event = new ConcreteEvent(EventCategory.DEFCON_ONE, new Object());

        EventBus bus = new EventBus();

        EventListener listener1 = new ConcreteEventListener();
        EventListener listener2 = new ConcreteEventListener();
        EventListener listener3 = new ConcreteEventListener();

        bus.addEventListener(listener1);
        bus.addEventListener(listener2);
        bus.addEventListener(listener3);

        bus.publishEvent(event);
    }
}

package be.jochenhansoul.school;

/*
need listenerPool
add/remove Listeners
which Listener is interested in what
    je kan de eventlistener verantwoordelijk maken of hij kan luisteren of ook de bus
1. receove eve,ts
2. send events
*/

public class EventBus {
    private int counter = 0;
    private EventListener[] eventListeners = new ConcreteEventListener[1];

    public void addEventListener(EventListener listener) {
        this.eventListeners[0] = listener;
    }

    public void removeEventListener(EventListener listener) {
        // remove listener
    }

    public void publishEvent(Event event) {
        for (EventListener eventListener : this.eventListeners) {
            eventListener.onEvent(event);
        }
    }
}

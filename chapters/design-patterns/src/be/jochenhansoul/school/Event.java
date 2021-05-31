package be.jochenhansoul.school;

public interface Event {
    boolean isCategory(EventCategory category);

    void setInformation(Object info);

    Object getInformation();
}

package be.jochenhansoul.generics;

public class Duo<T> {
    private T first;
    private T second;

    public Duo(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public T getFirst() {
        return this.first;
    }

    public T getSecond() {
        return this.second;
    }

    public void swap() {
        T temp = this.first;
        this.first = this.second;
        this.second = temp;
    }
}

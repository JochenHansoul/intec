package be.jochenhansoul.general;

public class Person {
    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private float weight;
    private float length;

    public Person (
        String firstName,
        String lastName,
        Gender gender,
        int age,
        float weight,
        float length) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.length = length;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, age: %d, weight: %f, length: %f",
            this.firstName,
            this.lastName,
            this.gender.toString(),
            this.age,
            this.weight,
            this.length);
    }
}

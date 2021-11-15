package be.jochenhansoul.springdata.model;

public class Cake {
    private Integer size;
    private String name;
    private Boolean hasChocolate;

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHasChocolate(Boolean hasChocolate) {
        this.hasChocolate = hasChocolate;
    }

    public Integer getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public Boolean getHasChocolate() {
        return hasChocolate;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "size=" + size +
                ", name='" + name + '\'' +
                ", hasChocolate=" + hasChocolate +
                '}';
    }
}

package be.jochenhansoul.petstore.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@ManyToOne
    //private Pet pet;
    private Integer petQuantity;
    //private LocalDateTime shipDate;
    //private OrderStatus status;
    //private Boolean complete;

    public Order(Long id, /*Pet pet, */Integer quantity/*, LocalDateTime shipDate, OrderStatus status, Boolean complete*/) {
        this.id = id;
        //this.pet = pet;
        this.petQuantity = quantity;
        //this.shipDate = shipDate;
        //this.status = status;
        //this.complete = complete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) && /*pet.equals(order.pet) &&*/ petQuantity.equals(order.petQuantity) /*&& shipDate.equals(order.shipDate) && status == order.status && complete.equals(order.complete)*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, /*pet,*/ petQuantity/*, shipDate, status, complete*/);
    }
}

package be.jochenhansoul.petstore.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Pet pet;
    private Integer quantity;
    private LocalDateTime shipDate;
    private OrderStatus status;
    private Boolean complete = false;

    public Order(Long id, Pet pet, Integer quantity, LocalDateTime shipDate, OrderStatus status) {
        this.id = id;
        this.pet = pet;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) && pet.equals(order.pet) && quantity.equals(order.quantity) && shipDate.equals(order.shipDate) && status == order.status && complete.equals(order.complete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pet, quantity, shipDate, status, complete);
    }
}

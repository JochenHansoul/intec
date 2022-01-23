package be.jochenhansoul.yummieapp.model.restaurant;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public enum FoodCategory {
    CAFE, CAFETERIA, COFFEE, BISTRO, RESTAURANT, PIZZA, HAMBURGER, HOT_DOG, KEBAB, MEXICAN, CHINESE, INDIAN, THAI, FOOD_TRUCK;

    @Id
    private Long idFoodCategory;

    public Long getIdFoodCategory() {
        return idFoodCategory;
    }

    public void setIdFoodCategory(Long idFoodCategory) {
        this.idFoodCategory = idFoodCategory;
    }
}

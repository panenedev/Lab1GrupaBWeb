package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Dish {

    private static Long counter = 0L;

    private Long id;
    protected String dishId;
    protected String name;
    protected String cuisine;
    protected int preparationTime;


    public Dish(String dishId, String name, String cuisine, int preparationTime) {
        this.dishId = dishId;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
        this.id = ++counter;
    }
}

package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Dish {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String dishId;
    protected String name;
    protected String cuisine;
    protected int preparationTime;
    @ManyToOne
    private Chef chef;

    private static Long counter = 0L;



    public Dish(String dishId, String name, String cuisine, int preparationTime) {
        this.dishId = dishId;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;


    }
}

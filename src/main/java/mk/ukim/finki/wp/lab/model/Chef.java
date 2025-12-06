package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data

public class Chef {

    private static Long counter = 0L;

    Long id;
    String firstName;
    String lastName;
    String bio;
    List<Dish> dishes;


    public Chef(String firstName, String lastName, String bio, List<Dish> dishes){
        this.id=counter;
        counter++;
        this.firstName=firstName;
        this.lastName=lastName;
        this.bio=bio;
        this.dishes=dishes;
    }
}

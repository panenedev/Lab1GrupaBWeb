package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class Chef {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String bio;
    @OneToMany(mappedBy = "chef", fetch = FetchType.EAGER)
    List<Dish> dishes;
    private static Long counter = 0L;

    public Chef(){}

    public Chef(String firstName, String lastName, String bio, List<Dish> dishes){
        this.firstName=firstName;
        this.lastName=lastName;
        this.bio=bio;
        this.dishes=dishes;
    }


}

package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component // database
public class DataHolder {//DataBase

    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    @PostConstruct // init na values(lists)
    public void init(){

        chefs.add(new Chef( "Marco", "Vitale", "Master of traditional Italian cuisine and wood-fired pizza.", new ArrayList<>()));
        chefs.add(new Chef("Elena", "Hristova", "Specialist in pastry, desserts & chocolate art.", new ArrayList<>()));
        chefs.add(new Chef( "David", "Jovanov", "BBQ grill master and smoked meat enthusiast.", new ArrayList<>()));
        chefs.add(new Chef( "Ivana", "Trajkova", "Focused on vegan meals and healthy nutritional cooking.", new ArrayList<>()));
        chefs.add(new Chef( "Nikola", "Petreski", "Modern fusion cuisine expert, experiments with flavors.", new ArrayList<>()));

        dishes.add(new Dish("d1", "Margherita Pizza", "Italian", 20));
        dishes.add(new Dish("d2", "Chocolate Lava Cake", "Dessert", 30));
        dishes.add(new Dish("d3", "Beef Steak Grill", "American", 25));
        dishes.add(new Dish("d4", "Avocado Buddha Bowl", "Vegan", 15));
        dishes.add(new Dish("d5", "Sesame Chicken Stir Fry", "Asian", 18));

    }

}

package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.service.ChefService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/listChefs")
public class ChefController {

    private final ChefService chefService;

    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }

    //Show page
    @GetMapping
    public String getPage(Model model){
        model.addAttribute("chefs", this.chefService.listChefs());
        return "listChefs";
    }
    @PostMapping("/editChef/{id}")
    public String editChef(@PathVariable Long id,@RequestParam String firstName, @RequestParam String lastName, @RequestParam String bio){
        Chef chef = this.chefService.findById(id);
        chef.setFirstName(firstName);
        chef.setLastName(lastName);
        chef.setBio(bio);
        this.chefService.save(chef);
        return "redirect:/listChefs";
    }
    //editChefForm
    @GetMapping("/edit/{id}")
    public String editChef(@PathVariable Long id, Model model){
        Chef chef = this.chefService.findById(id);
        model.addAttribute("chef", chef);
        return "chef-form";
    }
    //deleteChef
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteChef(@PathVariable Long id){
        this.chefService.deleteById(id);
        return "redirect:/listChefs";
    }
    //getAddPage
    @GetMapping("/add")
    public String getAddPage(){
        return "chef-form";
    }
    @PostMapping("/addChef")
    public String addChef(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String bio){
        Chef chef = new Chef(firstName, lastName, bio, new ArrayList<>());
        this.chefService.save(chef);
        return "redirect:/listChefs";
    }
}

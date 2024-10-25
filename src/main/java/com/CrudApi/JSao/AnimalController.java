package com.CrudApi.JSao;

import java.util.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//@RestController
@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired private AnimalService animalService;


    /**get a list of all animal in the database
     * .../animals/all
     * @return a list of animals objects
    */
    @GetMapping("/all")
    public String getAllAnimals(Model model){
        model.addAttribute("animalList", animalService.getAllAnimals());
        model.addAttribute("Title", "All Animals");

        return "animal-list";}

    /**
     * @return animal by id
     */
    @GetMapping("/{animalId}")
     public String getOneAnimal(@PathVariable int animalId, Model model){
        model.addAttribute("animal", animalService.getAnimalById(animalId));
        model.addAttribute("title", animalId);
        return "animal-details";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("animal", new Animal());
        return"animal-create";
    }
/*
*Creating a new animal
 */
    @PostMapping("/new")
    public String addAnimal(Animal animal){
        animalService.addAnimal(animal);
        return "redirect:/animals/all"; //Redirect after successful submission
    }


    @GetMapping("/update/{animalId}")
    public String showUpdateForm(@PathVariable int animalId, Model model){
        model.addAttribute("animal", animalService.getAnimalById(animalId));
        return"animal-update";
    }

    @PostMapping("/update")
    public String updateAnimal(Animal animal){
        animalService.addAnimal(animal);
        return "redirect:/animals/" + animal.getAnimalId();
    }

    @GetMapping("/delete/{animalId}")
    public String deleteAnimal(@PathVariable int animalId){
        animalService.deleteAnimal(animalId);
        return "redirect:/animals/all";
    }

    @GetMapping("/species/{species}")
    public String getAnimalsBySpecies(@RequestParam(name = "Species", defaultValue = "Feline")String species, Model model){
        model.addAttribute("animalList", animalService.getAnimalBySpecies(species));
        model.addAttribute("title", "Species Animals:"+species);
        return "animal-list";
    }

    @GetMapping("/search")
    public String searchAnimalsByName(@RequestParam(name = "Name", defaultValue = "Tiger")String name, Model model){
        model.addAttribute("animalList",animalService.searchAnimalsByName(name));
        model.addAttribute("title","Animal Name"+name);
        return "animal-list";
    }
}

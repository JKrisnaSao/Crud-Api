package com.CrudApi.JSao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {
    @Autowired private AnimalService animalService;


    /**get a list of all animal in the database
     * .../animals/all
     * @return a list of animals objects
    */
    @GetMapping
    public List<Animal> getAllAnimals(){return animalService.getAllAnimals();}

    /**
     * @param id
     * @return animal by Id
     */
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id){return animalService.getAnimalById(id);}


    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal){return animalService.addAnimal(animal);}

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id,@RequestBody Animal newAnimal){
        return animalService.updateAnimal(id,newAnimal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable int id){
        animalService.deleteAnimnal(id);
    }

    @GetMapping("/species/{species}")
    public List<Animal> getAnimalsBySpecies(@PathVariable String species){
        return animalService.getAnimalBySpecies(species);
    }

    @GetMapping("/search")
    public List<Animal> searchAnimalsByName(@RequestParam String name){
        return animalService.searchAnimalsByName(name);
    }
}

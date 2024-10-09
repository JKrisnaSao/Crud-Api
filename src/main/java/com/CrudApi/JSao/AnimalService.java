package com.CrudApi.JSao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AnimalService
 * Centralized data access to the animal database
 */

@Service
public class AnimalService {

    @Autowired AnimalRepository animalRepository;


    /**
     * Fetch all animals
     * @return list of animals
     */
    public List<Animal> getAllAnimals(){return animalRepository.findAll();}


    /**
     * Fetch a unique animal
     * @param animalId the unique animal Id
     * @return a unique animal object
     */
    public Animal getAnimalById(int animalId){return animalRepository.findById(animalId).orElse(null);}

    /**
     * Add a animal
     * @param animal
     * @return added a new animal
     */
    public Animal addAnimal(Animal animal){return animalRepository.save(animal);}


    /**
     * Update a animal
     * @param id
     * @param newAnimal the update aniaml
     * @return updated animal
     */
    public Animal updateAnimal(int id, Animal newAnimal){
        return animalRepository.findById(id).map(animal ->{
            animal.setName(newAnimal.getName());
            animal.setScientificName(newAnimal.getScientificName());
            animal.setSpecies(newAnimal.getSpecies());
            animal.setHabitat(newAnimal.getHabitat());
            animal.setDescription(newAnimal.getDescription());
            return animalRepository.save(animal);
        }).orElse(null);
    }

    /**
     * Delete  aniamal from the database
     * @param id
     *
     */
    public void deleteAnimnal(int id){
        animalRepository.deleteById(id);
    }


    /**
     * Get a list of animals by the species
     * @param species
     * @return
     */
    public List<Animal> getAnimalBySpecies(String species){
        return animalRepository.findBySpecies(species);
    }


    /**
     * Get a list of animals by the name
     * @param name
     * @return
     */
    public List<Animal> searchAnimalsByName(String name){
        return animalRepository.findByNameContaining(name);
    }

}

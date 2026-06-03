package controller;

import model.Animal;
import service.AnimalService;

import java.util.List;

public class AnimalController {

    private AnimalService animalService =
            new AnimalService();

    // CREATE
    public void cadastrarAnimal(Animal animal) {

        animalService.adicionarAnimal(animal);
    }

    // READ
    public List<Animal> listarAnimais() {

        return animalService.listar();
    }

    // SEARCH
    public Animal buscarAnimal(String nome) {

        return animalService.buscarPorNome(nome);
    }

    // DELETE
    public void removerAnimal(Animal animal) {

        animalService.removerAnimal(animal);
    }
}

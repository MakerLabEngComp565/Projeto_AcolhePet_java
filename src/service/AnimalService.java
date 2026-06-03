package service;

import model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalService {

    private List<Animal> animais =
            new ArrayList<>();

    // CREATE
    public void adicionarAnimal(Animal animal) {

        animais.add(animal);
    }

    // READ
    public List<Animal> listar() {

        return animais;
    }

    // SEARCH
    public Animal buscarPorNome(String nome) {

        for (Animal animal : animais) {

            if (animal.getNome()
                    .equalsIgnoreCase(nome)) {

                return animal;
            }
        }

        return null;
    }

    // DELETE
    public void removerAnimal(Animal animal) {

        animais.remove(animal);
    }
}
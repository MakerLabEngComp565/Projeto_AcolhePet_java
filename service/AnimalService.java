package service;

import java.util.ArrayList;
import java.util.List;

import model.Animal;

// Classe responsável pelo gerenciamento dos animais
public class AnimalService {

    // Lista de animais do sistema
    private List<Animal> listaAnimais = new ArrayList<>();

    // Método responsável por adicionar animal
    public void adicionarAnimal(Animal animal) {
        listaAnimais.add(animal);
    }

    // Método responsável por remover animal
    public void removerAnimal(Animal animal) {
        listaAnimais.remove(animal);
    }

    // Método responsável por listar animais
    public List<Animal> listar() {
        return listaAnimais;
    }

    // Método responsável por buscar animal pelo nome
    public Animal buscarPorNome(String nome) {

        for (Animal animal : listaAnimais) {

            if (animal.getNome().equalsIgnoreCase(nome)) {
                return animal;
            }
        }

        return null;
    }

    // Método responsável por atualizar animal
    public void atualizarAnimal(int indice, Animal novoAnimal) {

        if (indice >= 0 && indice < listaAnimais.size()) {

            listaAnimais.set(indice, novoAnimal);

            System.out.println("Animal atualizado com sucesso!");

        } else {

            System.out.println("Índice inválido!");
        }
    }
}

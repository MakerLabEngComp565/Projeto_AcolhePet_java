package service;
import java.util.*;

import model.Animal;
public class AnimalService {
 private List<Animal> listaAnimais = new ArrayList<>();
 public void adicionarAnimal(Animal animal) {
 listaAnimais.add(animal);
 }
 public void removerAnimal(Animal animal) {
 listaAnimais.remove(animal);
 }
 public List<Animal> listar() {
 return listaAnimais;
 }
}

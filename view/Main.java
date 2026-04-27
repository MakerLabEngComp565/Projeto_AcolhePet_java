package view;
import model.Adocao;
import model.Animal;
import model.Pessoa;
import service.AdocaoService;
import service.AnimalService;
import service.PessoaService;

public class Main {
 public static void main(String[] args) {
 PessoaService pessoaService = new PessoaService();
 AnimalService animalService = new AnimalService();
 AdocaoService adocaoService = new AdocaoService();
 Pessoa pessoa = new Pessoa(1, "Ana", "email");
 Animal animal = new Animal(1, "Rex", "Disponível");
 pessoaService.cadastrarPessoa(pessoa);
 animalService.adicionarAnimal(animal);
 Adocao adocao = new Adocao(pessoa, animal);
 adocao.finalizarAdocao();
 adocaoService.registrarAdocao(adocao);
 System.out.println("Adoção realizada!");
 }
}

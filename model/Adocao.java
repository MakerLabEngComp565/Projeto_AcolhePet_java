package model;
public class Adocao {
 private Pessoa pessoa;
 private Animal animal;
 public Adocao(Pessoa pessoa, Animal animal) {
 this.pessoa = pessoa;
 this.animal = animal;
 }
 public void finalizarAdocao() {
 animal.atualizarStatus("Adotado");
 }
 @Override
public String toString() {
    return "Adoção -> Pessoa: " + pessoa.getNome() +
           " | Animal: " + animal.toString();
}
}



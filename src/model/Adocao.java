package model;

public class Adocao {

    private Pessoa pessoa;
    private Animal animal;

    public Adocao(Pessoa pessoa,
                  Animal animal) {

        this.pessoa = pessoa;
        this.animal = animal;
    }

    public void finalizarAdocao() {

        animal.atualizarStatus("Adotado");
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Animal getAnimal() {
        return animal;
    }

    @Override
    public String toString() {

        return "Adoção -> Pessoa: "
                + pessoa.getNome()
                + " | "
                + animal.toString();
    }
}
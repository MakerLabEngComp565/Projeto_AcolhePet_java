package model;

public class Animal {

    private int id;
    private String nome;
    private String status;

    // Construtor vazio (sobrecarga)
    public Animal() {

    }

    // Construtor principal
    public Animal(int id, String nome, String status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    // Método responsável por atualizar o status do animal
    public void atualizarStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Animal: " + nome + " | Status: " + status;
    }
}
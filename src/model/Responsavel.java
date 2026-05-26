package model;

public class Responsavel extends Pessoa {

    private String telefone;

    public Responsavel(int id, String nome,
                       String email, String telefone) {

        super(id, nome, email);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Responsável: " + getNome() +
               " | Telefone: " + telefone;
    }
}
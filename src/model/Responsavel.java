package model;

public class Responsavel extends Pessoa {

    private String telefoneResponsavel;

    public Responsavel(int id,
                       String nome,
                       String email,
                       String telefone,
                       String telefoneResponsavel) {

        super(id, nome, email, telefone);

        this.telefoneResponsavel =
                telefoneResponsavel;
    }

    public String getTelefoneResponsavel() {

        return telefoneResponsavel;
    }

    @Override
    public String toString() {

        return "Responsável: "
                + getNome()
                + " | Telefone: "
                + telefoneResponsavel;
    }
}
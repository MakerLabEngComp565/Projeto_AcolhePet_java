package model;

public class Animal {

    private int id;
    private String nome;
    private String tipo;
    private String raca;
    private int idade;
    private String status;
    private String statusVacinacao; // Atributo de vacinação[cite: 7]

    // SOBRECARGA[cite: 7]
    public Animal() {

    }

    public Animal(int id,
                  String nome,
                  String tipo,
                  String raca,
                  int idade,
                  String status,
                  String statusVacinacao) { // Construtor atualizado[cite: 7]

        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.raca = raca;
        this.idade = idade;
        this.status = status;
        this.statusVacinacao = statusVacinacao;
    }

    public void atualizarStatus(String status) {

        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusVacinacao() { 
        return statusVacinacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusVacinacao(String statusVacinacao) { 
        this.statusVacinacao = statusVacinacao;
    }

    @Override
    public String toString() {

        return "Animal: "
                + nome
                + " | Tipo: "
                + tipo
                + " | Raça: "
                + raca
                + " | Idade: "
                + idade
                + " anos"
                + " | Status: "
                + status
                + " | Vacinação: "
                + statusVacinacao; // Exibição do status[cite: 7]
    }
}
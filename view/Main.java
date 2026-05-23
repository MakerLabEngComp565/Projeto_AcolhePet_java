package view;

import java.util.Scanner;

import model.Adocao;
import model.Animal;
import model.Pessoa;

import service.AdocaoService;
import service.AnimalService;
import service.PessoaService;

public class Main {

    public static void main(String[] args) {

        // Criação dos services
        PessoaService pessoaService = new PessoaService();
        AnimalService animalService = new AnimalService();
        AdocaoService adocaoService = new AdocaoService();

        // Scanner para entrada de dados
        Scanner sc = new Scanner(System.in);

        int opcao;

        // Menu principal do sistema
        do {

            System.out.println("\n=== ACOLHE PET ===");
            System.out.println("1 - Cadastrar animal");
            System.out.println("2 - Listar animais");
            System.out.println("3 - Registrar adoção");
            System.out.println("4 - Listar adoções");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    // Cadastro de animal
                    System.out.println("\n--- CADASTRO DE ANIMAL ---");

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    // Validação do ID
                    if (id <= 0) {
                        System.out.println("ID inválido!");
                        break;
                    }

                    System.out.print("Nome do animal: ");
                    String nomeAnimal = sc.nextLine();

                    // Validação do nome
                    if (nomeAnimal.isEmpty()) {
                        System.out.println("Nome inválido!");
                        break;
                    }

                    System.out.print("Status: ");
                    String status = sc.nextLine();

                    Animal animal = new Animal(id, nomeAnimal, status);

                    animalService.adicionarAnimal(animal);

                    System.out.println("Animal cadastrado com sucesso!");

                    break;

                case 2:

                    // Listagem de animais
                    System.out.println("\n--- LISTA DE ANIMAIS ---");

                    if (animalService.listar().isEmpty()) {
                        System.out.println("Nenhum animal cadastrado.");
                    } else {

                        for (Animal a : animalService.listar()) {
                            System.out.println(a);
                        }
                    }

                    break;

                case 3:

                    // Registro de adoção
                    System.out.println("\n--- REGISTRO DE ADOÇÃO ---");

                    // Verifica se existe animal cadastrado
                    if (animalService.listar().isEmpty()) {
                        System.out.println("Nenhum animal disponível.");
                        break;
                    }

                    // Criação simples de pessoa
                    Pessoa pessoa = new Pessoa(
                            1,
                            "Ana",
                            "ana@email.com"
                    );

                    pessoaService.cadastrarPessoa(pessoa);

                    // Pega o primeiro animal da lista
                    Animal animalAdocao =
                            animalService.listar().get(0);

                    // Cria adoção
                    Adocao adocao =
                            new Adocao(pessoa, animalAdocao);

                    // Atualiza status do animal
                    adocao.finalizarAdocao();

                    // Registra adoção
                    adocaoService.registrarAdocao(adocao);

                    System.out.println(
                            "Adoção registrada com sucesso!"
                    );

                    break;

                case 4:

                    // Listagem de adoções
                    System.out.println(
                            "\n--- RELATÓRIO DE ADOÇÕES ---"
                    );

                    if (adocaoService.listarAdocoes().isEmpty()) {

                        System.out.println(
                                "Nenhuma adoção registrada."
                        );

                    } else {

                        for (Adocao a :
                                adocaoService.listarAdocoes()) {

                            System.out.println(a);
                        }
                    }

                    break;

                case 5:

                    System.out.println("Sistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        sc.close();
    }
}
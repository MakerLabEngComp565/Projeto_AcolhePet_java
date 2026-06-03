package view;

import controller.AdocaoController;
import controller.AnimalController;

import model.Adocao;
import model.Animal;
import model.Pessoa;

import service.PessoaService;

import java.util.Scanner;

public class Main {

    // Constantes para cores no console
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_ORANGE = "\u001B[38;5;208m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PessoaService pessoaService = new PessoaService();
        AnimalController animalController = new AnimalController();
        AdocaoController adocaoController = new AdocaoController();

        int opcaoUsuario;

        do {

            System.out.println("\n=== MENU USUÁRIO ===");
            System.out.println("1 - Listar animais");
            System.out.println("2 - Registrar adoção");
            System.out.println("3 - Cancelar adoção");
            System.out.println("4 - Área administrativa");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcaoUsuario = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcaoUsuario = 0;
            }

            switch (opcaoUsuario) {

                case 1:
                    // LISTAR ANIMAIS
                    if (animalController.listarAnimais().isEmpty()) {
                        System.out.println("\n--- LISTA DE ANIMAIS DISPONÍVEIS ---");
                        System.out.println(ANSI_RED + "Nenhum animal cadastrado." + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_YELLOW + "\n--- LISTA DE ANIMAIS DISPONÍVEIS ---" + ANSI_RESET);
                        boolean encontrouAnimal = false;
                        for (Animal a : animalController.listarAnimais()) {
                            if (a.getStatus().equalsIgnoreCase("Disponível")) {
                                String racaExibida = a.getRaca().contains("Sem Ra") ? "Sem Raça Definida" : a.getRaca();
                                System.out.println(ANSI_YELLOW + "Nome do Animal: " + a.getNome() + " | Tipo: " + a.getTipo() + " | Raça: " + racaExibida + " | Idade: " + a.getIdade() + " | Vacinação: " + a.getStatusVacinacao() + ANSI_RESET);
                                encontrouAnimal = true;
                            }
                        }

                        if (!encontrouAnimal) {
                            System.out.println(ANSI_RED + "Não há animais disponíveis no momento." + ANSI_RESET);
                        }
                    }
                    break;

                case 2:
                    // REGISTRAR ADOÇÃO
                    System.out.println("\n--- REGISTRAR ADOÇÃO ---");

                    if (animalController.listarAnimais().isEmpty()) {
                        System.out.println(ANSI_RED + "Nenhum animal disponível." + ANSI_RESET);
                        break;
                    }

                    boolean existemDisponiveis = false;
                    for (Animal a : animalController.listarAnimais()) {
                        if (a.getStatus().equalsIgnoreCase("Disponível")) {
                            existemDisponiveis = true;
                        }
                    }

                    if (!existemDisponiveis) {
                        System.out.println(ANSI_RED + "Não há animais qualificados para adoção no momento." + ANSI_RESET);
                        break;
                    }

                    // EXIBIÇÃO DA LISTA ANTES DE PEDIR OS DADOS
                    System.out.println(ANSI_YELLOW + "\n--- ANIMAIS DISPONÍVEIS PARA ADOÇÃO ---" + ANSI_RESET);
                    for (Animal a : animalController.listarAnimais()) {
                        if (a.getStatus().equalsIgnoreCase("Disponível")) {
                            String racaExibida = a.getRaca().contains("Sem Ra") ? "Sem Raça Definida" : a.getRaca();
                            System.out.println(ANSI_YELLOW + "Nome: " + a.getNome() + " | Tipo: " + a.getTipo() + " | Raça: " + racaExibida + " | Idade: " + a.getIdade() + " | Vacinação: " + a.getStatusVacinacao() + ANSI_RESET);
                        }
                    }

                    // Validações com "apenas letras" e retorno ao menu em caso de erro
                    System.out.print("Digite o nome do animal: ");
                    String nomeBusca = sc.nextLine();
                    if (!apenasLetras(nomeBusca)) {
                        System.out.println("\n" + ANSI_RED + "Erro, algo aconteceu de errado" + ANSI_RESET);
                        break;
                    }

                    System.out.print("Digite o tipo do animal: ");
                    String tipoBusca = sc.nextLine();
                    if (!apenasLetras(tipoBusca)) {
                        System.out.println("\n" + ANSI_RED + "Erro, algo aconteceu de errado" + ANSI_RESET);
                        break;
                    }

                    System.out.print("Qual Seria a Raça do Animal?: ");
                    String racaBusca = sc.nextLine();
                    if (!apenasLetras(racaBusca)) {
                        System.out.println("\n" + ANSI_RED + "Erro, algo aconteceu de errado" + ANSI_RESET);
                        break;
                    }

                    // Validação de idade: Apenas números obrigatórios
                    System.out.print("Quantos anos o animal tem: ");
                    int idadeBusca;
                    try {
                        String inputIdade = sc.nextLine();
                        if (!inputIdade.matches("\\d+")) {
                            throw new NumberFormatException();
                        }
                        idadeBusca = Integer.parseInt(inputIdade);
                    } catch (NumberFormatException e) {
                        System.out.println("\n" + ANSI_RED + "Erro, algo aconteceu de errado" + ANSI_RESET);
                        break;
                    }

                    System.out.print("Qual seria o Tipo ou Status da Vacinação?: ");
                    String vacinaBusca = sc.nextLine();
                    if (!apenasLetras(vacinaBusca)) {
                        System.out.println("\n" + ANSI_RED + "Erro, algo aconteceu de errado" + ANSI_RESET);
                        break;
                    }

                    Animal animalAdocao = null;
                    for (Animal a : animalController.listarAnimais()) {
                        if (a.getNome().equalsIgnoreCase(nomeBusca)
                            && a.getTipo().equalsIgnoreCase(tipoBusca)
                            && (a.getRaca().equalsIgnoreCase(racaBusca) || a.getRaca().contains("Sem Ra"))
                            && a.getIdade() == idadeBusca
                            && a.getStatusVacinacao().equalsIgnoreCase(vacinaBusca)
                            && a.getStatus().equalsIgnoreCase("Disponível")) {
                            animalAdocao = a;
                            break;
                        }
                    }

                    if (animalAdocao == null) {
                        System.out.println("\n" + ANSI_RED + "Erro, algo aconteceu de errado" + ANSI_RESET);
                        break;
                    }

                    System.out.println("\n" + ANSI_GREEN + "Animal encontrado:" + ANSI_RESET);
                    String racaEncontrada = animalAdocao.getRaca().contains("Sem Ra") ? "Sem Raça Definida" : animalAdocao.getRaca();
                    System.out.println(ANSI_YELLOW + "Nome do Animal: " + animalAdocao.getNome() + " | Tipo: " + animalAdocao.getTipo() + " | Raça: " + racaEncontrada + " | Idade: " + animalAdocao.getIdade() + " | Vacinação: " + animalAdocao.getStatusVacinacao() + ANSI_RESET);

                    System.out.print("\nNome da pessoa: ");
                    String nomePessoa = sc.nextLine();

                    String emailPessoa;
                    do {
                        System.out.print("Email da pessoa (exemplo@dominio.com): ");
                        emailPessoa = sc.nextLine();
                        if (!validarEmail(emailPessoa)) System.out.println(ANSI_RED + "Erro: Formato de e-mail inválido! Tente novamente." + ANSI_RESET);
                    } while (!validarEmail(emailPessoa));

                    String telephonePessoa;
                    do {
                        System.out.print("Telefone da pessoa com DDD (Ex: (11) 99999-9999): ");
                        telephonePessoa = sc.nextLine();
                        if (!validarTelefone(telephonePessoa)) System.out.println(ANSI_RED + "Erro: Formato inválido! Use o padrão (XX) XXXXX-XXXX." + ANSI_RESET);
                    } while (!validarTelefone(telephonePessoa));

                    Pessoa pessoa = new Pessoa(1, nomePessoa, emailPessoa, telephonePessoa);
                    pessoaService.cadastrarPessoa(pessoa);
                    Adocao adocao = new Adocao(pessoa, animalAdocao);
                    adocao.finalizarAdocao();
                    adocaoController.registrarAdocao(adocao);
                    System.out.println(ANSI_GREEN + "\nAdoção realizada com sucesso!" + ANSI_RESET);
                    break;

                case 3:
                    // CANCELAR ADOÇÃO
                    System.out.println("\n--- CANCELAR ADOÇÃO ---");
                    if (adocaoController.listarAdocoes().isEmpty()) {
                        System.out.println(ANSI_RED + "Nenhuma adoção cadastrada." + ANSI_RESET);
                        break;
                    }
                    for (Adocao a : adocaoController.listarAdocoes()) System.out.println(a);

                    Adocao cancelarAdocao = adocaoController.listarAdocoes().get(0);
                    adocaoController.removerAdocao(cancelarAdocao);
                    System.out.println(ANSI_GREEN + "Adoção cancelada com sucesso!" + ANSI_RESET);
                    break;

                case 4:
                    int opcaoAdmin;
                    do {
                        System.out.println("\n=== ÁREA ADMINISTRATIVA ===");
                        System.out.println("1 - Cadastrar animal");
                        System.out.println("2 - Listar animais");
                        System.out.println("3 - Listar adoções");
                        System.out.println("4 - Remover animal");
                        System.out.println("5 - Remover adoção");
                        System.out.println("6 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        try {
                            opcaoAdmin = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            opcaoAdmin = 0;
                        }

                        switch (opcaoAdmin) {
                            case 1:
                                // CADASTRAR ANIMAL
                                System.out.println("\n--- CADASTRO DE ANIMAL ---");
                                try {
                                    System.out.print("ID: ");
                                    int id = Integer.parseInt(sc.nextLine());

                                    System.out.print("Nome do animal: ");
                                    String nomeAnimal = sc.nextLine();
                                    if (!apenasLetras(nomeAnimal)) throw new Exception("Nome inválido");

                                    System.out.print("Tipo do animal: ");
                                    String tipoAnimal = sc.nextLine();
                                    if (!apenasLetras(tipoAnimal)) throw new Exception("Tipo inválido");

                                    System.out.print("Qual Seria a Raça do Animal? Caso não possua raça definida, preencha como (Sem Raca Definida): ");
                                    String racaAnimal = sc.nextLine();
                                    if (!apenasLetras(racaAnimal)) throw new Exception("Raça inválida");

                                    System.out.print("Quantos anos o animal tem: ");
                                    int idadeAnimal = Integer.parseInt(sc.nextLine());

                                    System.out.print("Qual é o Status da Vacinação do animal? Se estiver completa digite (\"Completa\"), se não tiver nenhuma vacina digite (\"Nenhuma\"): ");
                                    String statusVacinacao = sc.nextLine();
                                    if (!apenasLetras(statusVacinacao)) throw new Exception("Status vacinação inválido");

                                    Animal animal = new Animal(id, nomeAnimal, tipoAnimal, racaAnimal, idadeAnimal, "Disponível", statusVacinacao);
                                    animalController.cadastrarAnimal(animal);
                                    System.out.println(ANSI_GREEN + "Animal cadastrado com sucesso!" + ANSI_RESET);
                                } catch (Exception e) {
                                    System.out.println();
                                    System.out.println(ANSI_RED + "Erro, algo aconteceu de errado" + ANSI_RESET);
                                }
                                break;

                            case 2:
                                // LISTAR ANIMAIS (ADMIN)
                                if (animalController.listarAnimais().isEmpty()) {
                                    System.out.println("\n--- LISTA GERAL DE ANIMAIS CADASTRADOS (ADMIN) ---");
                                    System.out.println(ANSI_RED + "Nenhum animal cadastrado." + ANSI_RESET);
                                } else {
                                    System.out.println(ANSI_YELLOW + "\n--- LISTA GERAL DE ANIMAIS CADASTRADOS (ADMIN) ---" + ANSI_RESET);
                                    for (Animal a : animalController.listarAnimais()) {
                                        String racaExibida = a.getRaca().contains("Sem Ra") ? "Sem Raça Definida" : a.getRaca();
                                        System.out.println(ANSI_YELLOW + "ID: " + a.getId() + " | Nome: " + a.getNome() + " | Tipo: " + a.getTipo() + " | Raça: " + racaExibida + " | Idade: " + a.getIdade() + " | Vacinação: " + a.getStatusVacinacao() + ANSI_RESET);
                                    }
                                }
                                break;

                            case 3:
                                // LISTAR ADOÇÕES
                                if (adocaoController.listarAdocoes().isEmpty()) {
                                    System.out.println("\n--- LISTA DE ADOÇÕES ---");
                                    System.out.println(ANSI_RED + "Nenhuma adoção registrada." + ANSI_RESET);
                                } else {
                                    System.out.println(ANSI_YELLOW + "\n--- LISTA DE ADOÇÕES ---" + ANSI_RESET);
                                    for (Adocao a : adocaoController.listarAdocoes()) {
                                        String racaFormatada = a.getAnimal().getRaca().contains("Sem Ra") ? "Sem Raça Definida" : a.getAnimal().getRaca();
                                        System.out.println(ANSI_YELLOW + "Adotante: " + a.getPessoa().getNome() + " | E-mail: " + a.getPessoa().getEmail() + " | Telefone: " + a.getPessoa().getTelefone() + " | Nome do Animal: " + a.getAnimal().getNome() + " | Tipo: " + a.getAnimal().getTipo() + " | Raça: " + racaFormatada + " | Idade: " + a.getAnimal().getIdade() + "\nVacinação: " + a.getAnimal().getStatusVacinacao() + ANSI_RESET);
                                    }
                                }
                                break;

                            case 4:
                                // REMOVER ANIMAL (ATUALIZADO)
                                System.out.println("\n--- REMOVER ANIMAL ---");
                                if (animalController.listarAnimais().isEmpty()) {
                                    System.out.println(ANSI_RED + "Nenhum animal cadastrado." + ANSI_RESET);
                                    break;
                                }

                                // Exibição formatada com IDs e Vacinação
                                System.out.println(ANSI_YELLOW + "Lista de animais cadastrados para remoção:" + ANSI_RESET);
                                for (Animal a : animalController.listarAnimais()) {
                                    System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome() + " | Tipo: " + a.getTipo() + " | Raça: " + a.getRaca() + " | Idade: " + a.getIdade() + " | Vacinação: " + a.getStatusVacinacao());
                                }

                                System.out.print("\nQual é o ID do Seu Animal?: ");
                                int removerId = Integer.parseInt(sc.nextLine());

                                System.out.print("Digite o nome do animal: ");
                                String removerNome = sc.nextLine();
                                System.out.print("Digite o tipo do animal: ");
                                String removerTipo = sc.nextLine();
                                System.out.print("Qual Seria a Raça do Animal?: ");
                                String removerRaca = sc.nextLine();
                                System.out.print("Quantos anos o animal tem: ");
                                int removerIdade = Integer.parseInt(sc.nextLine());
                                System.out.print("Qual é o Status da Vacinação do animal? ");
                                String removerVacina = sc.nextLine();

                                Animal animalExcluir = null;
                                for (Animal a : animalController.listarAnimais()) {
                                    if (a.getId() == removerId
                                        && a.getNome().equalsIgnoreCase(removerNome)
                                        && a.getTipo().equalsIgnoreCase(removerTipo)
                                        && (a.getRaca().equalsIgnoreCase(removerRaca) || a.getRaca().contains("Sem Ra"))
                                        && a.getIdade() == removerIdade
                                        && a.getStatusVacinacao().equalsIgnoreCase(removerVacina)) {
                                        animalExcluir = a;
                                        break;
                                    }
                                }
                                if (animalExcluir != null) {
                                    System.out.println("\n" + ANSI_GREEN + "Animal encontrado:" + ANSI_RESET);
                                    // Impressão personalizada conforme solicitado
                                    System.out.println("Nome do Animal: " + animalExcluir.getNome() + " | Tipo: " + animalExcluir.getTipo() + " | Raça: " + animalExcluir.getRaca() + " | Idade: " + animalExcluir.getIdade() + " | Vacinação: " + animalExcluir.getStatusVacinacao());
                                    animalController.removerAnimal(animalExcluir);
                                    System.out.println(ANSI_GREEN + "Animal removido com sucesso!" + ANSI_RESET);
                                } else {
                                    System.out.println(ANSI_RED + "\nErro, algo aconteceu de errado (verifique se os dados estão corretos)" + ANSI_RESET);
                                }
                                break;

                            case 5:
                                // REMOVER ADOÇÃO
                                System.out.println("\n--- REMOVER ADOÇÃO ---");
                                if (adocaoController.listarAdocoes().isEmpty()) {
                                    System.out.println(ANSI_RED + "Nenhuma adoção cadastrada." + ANSI_RESET);
                                    break;
                                }
                                Adocao adocaoRemover = adocaoController.listarAdocoes().get(0);
                                adocaoController.removerAdocao(adocaoRemover);
                                System.out.println(ANSI_GREEN + "Adoção removida com sucesso!" + ANSI_RESET);
                                break;

                            case 6:
                                System.out.println("\n" + ANSI_ORANGE + "Voltando ao menu principal." + ANSI_RESET);
                                break;
                            default:
                                System.out.println(ANSI_RED + "Opção inválida!" + ANSI_RESET);
                        }
                    } while (opcaoAdmin != 6);
                    break;

                case 5:
                    System.out.println("\n" + ANSI_ORANGE + "Sistema encerrado." + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_RED + "Opção inválida!" + ANSI_RESET);
            }
        } while (opcaoUsuario != 5);
        sc.close();
    }

    private static boolean validarEmail(String email) {
        String regexEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regexEmail);
    }

    private static boolean validarTelefone(String telephone) {
        String regexTelefone = "^\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}$";
        return telephone.matches(regexTelefone);
    }

    private static boolean apenasLetras(String texto) {
        return texto.matches("^[a-zA-Z\\sÀ-ú]+$");
    }
}
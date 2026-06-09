# AcolhePet 🐾

Este projeto tem como objetivo incentivar a adoção responsável e combater o abandono de **cães e gatos**, conectando animais em situação de vulnerabilidade a pessoas que desejam lhes oferecer um novo lar.

---

## 🚀 Como Executar (Versão Atual)
Atualmente, o projeto utiliza uma Interface Gráfica (GUI) desenvolvida com Java Swing.
1. Certifique-se de ter o JDK 8 ou superior instalado.
2. Compile os arquivos `.java` do projeto.
3. Execute a classe `view.JanelaPrincipal`.

---

## 🛠 Tecnologias Utilizadas
* **Linguagem:** Java (POO)
* **Arquitetura:** MVC (Model-View-Controller)
* **Interface:** Java Swing (Atual) / Console (Anterior)
* **Validações:** Regex para e-mail e telefone

---

## 📜 Histórico de Desenvolvimento (Changelog)

Abaixo, a evolução do sistema ao longo das etapas acadêmicas:

### 🔄 Atualização 1: Estrutura Inicial
* Criação das classes de Modelo (Pessoa, Animal, Adoção) e serviços.
* Implementação inicial da lógica de CRUD básico utilizando ArrayList para armazenamento.

### 🔄 Atualização 2: Melhorias no Console (CLI)
* Implementação do padrão MVC com `AnimalController` e `AdocaoController`.
* Adição de validações rigorosas com Regex para e-mail e telefone.
* Interface de console interativa com uso de cores ANSI para melhor legibilidade.

### 🔄 Atualização 3: Proteções Robustas e Listagens no Console (CLI)
* **Blindagem com try-catch:** Implementação de blocos de tratamento de exceções robustos para capturar e tratar falhas de digitação (`NumberFormatException` e `Exception` genérica), evitando a quebra do sistema durante entradas de dados numéricos (como IDs e idade) na área administrativa e no fluxo de adoção.
* **Exibição Dinâmica de Listas:** Inclusão de relatórios e listagens automáticas logo antes dos comandos de remoção e adoção, garantindo que o usuário veja as informações e IDs corretos antes de responder às perguntas do sistema.
* **Mecanismo Seguro de Remoção:** Implementação de lógica rigorosa que valida e cruza os dados fornecidos pelo usuário com os registros existentes antes de concluir operações críticas como exclusão de animais ou cancelamento de adoções.



---
*Projeto desenvolvido para fins acadêmicos.*

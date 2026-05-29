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

### 🔄 Atualização 3: Migração para Interface Gráfica (Atual)
* Desenvolvimento da `JanelaPrincipal` utilizando Java Swing.
* Substituição das interações via terminal por janelas (`JOptionPane`) e abas (`JTabbedPane`).
* O sistema agora conta com uma visualização de área de texto dedicada para listagens.

---
*Projeto desenvolvido para fins acadêmicos.*

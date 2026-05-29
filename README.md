# Sistema de Adoção de Animais

---
## Descrição

Este projeto foi desenvolvido como parte de uma atividade acadêmica, com o objetivo de aplicar conceitos de Programação Orientada a Objetos (POO) em Java. E  tem como objetivo incentivar a adoção responsável de animais, conectando pessoas interessadas a pets que precisam de um novo lar.

O sistema simula um processo simples de adoção de animais, permitindo o cadastro de pessoas, cadastro de animais e o registro de adoções.

---
## Sobre o projeto

A iniciativa busca reduzir o número de animais abandonados, promovendo a adoção consciente e oferecendo informações importantes sobre cuidados, responsabilidade e bem-estar animal.

---
## Objetivo
 
 * Diminuir o abandono de animais
 * Facilitar o processo de adoção
 * Conscientizar sobre guarda responsável

---
## Estrutura do Projeto

O projeto está organizado em três camadas:

* Model: classes que representam as entidades do sistema (Pessoa, Animal, Adocao)
* Service: classes responsáveis pelas regras de negócio e armazenamento dos dados (utilizando ArrayList)
* View: classe principal (Main), responsável pela execução do sistema

---

## Funcionalidades

* Cadastro de pessoas
* Cadastro de animais
* Registro de adoção
* Atualização do status do animal
* Filtro por tipo de animal
* Contato com responsáveis / ONG
* Informações detalhadas (idade, porte, saúde, etc.)

---

## Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos (POO)

---

## Execução

Para executar o projeto:

1. Abrir o projeto em uma IDE compatível com Java (VS Code, Eclipse, etc.)
2. Localizar a classe Main no pacote view
3. Executar o método main

---

## Observações

O projeto foi desenvolvido seguindo os requisitos propostos, incluindo:

* Uso de atributos privados
* Implementação de getters e setters
* Uso do método toString() para facilitar a visualização dos dados
* Utilização de listas (ArrayList) nos serviços

---

## Autor
Desenvolvido para fins acadêmicos.

---
## Atualização 1 🔄️
---

## Descrição

Este projeto foi desenvolvido como parte de uma atividade acadêmica, com o objetivo de aplicar conceitos de Programação Orientada a Objetos (POO) em Java.

O sistema AcolhePet tem como objetivo incentivar a adoção responsável de animais, conectando pessoas interessadas a pets que precisam de um novo lar.

O sistema simula um processo simples de adoção de animais, permitindo:
- cadastro de pessoas
- cadastro de animais
- registro de adoções
- gerenciamento das informações do sistema

---

# Sobre o Projeto

A iniciativa busca reduzir o número de animais abandonados, promovendo a adoção consciente e oferecendo informações importantes sobre:
- responsabilidade
- cuidados com os animais
- bem-estar animal

---

# Objetivos

- Diminuir o abandono de animais
- Facilitar o processo de adoção
- Conscientizar sobre guarda responsável
- Aplicar conceitos de Programação Orientada a Objetos
- Simular um sistema CRUD simples em Java

---

# Estrutura do Projeto

O projeto está organizado em três camadas:

## Model
Classes que representam as entidades do sistema:
- Pessoa
- Responsavel
- Animal
- Adocao

---

## Service
Classes responsáveis pelas regras de negócio e manipulação dos dados:
- PessoaService
- AnimalService
- AdocaoService

Utilizando:
```java ```
``` ArrayList ```

---
## Atualização 2 🔄️
---


## 🚀 Funcionalidades

### Usuário
- **Listar Animais:** Visualização de todos os animais disponíveis para adoção.
- **Registrar Adoção:** Interface para adotar um animal, com validações de dados (nome, e-mail, telefone).
- **Cancelar Adoção:** Opção para remover um registro de adoção existente.

### Área Administrativa
- **Cadastro de Animais:** Registro de novos animais no sistema (ID, Nome, Tipo, Raça, Idade, Vacinação).
- **Listagem Completa:** Visualização de todos os animais cadastrados.
- **Gerenciamento de Adoções:** Listagem de todas as adoções realizadas.
- **Exclusão:** Possibilidade de remover animais ou cancelar registros de adoção específicos.

---

## 🛠 Tecnologias Utilizadas

- **Linguagem:** Java
- **Paradigma:** Orientação a Objetos
- **Interface:** Console (CLI - Command Line Interface)
- **Validações:** Regex para e-mail, telefone e formatos de texto.

---

## 📋 Pré-requisitos

Para rodar este projeto, você precisará ter instalado em sua máquina:
- **JDK** (Java Development Kit) 8 ou superior.

---

### Menu do Usuário
* **Listar Animais:** Visualização de animais disponíveis para adoção, com filtro de status.
* **Registrar Adoção:** Cadastro de adotante com validações rigorosas de e-mail e telefone.
* **Cancelar Adoção:** Funcionalidade para reverter processos de adoção.

---

### Área Administrativa
* **Gerenciamento de Animais:** Cadastro, listagem geral e remoção de animais do sistema.
* **Gestão de Adoções:** Listagem completa de todas as adoções realizadas no sistema e remoção de registros.

---

## 🛠 Tecnologias e Conceitos
* **Linguagem:** Java
* **Arquitetura:** MVC (Model-View-Controller)
* **Validações:** Uso de `Regex` (Expressões Regulares) para validação de dados de entrada.
* **Interface:** Console interativo com suporte a cores ANSI para melhor legibilidade.

---

## 📂 Estrutura do Projeto
O projeto está organizado nos seguintes pacotes:
* `view`: Interface de usuário no console.
* `controller`: Lógica de controle para animais e adoções.
* `model`: Entidades do sistema (Animal, Pessoa, Adocao).
* `service`: Regras de negócio, incluindo a gestão de pessoas.

---
## Atualização 3 🔄️
---

  ## 🛠 Tecnologias Utilizadas

* **Linguagem:** Java
* **Biblioteca de GUI:** Java Swing
* **Arquitetura:** MVC (Model-View-Controller)
* **Validadores:** Regex (Expressões Regulares)

package service;

import model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaService {

    private List<Pessoa> pessoas =
            new ArrayList<>();

    public void cadastrarPessoa(Pessoa pessoa) {

        pessoas.add(pessoa);
    }

    public List<Pessoa> listarPessoas() {

        return pessoas;
    }
}
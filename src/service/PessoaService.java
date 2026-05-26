package service;

import java.util.*;

import model.Pessoa;
public class PessoaService {
 private List<Pessoa> listaPessoas = new ArrayList<>();
 public void cadastrarPessoa(Pessoa pessoa) {
 listaPessoas.add(pessoa);
 }
 public List<Pessoa> listar() {
 return listaPessoas;
 }
}
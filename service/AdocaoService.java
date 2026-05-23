package service;
import java.util.*;

import model.Adocao;
public class AdocaoService {
 private List<Adocao> listaAdocoes = new ArrayList<>();
 public void registrarAdocao(Adocao adocao) {
 listaAdocoes.add(adocao);
 }
 public List<Adocao> listarAdocoes() {
 return listaAdocoes;
 }
}

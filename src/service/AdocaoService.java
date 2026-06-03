package service;

import model.Adocao;

import java.util.ArrayList;
import java.util.List;

public class AdocaoService {

    private List<Adocao> adocoes =
            new ArrayList<>();

    // CREATE
    public void registrarAdocao(Adocao adocao) {

        adocoes.add(adocao);
    }

    // READ
    public List<Adocao> listarAdocoes() {

        return adocoes;
    }

    // DELETE
    public void removerAdocao(Adocao adocao) {

        adocoes.remove(adocao);
    }
}
package controller;

import model.Adocao;
import service.AdocaoService;

import java.util.List;

public class AdocaoController {

    private AdocaoService adocaoService =
            new AdocaoService();

    // CREATE
    public void registrarAdocao(Adocao adocao) {

        adocaoService.registrarAdocao(adocao);
    }

    // READ
    public List<Adocao> listarAdocoes() {

        return adocaoService.listarAdocoes();
    }

    // DELETE
    public void removerAdocao(Adocao adocao) {

        adocaoService.removerAdocao(adocao);
    }
}
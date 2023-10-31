package br.ifpr.jogo.controle;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import br.ifpr.jogo.modelo.Inimigo;
import br.ifpr.jogo.modelo.Personagem;

public class FaseControler {

    public FaseControler() {
    }

    public List<Inimigo> inicializaElementosGraficosAdicionais(int qtdInimigos){
        List<Inimigo> inimigos = new ArrayList<Inimigo>();

        for (int i = 0; i < qtdInimigos; i++) {
            int x = (int) (Math.random() * 8000 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            Inimigo inimigo = new Inimigo(x, y);
            inimigos.add(inimigo);
        }
        return inimigos;
    }

    public List<Inimigo> inicializaInimigos(int qtdInimigos){
        List<Inimigo> inimigos = new ArrayList<Inimigo>();

        for (int i = 0; i < qtdInimigos; i++) {
            int x = (int) (Math.random() * 8000 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            Inimigo inimigo = new Inimigo(x, y);
            inimigos.add(inimigo);
        }
        return inimigos;
    }

    public boolean verficarColisoesPersonagem(Inimigo inimigo, Personagem personagem, boolean emJogo){
        Rectangle formaPersonagem = personagem.getRectangle();
        Rectangle formaInimigo = inimigo.getRectangle();
        if (formaInimigo.intersects(formaPersonagem)) {
            int vidaNow = personagem.getVidas();
            personagem.setVidas(vidaNow - 1);
            inimigo.setEhVisivel(false);

            if (personagem.getVidas() == 0) {
                personagem.setEhVisivel(false);
                inimigo.setEhVisivel(false);
                emJogo = false;
            }
        }
        return emJogo;
    }
}

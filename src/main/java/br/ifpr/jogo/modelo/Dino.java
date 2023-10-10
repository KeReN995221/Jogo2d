package br.ifpr.jogo.modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.swing.ImageIcon;

@Entity 
@Table (name = "tb_dino")
public class Dino extends ElementoGrafico {

    @Column(name = "velocidade_dino")
    private static final int VELOCIDADE = 1;

    public Dino(int xAleatorio, int yAleatorio) {
        this.carregar();
        super.setPosicaoEmX(xAleatorio);
        super.setPosicaoEmY(yAleatorio);
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/dino.png"));
        super.setImagem(carregando.getImage());
    }

    @Override
    public void atualizar() {
        if (this.getPosicaoEmX() < 0) {
            int y = (int) (Math.random() * 618);
            super.setPosicaoEmX(1000);
            super.setPosicaoEmY(y);
        } else {
            super.setPosicaoEmX(super.getPosicaoEmX() - VELOCIDADE);
        }
    }
}
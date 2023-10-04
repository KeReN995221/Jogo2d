import br.ifpr.jogo.modelo.Personagem;

public class App {
   
     public static void main(String[] args) {
         Personagem p = Personagem.getPersonagem();
         Personagem p2 = Personagem.getPersonagem();

         System.out.println(p);
         System.out.println(p2);
     }
    
}

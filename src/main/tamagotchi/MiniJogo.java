package tamagotchi;


import java.util.Random;
import javax.swing.JOptionPane;

public class MiniJogo {

    public void jogar(Tamagotchi t) {
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int escolhaJogador = JOptionPane.showOptionDialog(null, "Escolha:", "Mini-jogo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                opcoes, opcoes[0]);

        int escolhaCPU = new Random().nextInt(3);
        String resultado;

        if (escolhaJogador == escolhaCPU) {
            resultado = "Empate!";
            t.modificarFelicidade(5);
        } else if ((escolhaJogador == 0 && escolhaCPU == 2) ||
                   (escolhaJogador == 1 && escolhaCPU == 0) ||
                   (escolhaJogador == 2 && escolhaCPU == 1)) {
            resultado = "Você venceu!";
            t.modificarFelicidade(10);
        } else {
            resultado = "Você perdeu!";
            t.modificarFelicidade(-5);
        }

        JOptionPane.showMessageDialog(null, resultado + "\nFelicidade atual:\n" + t.getStatus());
    }
}

package ui;

import model.Tamagotchi;

import javax.swing.*;
import java.awt.*;

public class TamagotchiGUI extends JFrame {

    private Tamagotchi t;
    private JLabel status;
    private JLabel imagemLabel;

    public TamagotchiGUI() {
        iniciarNovoJogo();
    }

    private void iniciarNovoJogo() {
        String nome = JOptionPane.showInputDialog(this, "Escolha o nome do seu Tamagotchi:");
        if (nome == null || nome.isBlank()) nome = "Tama";

        t = new Tamagotchi(nome);

        setTitle("🐣 Tamagotchi Java");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(40, 40, 40));

        JLabel titulo = new JLabel("Tamagotchi");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titulo.setForeground(new Color(0, 255, 150));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));

        imagemLabel = new JLabel();
        imagemLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagemLabel.setPreferredSize(new Dimension(150, 150));
        imagemLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        status = new JLabel();
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        status.setHorizontalAlignment(SwingConstants.LEFT);
        status.setVerticalAlignment(SwingConstants.TOP);
        status.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

        JPanel botoes = new JPanel(new GridLayout(3, 3, 15, 15));
        botoes.setBackground(new Color(40, 40, 40));
        botoes.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));

        String[] nomes = {"Alimentar", "Brincar", "Dormir", "Curar", "Limpar", "Socializar", "Mini-Jogo"};
        JButton[] botoesAcoes = new JButton[nomes.length];

        for (int i = 0; i < nomes.length; i++) {
            botoesAcoes[i] = new JButton(nomes[i]);
            botoesAcoes[i].setFont(new Font("Segoe UI", Font.BOLD, 14));
            botoesAcoes[i].setBackground(new Color(70, 130, 180));
            botoesAcoes[i].setForeground(Color.WHITE);
            botoes.add(botoesAcoes[i]);
        }

        botoesAcoes[0].addActionListener(e -> {
            t.alimentar();
            verificarExplosao();
            atualizarStatus();
        });
        botoesAcoes[1].addActionListener(e -> t.brincar());
        botoesAcoes[2].addActionListener(e -> t.dormir());
        botoesAcoes[3].addActionListener(e -> t.curar());
        botoesAcoes[4].addActionListener(e -> t.limpar());
        botoesAcoes[5].addActionListener(e -> t.socializar());
        botoesAcoes[6].addActionListener(e -> t.jogarMiniJogo());

        for (JButton botao : botoesAcoes) {
            botao.addActionListener(e -> {
                verificarExplosao();
                atualizarStatus();
            });
        }

        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.setBackground(new Color(40, 40, 40));
        painelTopo.add(titulo, BorderLayout.NORTH);
        painelTopo.add(imagemLabel, BorderLayout.CENTER);

        add(painelTopo, BorderLayout.NORTH);
        add(status, BorderLayout.WEST);
        add(botoes, BorderLayout.CENTER);

        atualizarStatus();
        setVisible(true);
    }

    private void verificarExplosao() {
        if (t.getEstado() == Tamagotchi.Estado.EXPLODIR) {
            atualizarStatus();
            atualizarImagem();
            JOptionPane.showMessageDialog(this, "💥 Seu Tamagotchi explodiu de tanto comer!\nVamos começar de novo.");
            dispose(); // fecha a janela atual
            new TamagotchiGUI(); // reinicia o jogo
        }
    }

    private void atualizarStatus() {
        String estadoTexto = t.getEstado() == Tamagotchi.Estado.EXPLODIR ? "Explodido!" : t.getEstado().toString();

        status.setText("<html><div style='text-align:left;'>"
                + "<span style='color:#00FF99;'>Nome:</span> " + t.getNome() + "<br>"
                + "<span style='color:#00FF99;'>Idade:</span> " + t.getIdade() + "<br>"
                + "<span style='color:#00FF99;'>Estado:</span> " + estadoTexto + "<br>"
                + "<span style='color:#00FF99;'>Fome:</span> " + t.getFome() + "<br>"
                + "<span style='color:#00FF99;'>Felicidade:</span> " + t.getFelicidade() + "<br>"
                + "<span style='color:#00FF99;'>Energia:</span> " + t.getEnergia() + "<br>"
                + "<span style='color:#00FF99;'>Higiene:</span> " + t.getHigiene() + "<br>"
                + "<span style='color:#00FF99;'>Social:</span> " + t.getSocial() + "<br>"
                + "<span style='color:#00FF99;'>Doente:</span> " + (t.isDoente() ? "Sim" : "Não") + "</div></html>");

        atualizarImagem();
    }

    private void atualizarImagem() {
        String nomeArquivo;
        if (t.getEstado() == Tamagotchi.Estado.EXPLODIR) {
            nomeArquivo = "explosao.png";
        } else {
            nomeArquivo = switch (t.getEstado()) {
                case BEBE -> "bebe.png";
                case ADOLESCENTE -> "adolescente.png";
                case ADULTO -> "adulto.png";
                default -> "default.png";
            };
        }

        String caminhoImagem = "assets/" + nomeArquivo;
        try {
            ImageIcon icon = new ImageIcon(caminhoImagem);
            Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            imagemLabel.setIcon(new ImageIcon(img));
            imagemLabel.setText("");
        } catch (Exception e) {
            imagemLabel.setText("Imagem não encontrada.");
            imagemLabel.setIcon(null);
        }
    }
}

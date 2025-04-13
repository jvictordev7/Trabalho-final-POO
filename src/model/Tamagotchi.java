package model;

import java.util.Random;

public class Tamagotchi {

    public enum Estado {
        BEBE, ADOLESCENTE, ADULTO, EXPLODIR
    }

    private String nome;
    private int fome;
    private int felicidade;
    private int energia;
    private int higiene;
    private int social;
    private Estado estado;
    private int idade;
    private boolean doente;

    public Tamagotchi(String nome) {
        this.nome = nome;
        this.fome = 50;
        this.felicidade = 50;
        this.energia = 50;
        this.higiene = 50;
        this.social = 50;
        this.estado = Estado.BEBE;
        this.idade = 0;
        this.doente = false;
    }

    public void alimentar() {
        if (!doente && estado != Estado.EXPLODIR) {
            fome += 50;
            higiene -= 10;
            envelhecer();

            if (fome > 150) {
                estado = Estado.EXPLODIR;
            }

            limitarValores();
        }
    }

    public void brincar() {
        if (!doente && estado != Estado.EXPLODIR) {
            felicidade += 15;
            energia -= 10;
            social += 10;
            fome -= 10;
            envelhecer();
            limitarValores();
        }
    }

    public void dormir() {
        if (!doente && estado != Estado.EXPLODIR) {
            energia += 25;
            fome -= 10;
            envelhecer();
            limitarValores();
        }
    }

    public void curar() {
        if (doente && estado != Estado.EXPLODIR) {
            doente = false;
            felicidade += 10;
        }
    }

    public void limpar() {
        if (estado != Estado.EXPLODIR) {
            higiene += 20;
            if (higiene > 100) higiene = 100;
        }
    }

    public void socializar() {
        if (estado != Estado.EXPLODIR) {
            social += 15;
            if (social > 100) social = 100;
        }
    }

    public void jogarMiniJogo() {
        if (estado != Estado.EXPLODIR) {
            boolean ganhou = MiniJogo.jogar();
            if (ganhou) {
                felicidade += 20;
            } else {
                felicidade -= 10;
            }
            energia -= 10;
            fome -= 5;
            limitarValores();
        }
    }

    public void verificarEventosAleatorios() {
        Random r = new Random();
        int chance = r.nextInt(100);

        if (chance < 10) {
            energia -= 15;
        }

        if (chance >= 10 && chance < 25) {
            doente = true;
        }
    }

    public void envelhecer() {
        idade++;
        if (idade >= 5 && idade < 10) estado = Estado.ADOLESCENTE;
        else if (idade >= 10) estado = Estado.ADULTO;

        verificarEventosAleatorios();
    }

    private void limitarValores() {
        fome = Math.max(0, Math.min(fome, 150)); // agora permite até 150
        energia = Math.max(0, Math.min(energia, 100));
        felicidade = Math.max(0, Math.min(felicidade, 100));
        higiene = Math.max(0, Math.min(higiene, 100));
        social = Math.max(0, Math.min(social, 100));
    }

    // Getters
    public String getNome() { return nome; }
    public int getFome() { return fome; }
    public int getFelicidade() { return felicidade; }
    public int getEnergia() { return energia; }
    public int getHigiene() { return higiene; }
    public int getSocial() { return social; }
    public Estado getEstado() { return estado; }
    public int getIdade() { return idade; }
    public boolean isDoente() { return doente; }

    public void resetar(String novoNome) {
        this.nome = novoNome;
        this.fome = 50;
        this.felicidade = 50;
        this.energia = 50;
        this.higiene = 50;
        this.social = 50;
        this.estado = Estado.BEBE;
        this.idade = 0;
        this.doente = false;
    }
}

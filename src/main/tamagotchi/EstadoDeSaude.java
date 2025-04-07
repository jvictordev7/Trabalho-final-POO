package tamagotchi;

public class EstadoDeSaude {
    private boolean doente;

    public void verificarEstado(int fome, int energia) {
        doente = (fome < 20 || energia < 20);
    }

    public String getStatus() {
        return doente ? "Doente" : "Saudável";
    }
}

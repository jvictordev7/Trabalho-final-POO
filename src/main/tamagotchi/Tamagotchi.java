package tamagotchi;


public class Tamagotchi {
    private String nome;
    private int fome;
    private int felicidade;
    private int energia;
    private CicloDeVida ciclo;
    private EstadoDeSaude saude;

    public Tamagotchi(String nome) {
        this.nome = nome;
        this.fome = 50;
        this.felicidade = 50;
        this.energia = 50;
        this.ciclo = CicloDeVida.BEBE;
        this.saude = new EstadoDeSaude();
    }

    public void alimentar() {
        fome += 10;
        energia -= 5;
        saude.verificarEstado(fome, energia);
        atualizarCiclo();
    }

    public void brincar() {
        felicidade += 10;
        energia -= 10;
        fome -= 5;
        saude.verificarEstado(fome, energia);
        atualizarCiclo();
    }

    public void dormir() {
        energia += 20;
        fome -= 10;
        saude.verificarEstado(fome, energia);
        atualizarCiclo();
    }

    private void atualizarCiclo() {
        if (felicidade > 30 && energia > 30 && ciclo == CicloDeVida.BEBE) {
            ciclo = CicloDeVida.ADOLESCENTE;
        } else if (felicidade > 60 && energia > 60 && ciclo == CicloDeVida.ADOLESCENTE) {
            ciclo = CicloDeVida.ADULTO;
        }
    }

    public void aplicarEvento(EventoAleatorio evento) {
        evento.afetar(this);
    }

    public void modificarFome(int valor) {
        fome += valor;
    }

    public void modificarEnergia(int valor) {
        energia += valor;
    }

    public void modificarFelicidade(int valor) {
        felicidade += valor;
    }

    public String getStatus() {
        return String.format(
            "Nome: %s\nCiclo de Vida: %s\nFome: %d\nFelicidade: %d\nEnergia: %d\nSaúde: %s\n",
            nome, ciclo, fome, felicidade, energia, saude.getStatus()
        );
    }
}

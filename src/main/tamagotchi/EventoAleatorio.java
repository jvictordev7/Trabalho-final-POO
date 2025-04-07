package tamagotchi;


import java.util.Random;

public class EventoAleatorio {
    private String descricao;
    private int efeitoEnergia;

    public EventoAleatorio() {
        Random rand = new Random();
        int tipo = rand.nextInt(3);
        switch (tipo) {
            case 0:
                descricao = "Chuva forte deixou o pet com sono.";
                efeitoEnergia = -10;
                break;
            case 1:
                descricao = "Encontro com outro pet: felicidade aumentou.";
                efeitoEnergia = +5;
                break;
            case 2:
                descricao = "Pegou um resfriado.";
                efeitoEnergia = -15;
                break;
        }
    }

    public void afetar(Tamagotchi t) {
        t.modificarEnergia(efeitoEnergia);
    }

    public String getDescricao() {
        return descricao;
    }
}

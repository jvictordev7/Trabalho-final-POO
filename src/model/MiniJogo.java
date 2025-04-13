package model;

import java.util.Random;

public class MiniJogo {

    public static boolean jogar() {
        Random random = new Random();
        int numero = random.nextInt(10) + 1;

        // Simples: usuário precisa adivinhar se número é par ou ímpar
        return numero % 2 == 0; // true = acertou, ganha felicidade
    }
}

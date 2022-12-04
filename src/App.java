import java.util.Random;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Random dado = new Random();
    static int numDado1, numDado2;
    static int resultado;

    public static void main(String[] args) throws Exception {

        System.out.println(">Craps<");

        System.out
                .print("\n----!!Jogue os dados!!----\n\nDigite 1 e tecle 'Enter' para jogar ou 2 para sair do jogo: ");

        int entrada = sc.nextInt();

        if (entrada == 1) {

            numDado1 = dado.nextInt(6) + 1;
            numDado2 = dado.nextInt(6) + 1;

            resultado = numDado1 + numDado2;

            System.out.println("\nDado 1: " + numDado1);
            System.out.println("Dado 2: " + numDado2);

            resolve(resultado);

        } else {
            System.out.println("Fim do jogo!");
        }
    }

    public static void resolve(int resultado) {
        if (resultado == 7 || resultado == 11) {
            System.out.println("Resultado: " + resultado + "\n\nNATURAL. Você ganhou!");
        } else if (resultado == 2 || resultado == 3 || resultado == 12) {
            System.out.println("Resultado: " + resultado + "\n\nCRAPS. Você perdeu!");
        } else {
            // resultado = 4
            System.out.println("Resultado: " + resultado + "\n\nJogue até conseguir o resultado '" + resultado
                    + "' novamente! (Caso tire o resultado 7 você perde!)");

            int loop = 1;

            while (loop != 2) {

                System.out
                        .print("\nPressione 1 e tecle 'enter' para jogar os dados novamente ou 2 para sair do jogo: ");
                int entrada = sc.nextInt();

                if (entrada == 1) {
                    numDado1 = dado.nextInt(6) + 1;
                    numDado2 = dado.nextInt(6) + 1;

                    int resultado2 = numDado1 + numDado2;

                    if (resultado2 == 7) {
                        System.out.println("\nDado 1: " + numDado1 + "\nDado 2: " + numDado2
                                + "\nOps. Resultado '7'. Você PERDEU!");
                        loop = 2;
                    } else if (resultado2 == resultado) {
                        System.out.println("\nDado 1: " + numDado1 + "\nDado 2: " + numDado2
                                + "\nParabéns! Você tirou o mesmo número '" + resultado2 + "' e GANHOU!");
                        loop = 2;
                    } else {
                        System.out.println("\nDado 1: " + numDado1 + "\nDado 2: " + numDado2 + "\nResultado: '"
                                + resultado2 + "'. Você precisa do resultado '" + resultado + "' Jogue novamente!");
                    }
                } else {
                    System.out.println("\nFim do jogo!");
                    loop = 2;
                }
            }
        }
    }
}
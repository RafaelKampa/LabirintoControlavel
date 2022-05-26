package principal;

import java.util.Scanner;
/* Lucas Pego de Souza e Rafael Gilberto Kampa
 * 0 = Parede
 * 1 = Caminho livre
 * 2 = Saída
 * 3 = Cursor e Caminho percorrido
 */

public class Main {

//    static int[][] labirinto = {
//            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
//            { 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 0 },
//            { 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0 },
//            { 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
//            { 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0 },
//            { 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0 },
//            { 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0 },
//            { 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
//            { 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
//            { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
//            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
//    };

    static int[][] labirinto = {
            { 0, 0, 0, 0, 0},
            { 0, 1, 0, 2, 0},
            { 0, 1, 0, 1, 0},
            { 0, 1, 1, 1, 0},
            { 0, 0, 0, 0, 0}
    };

    static LinkedQueue ultimaPosicaoLinha = new LinkedQueue();
    static LinkedQueue ultimaPosicaoColuna = new LinkedQueue();

    public static void main(String[] args) {
        Movimentacao mov = new Movimentacao(1, 1);
        mov.setX(1);
        mov.setY(1);
        ultimaPosicaoLinha .add(mov.getX());
        ultimaPosicaoColuna.add(mov.getY());
        labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data] = 3;

        while (true) {

            for (int i = 0; i <= labirinto.length - 1; i++) {
                System.out.println();
                for (int j = 0; j <= labirinto.length - 1; j++) {
                    System.out.print(labirinto[i][j]);
                }
            }

            Scanner sc = new Scanner(System.in);
            System.out.printf("\n Digite L para andar para a Esquerda \n Digite U para andar para Cima \n Digite R para andar para a Direita \n Digite D para andar para Baixo\n");
            String comandoRecebido = sc.nextLine();

            // Cima
            if (comandoRecebido.equals("u")) {
                String txtDirecao = "Caminhou para Cima";
                if (labirinto[ultimaPosicaoColuna.top.data - 1][ultimaPosicaoLinha.top.data] == 0) {
                    System.out.println("Caminho impedido!");
                    continue;

                } else if (labirinto[ultimaPosicaoColuna.top.data - 1][ultimaPosicaoLinha.top.data] == 3) {
                    System.out.println("Retornou para a linha: " + (ultimaPosicaoColuna.top.data - 1) + " e coluna: " + ultimaPosicaoLinha.top.data);
                    labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data] = 1;
                    ultimaPosicaoColuna.add(ultimaPosicaoColuna.top.data - 1);
                    ultimaPosicaoLinha.add(ultimaPosicaoLinha.top.data);
                    continue;

                } else if (labirinto[ultimaPosicaoColuna.top.data - 1][ultimaPosicaoLinha.top.data] == 1) {
                    System.out.println(txtDirecao + " na linha: " + (ultimaPosicaoColuna.top.data - 1) + " e coluna: " + ultimaPosicaoLinha.top.data);
                    ultimaPosicaoColuna.add(ultimaPosicaoColuna.top.data - 1);
                    ultimaPosicaoLinha.add(ultimaPosicaoLinha.top.data);
                    labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data] = 3;
                    continue;

                } else if (labirinto[ultimaPosicaoColuna.top.data - 1][ultimaPosicaoLinha.top.data] == 2) {
                    System.out.println(txtDirecao + " e conseguiu sair na linha: " + (ultimaPosicaoColuna.top.data - 1) + " e coluna:  " + ultimaPosicaoLinha.top.data + "\n");
                    sc.close();
                    return;
                }
            }

            // Direita
            if (comandoRecebido.equals("r")) {
                String txtDirecao = "Caminhou para a Direita";
                if (labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data + 1] == 0) {
                    System.out.println("Caminho impedido!");
                    continue;

                } else if (labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data + 1] == 3) {
                    System.out.println("Retornou para a linha: " + ultimaPosicaoColuna.top.data + " e coluna: " + (ultimaPosicaoLinha.top.data + 1));
                    labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data] = 1;
                    ultimaPosicaoLinha.add(ultimaPosicaoLinha.top.data + 1);
                    ultimaPosicaoColuna.add(ultimaPosicaoColuna.top.data);
//                    x = x + 1;
                    continue;

                } else if (labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data + 1] == 1) {
                    System.out.println(txtDirecao + " na linha: " + ultimaPosicaoColuna.top.data + " e coluna: " + (ultimaPosicaoLinha.top.data + 1));
                    ultimaPosicaoLinha.add(ultimaPosicaoLinha.top.data + 1);
                    ultimaPosicaoColuna.add(ultimaPosicaoColuna.top.data);
                    labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data] = 3;
                    continue;

                } else if (labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data + 1] == 2) {
                    System.out.println(txtDirecao + " e conseguiu sair na linha: " + ultimaPosicaoColuna.top.data + " e coluna:  " + (ultimaPosicaoLinha.top.data + 1) + "\n");
                    sc.close();
                    return;
                }
            }

            // Abaixo
            if (comandoRecebido.equals("d")) {
                String txtDirecao = "Caminhou para Baixo";
                if (labirinto[ultimaPosicaoColuna.top.data + 1][ultimaPosicaoLinha.top.data] == 0) {
                    System.out.println("Caminho impedido!");
                    continue;

                }else if (labirinto[ultimaPosicaoColuna.top.data + 1][ultimaPosicaoLinha.top.data] == 3) {
                    System.out.println("Retornou para a linha: " + (ultimaPosicaoColuna.top.data + 1) + " e coluna: " + ultimaPosicaoLinha.top.data);
                    labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data] = 1;
                    ultimaPosicaoLinha.add(ultimaPosicaoLinha.top.data);
                    ultimaPosicaoColuna.add(ultimaPosicaoColuna.top.data + 1);
                    continue;

                } else if (labirinto[ultimaPosicaoColuna.top.data + 1][ultimaPosicaoLinha.top.data] == 1) {
                    System.out.println(txtDirecao + " na linha: " + (ultimaPosicaoColuna.top.data + 1) + " e coluna: " + ultimaPosicaoLinha.top.data);
                    ultimaPosicaoLinha.add(ultimaPosicaoLinha.top.data);
                    ultimaPosicaoColuna.add(ultimaPosicaoColuna.top.data + 1);
                    labirinto[ultimaPosicaoColuna.top.data ][ultimaPosicaoLinha.top.data] = 3;
                    continue;
                } else if (labirinto[ultimaPosicaoColuna.top.data + 1][ultimaPosicaoLinha.top.data] == 2) {
                    System.out.println(txtDirecao + " e conseguiu sair na linha: " + (ultimaPosicaoColuna.top.data + 1) + " e coluna:  " + ultimaPosicaoLinha.top.data + "\n");
                    sc.close();
                    return;
                }
            }

            // Esquerda
            if (comandoRecebido.equals("l")) {
                String txtDirecao = "Caminhou para a Esquerda";
                if (labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data - 1] == 0) {
                    System.out.println("Caminho impedido!");
                    continue;

                }else if (labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data - 1] == 3) {
                    System.out.println("Retornou para a linha: " + ultimaPosicaoColuna.top.data + " e coluna: " + (ultimaPosicaoLinha.top.data - 1));
                    labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data] = 1;
                    ultimaPosicaoLinha.add(ultimaPosicaoLinha.top.data - 1);
                    ultimaPosicaoColuna.add(ultimaPosicaoColuna.top.data);
                    continue;

                } else if (labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data - 1] == 1) {
                    System.out.println(txtDirecao + " na linha: " + ultimaPosicaoColuna.top.data + " e coluna: " + (ultimaPosicaoLinha.top.data - 1));
                    ultimaPosicaoLinha.add(ultimaPosicaoLinha.top.data - 1);
                    ultimaPosicaoColuna.add(ultimaPosicaoColuna.top.data);
                    labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data] = 3;
                    continue;
                } else if (labirinto[ultimaPosicaoColuna.top.data][ultimaPosicaoLinha.top.data - 1] == 2) {
                    System.out.println(txtDirecao + " e conseguiu sair na linha: " + ultimaPosicaoColuna.top.data + " e coluna:  " + (ultimaPosicaoLinha.top.data - 1) + "\n");
                    sc.close();
                    return;
                }
            }
        }
    }
}
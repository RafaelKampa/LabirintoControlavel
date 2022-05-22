package principal;

import java.util.Scanner;
/* Lucas Pego de Souza e Rafael Gilberto Kampa
 * 0 = Parede
 * 1 = Caminho livre
 * 2 = Saída
 * 3 = Cursor e Caminho percorrido
 */

public class Main {

	static int[][] labirinto = { 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 0 },
			{ 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0 }, 
			{ 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
			{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0 }, 
			{ 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0 }, 
			{ 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, 
			{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
			};

	static LinkedQueue linha = new LinkedQueue();
	static LinkedQueue coluna = new LinkedQueue();
	static LinkedQueue ultimaPosicaoLinha = new LinkedQueue();
	static LinkedQueue ultimaPosicaoColuna = new LinkedQueue();

	public static void main(String[] args) {
		Movimentacao mov = new Movimentacao(1, 1);
		ultimaPosicaoLinha .add(mov.getY());
		ultimaPosicaoColuna.add(mov.getX());
		int y = ultimaPosicaoLinha.base.data;
		int x = ultimaPosicaoColuna.base.data;
		labirinto[mov.getY()][mov.getX()] = 3;

		while (true) {
			for (int i = 0; i <= labirinto.length - 1; i++) {
				System.out.println();
				for (int j = 0; j <= labirinto.length - 1; j++) {
					System.out.print(labirinto[i][j]);
				}
			}
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.printf("\n Digite L para andar para a Esquerda \n Digite U para andar para Cima \n Digite R para andar para a Direita \n Digite D para andar para Baixo\n");
			String comandoRecebido = sc.nextLine();
			
			// Cima
			if (comandoRecebido.equals("u")) {
				String txtDirecao = "Caminhou para Cima";
				if (labirinto[y - 1][x] == 0) {
					System.out.println("Caminho impedido!");
					ultimaPosicaoLinha.remove();
					ultimaPosicaoColuna.remove();
					continue;

				} else if (labirinto[y - 1][x] == 3) {
					System.out.println("Retornou para a linha: " + (y - 1) + " e coluna: " + x);
					ultimaPosicaoLinha.remove();
					ultimaPosicaoColuna.remove();
					labirinto[y][x] = 1;
					y = y - 1;
					continue;

				} else if (labirinto[y - 1][x] == 1) {
					System.out.println(txtDirecao + " na linha: " + (y - 1) + " e coluna: " + x);
					ultimaPosicaoLinha.add(x);
					ultimaPosicaoColuna.add(y - 1);
					labirinto[y - 1][x] = 3;
					y = y-1;
					continue;
					
				} else if (labirinto[y - 1][x] == 2) {
					System.out.println(txtDirecao + " e conseguiu sair na linha: " + (y - 1) + " e coluna:  " + x + "\n");
					sc.close();
					return;
				}
			}

			// Direita
			if (comandoRecebido.equals("r")) {
				String txtDirecao = "Caminhou para a Direita";
				if (labirinto[y][x + 1] == 0) {
					System.out.println("Caminho impedido!");
					ultimaPosicaoLinha.remove();
					ultimaPosicaoColuna.remove();
					continue;
					
				} else if (labirinto[y][x + 1] == 3) {
					System.out.println("Retornou para a linha: " + y + " e coluna: " + (x + 1));
					ultimaPosicaoLinha.remove();
					ultimaPosicaoColuna.remove();
					labirinto[y][x] = 1;
					x = x + 1;
					continue;

				} else if (labirinto[y][x + 1] == 1) {
					System.out.println(txtDirecao + " na linha: " + y + " e coluna: " + (x + 1));
					ultimaPosicaoLinha.add(x + 1);
					ultimaPosicaoColuna.add(y);
					labirinto[y][x + 1] = 3;
					x = x + 1;
					continue;
				
				} else if (labirinto[y][x + 1] == 2) {
					System.out.println(txtDirecao + " e conseguiu sair na linha: " + y + " e coluna:  " + (x + 1) + "\n");
					sc.close();
					return;
				}
			}

			// Abaixo
			if (comandoRecebido.equals("d")) {
				String txtDirecao = "Caminhou para Baixo";
				if (labirinto[y + 1][x] == 0) {
					System.out.println("Caminho impedido!");
					ultimaPosicaoLinha.remove();
					ultimaPosicaoColuna.remove();
					continue;
					
				}else if (labirinto[y + 1][x] == 3) {
					System.out.println("Retornou para a linha: " + (y + 1) + " e coluna: " + x);
					ultimaPosicaoLinha.remove();
					ultimaPosicaoColuna.remove();
					labirinto[y][x] = 1;
					y = y + 1;
					continue;

				} else if (labirinto[y + 1][x] == 1) {
					System.out.println(txtDirecao + " na linha: " + (y + 1) + " e coluna: " + x);
					ultimaPosicaoLinha.add(x);
					ultimaPosicaoColuna.add(y + 1);
					labirinto[y + 1][x] = 3;
					y = y + 1;
					continue;
				} else if (labirinto[y + 1][x] == 2) {
					System.out.println(txtDirecao + " e conseguiu sair na linha: " + (y + 1) + " e coluna:  " + x + "\n");
					sc.close();
					return;
				}
			}

			// Esquerda
			if (comandoRecebido.equals("l")) {
				String txtDirecao = "Caminhou para a Esquerda";
				if (labirinto[y][x - 1] == 0) {
					System.out.println("Caminho impedido!");
					ultimaPosicaoLinha.remove();
					ultimaPosicaoColuna.remove();
					continue;

				}else if (labirinto[y][x - 1] == 3) {
					System.out.println("Retornou para a linha: " + y + " e coluna: " + (x - 1));
					ultimaPosicaoLinha.remove();
					ultimaPosicaoColuna.remove();
					labirinto[y][x] = 1;
					x = x - 1;
					continue;
					
				} else if (labirinto[y][x - 1] == 1) {
					System.out.println(txtDirecao + " na linha: " + y + " e coluna: " + (x - 1));
					ultimaPosicaoLinha.add(x - 1);
					ultimaPosicaoColuna.add(y);
					labirinto[y][x - 1] = 3;
					x = x - 1;
					continue;
				} else if (labirinto[y][x - 1] == 2) {
					System.out.println(txtDirecao + " e conseguiu sair na linha: " + y + " e coluna:  " + (x - 1) + "\n");
					sc.close();
					return;
				}
			}
		}
	}
}
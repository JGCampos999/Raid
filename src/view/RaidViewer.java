package view;

import java.io.IOException;
import javax.swing.JOptionPane;
import controller.RaidController;

public class RaidViewer {
	static long tamanhoArquivo;
	static int quantDiscos;
	static long tamanho;

	public static void main(String[] args) throws IOException {
		RaidController control = new RaidController();
		int Menu = 0;

		do {
			Menu = Integer.parseInt(JOptionPane.showInputDialog(
					"1 - Inserir Valores\n2 - Simular Raid 0 com valores inseridos e exibir resultados\n9 - Fim"));
			switch (Menu) {
			case (1):
				Val();
				break;
			case (2):
				if (tamanhoArquivo == 0) {
					JOptionPane.showMessageDialog(null, "Insira os valores primeiro");
				} else {
					control.Simular(tamanhoArquivo, tamanho, quantDiscos);
				}
				break;
			case (9):
				JOptionPane.showMessageDialog(null, "Encerrando...");
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente");
			}
		} while (Menu != 9);
	}

	public static void Val() {
		tamanhoArquivo = Integer
				.parseInt(JOptionPane.showInputDialog("Insira o tamanho do arquivo sem a medida de dados:"));
		while (tamanhoArquivo <= 0) {
			JOptionPane.showMessageDialog(null, "Valor inválido, tente novamente");
			tamanhoArquivo = Integer
					.parseInt(JOptionPane.showInputDialog("Insira o tamanho do arquivo sem a medida de dados:"));
		}
		Object[] opcoes = { "Selecione uma opção", tamanhoArquivo + " Bytes", tamanhoArquivo + " Kilobytes",
				tamanhoArquivo + " Megabytes", tamanhoArquivo + " Gigabytes" };
		Object res = JOptionPane.showInputDialog(null, "Qual das opções abaixo representa a medida de dados?",
				"Seleção de itens", JOptionPane.PLAIN_MESSAGE, null, opcoes, "");

		while (res == opcoes[0]) {
			JOptionPane.showMessageDialog(null, "Opção inválida");
			res = JOptionPane.showInputDialog(null, "Qual das opções abaixo representa a medida de dados?",
					"Seleção de itens", JOptionPane.PLAIN_MESSAGE, null, opcoes, "");
		}

		if (res == opcoes[1]) {
			tamanhoArquivo *= 8;
		} else if (res == opcoes[2]) {
			tamanhoArquivo *= (8 * Math.pow(10, 3));
		} else if (res == opcoes[3]) {
			tamanhoArquivo *= (8 * Math.pow(10, 6));
		} else if (res == opcoes[4]) {
			tamanhoArquivo *= (8 * Math.pow(10, 9));
		}

		quantDiscos = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de discos:"));
		while (quantDiscos <= 0) {
			JOptionPane.showMessageDialog(null, "Valor inválido, tente novamente");
			quantDiscos = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de discos:"));
		}
		
		tamanho = (tamanhoArquivo / 32);
		if (tamanho % quantDiscos != 0) {
			tamanho = ((int) Math.round((tamanho / quantDiscos) + 1));
		} else {
			tamanho = (tamanho / quantDiscos);
		}
	}

}

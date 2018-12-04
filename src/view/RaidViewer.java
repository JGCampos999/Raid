package view;

import javax.swing.JOptionPane;

import controller.RaidController;

public class RaidViewer {

	public static void main(String[] args) {

		long tamanhoArquivo = Integer
				.parseInt(JOptionPane.showInputDialog("Insira o tamanho do arquivo sem a medida de dados:"));
		Object[] opcoes = { "Selecione uma opção", tamanhoArquivo + " bits", tamanhoArquivo + " Bytes",
				tamanhoArquivo + " Kilobytes", tamanhoArquivo + " Megabytes", tamanhoArquivo + " Gigabytes" };
		Object res = JOptionPane.showInputDialog(null, "Qual das opções representa a medida de dados?",
				"Selecao de itens", JOptionPane.PLAIN_MESSAGE, null, opcoes, "");

		while (res == opcoes[0]) {
			if (res == opcoes[0]) {
				JOptionPane.showMessageDialog(null, "Opção inválida");
			}
			res = JOptionPane.showInputDialog(null, "Qual das opções representa a medida de dados?", "Selecao de itens",
					JOptionPane.PLAIN_MESSAGE, null, opcoes, "");
		}
		int quantDiscos = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de discos:"));
		if (res == opcoes[2]) {
			tamanhoArquivo *= 8;
		} else if (res == opcoes[3]) {
			tamanhoArquivo *= (8 * Math.pow(10, 3));
		} else if (res == opcoes[4]) {
			tamanhoArquivo *= (8 * Math.pow(10, 6));
		} else if (res == opcoes[5]) {
			tamanhoArquivo *= (8 * Math.pow(10, 9));
		}

		JOptionPane.showMessageDialog(null, "Cada disco tem blocos de 32 bits");

		RaidController control = new RaidController();
		control.Raid(tamanhoArquivo, quantDiscos);
	}

}

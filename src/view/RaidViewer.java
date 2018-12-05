package view;

import javax.swing.JOptionPane;

import controller.RaidController;

public class RaidViewer {

	public static void main(String[] args) {

		long tamanhoArquivo = Integer
				.parseInt(JOptionPane.showInputDialog("Insira o tamanho do arquivo sem a medida de dados:"));
		Object[] opcoes = { "Selecione uma op��o", tamanhoArquivo + " Bytes", tamanhoArquivo + " Kilobytes",
				tamanhoArquivo + " Megabytes", tamanhoArquivo + " Gigabytes" };
		Object res = JOptionPane.showInputDialog(null, "Qual das op��es abaixo representa a medida de dados?",
				"Sele��oo de itens", JOptionPane.PLAIN_MESSAGE, null, opcoes, "");

		while (res == opcoes[0]) {
			JOptionPane.showMessageDialog(null, "Op��o inv�lida");
			res = JOptionPane.showInputDialog(null, "Qual das op��es abaixo representa a medida de dados?",
					"Sele��o de itens", JOptionPane.PLAIN_MESSAGE, null, opcoes, "");
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

		int quantDiscos = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de discos:"));

		JOptionPane.showMessageDialog(null, "Cada disco ter� blocos de 32 bits");

		RaidController control = new RaidController();
		control.Raid(tamanhoArquivo, quantDiscos);
	}

}

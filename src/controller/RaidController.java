package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class RaidController extends JPanel {
	static long tamanhoArquivo;
	static int quantDiscos;
	static long tamanho;
	static boolean executou = false;
	JProgressBar barra;

	public RaidController() {
		barra = new JProgressBar();
		barra.setMinimum(0);
		add(barra);
	}

	public void Val() {
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
		if (tamanhoArquivo % 32 != 0) {
			tamanho = ((int) Math.round((tamanho / 32) + 1));
		} else {
			tamanho = (tamanhoArquivo / 32);
		}
		if (tamanho % quantDiscos != 0) {
			tamanho = ((int) Math.round((tamanho / quantDiscos) + 1));
		} else {
			tamanho = (tamanho / quantDiscos);
		}
		executou = true;
		barra.setMaximum((int) tamanho);
		JOptionPane.showMessageDialog(null, "Valores carregados com sucesso.");
	}

	public void Simular() {
		if (executou) {
			final RaidController prct = new RaidController();
			JFrame frame = new JFrame("Progresso");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(prct);
			frame.pack();
			frame.setVisible(true);
			long vetDisc[] = new long[quantDiscos];
			JOptionPane.showMessageDialog(null, "Convertendo para bits, seu tamanho é de: " + tamanhoArquivo
					+ " bits.\r\nSendo assim, cada disco terá: " + (tamanhoArquivo / quantDiscos)
					+ " bits.\r\nAlém disso, cada bloco de cada disco terá no máximo 32 bits.\r\n" + "Dando o total de "
					+ tamanho + " bloco(s).");
			System.out.print("\t\t");
			for (int i = 0; i < quantDiscos; i++) {
				System.out.print("Disk" + (i + 1) + "\t");
				vetDisc[i] = (tamanhoArquivo / quantDiscos);
			}
			System.out.print("\r\n");

			for (int i = 1; i <= tamanho; i++) {
				final int porcentagem = ((int) Math.round((i * 100) / tamanho));
				try {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							prct.updateBar(porcentagem);
						}
					});
					java.lang.Thread.sleep(100);
				} catch (InterruptedException e) {
					;
				}
				if (i >= 100) {
					System.out.print("Bloco" + i + "\t");
				} else {
					System.out.print("Bloco" + i + "\t\t");
				}

				for (int j = 0; j < quantDiscos; j++) {
					if (vetDisc[j] < 32) {
						System.out.print(vetDisc[j] + "\t");
						vetDisc[j] = 0;
					} else {
						vetDisc[j] -= 32;
						System.out.print("32\t");
					}
				}
				System.out.print("\r\n");
			}
			JOptionPane.showMessageDialog(null, "Simulação Concluída");
		} else {
			JOptionPane.showMessageDialog(null, "É necessário inserir valores ao menos uma vez.");
		}
	}

	public void updateBar(int newValue) {
		barra.setValue(newValue);
	}
}

package controller;

import javax.swing.JOptionPane;

public class RaidController {

	public void Simular(long tamanhoArquivo, long tamanho, int quantDiscos) {
		long vetDisc[] = new long[quantDiscos];
		System.out.print(
				"Convertendo para bits, seu tamanho é de: " + tamanhoArquivo + " bits\r\nSendo assim, cada disco terá: "
						+ (tamanhoArquivo / quantDiscos) + " bits\r\nE cada bloco de cada disco terá 32 bits\r\n"
						+ "Dando o total de " + tamanho + " blocos\r\n\t\t");
		for (int i = 0; i < quantDiscos; i++) {
			System.out.print("Disk" + (i + 1) + "\t");
			vetDisc[i] = (tamanhoArquivo / quantDiscos);
		}
		System.out.print("\r\n");

		for (int i = 0; i < tamanho; i++) {
			if ((i + 1) >= 100) {
				System.out.print("Bloco" + (i + 1) + "\t");
			} else {
				System.out.print("Bloco" + (i + 1) + "\t\t");
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
	}
}

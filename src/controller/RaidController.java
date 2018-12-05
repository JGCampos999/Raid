package controller;

public class RaidController {

	public void Raid(long tamanhoArquivo, int quantDiscos) {
		long vetDisc[] = new long[quantDiscos];
		Object[] discos = new Object[quantDiscos];
		int linha = 1;
		int contador = 100;
		String espaco = "\t";

		System.out.print("Convertendo para bits, seu tamanho é de: " + tamanhoArquivo
				+ "bits\nSendo assim, cada disco terá: " + (tamanhoArquivo / quantDiscos) + " bits\n\n");
		System.out.print("\t\t");

		for (int i = 0; i < quantDiscos; i++) {
			vetDisc[i] = (tamanhoArquivo / quantDiscos);
			discos[i] = ("Disk" + (i + 1) + "\t");
			System.out.print(discos[i]);
		}

		System.out.println();

		while (vetDisc[0] != 0) {
			int i = 0;
			String espacos = espaco;

			if (linha == contador) {
				int mod = contador;
				while (mod != 1) {
					if (mod % 10 == 0) {
						espacos += espaco;
						mod = (mod / 10);
					}
				}

				for (int j = 0; j < quantDiscos; j++) {
					if (j == 0) {
						discos[j] = (espacos + "Disk" + (j + 1) + "\t");
					} else {
						discos[j] = ("Disk" + (j + 1) + "\t");
					}
					System.out.print(discos[j]);
				}
				contador *= 10;
				System.out.println();
			}
			System.out.print("Bloco" + linha + "\t\t");

			while (i < quantDiscos) {
				if (vetDisc[i] < 32) {
					tamanhoArquivo -= 32;
					discos[i] = vetDisc[i] + "\t";
					vetDisc[i] = 0;
				} else {
					vetDisc[i] -= 32;
					discos[i] = "32\t";
				}
				System.out.print(discos[i]);
				i++;
			}
			System.out.println();
			linha++;
		}
	}
}

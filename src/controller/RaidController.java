package controller;

public class RaidController {
	
	public void Raid(long tamanhoArquivo, int quantDiscos) {
		Object[] discos = new Object[quantDiscos];
		int linha = 1;
		System.out.print("\t\t");
		for (int i = 0; i < quantDiscos; i++) {
			discos[i] = "Disk" + (i + 1) + "\t";
			System.out.print(discos[i]);
		}
		System.out.println();
		
		while (tamanhoArquivo != 0) {
			int i = 0;
			System.out.print("Bloco" +linha +"\t\t");
			while (i < quantDiscos) {
				if (tamanhoArquivo < 32) {
					discos[i] = tamanhoArquivo + "\t";
					tamanhoArquivo = 0;
				} else {
					tamanhoArquivo -= 32;
					discos[i] = "32\t";
				}
				System.out.print(discos[i]);
				i++;
			}
			linha++;
			System.out.println();

		}
	}
}

package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class RaidController {
	static int tamanhoArquivo;
	static int quantDiscos;
	static int tamanho;

	public void Simular() throws IOException {
		tamanhoArquivo = Integer
				.parseInt(JOptionPane.showInputDialog("Insira o tamanho do arquivo sem a medida de dados:"));
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

		long vetDisc[] = new long[quantDiscos];
		int contador = 100;
		String espaco = "\t";
		tamanho = (tamanhoArquivo / 32);
		if (tamanho % quantDiscos != 0) {
			tamanho = ((int) Math.round((tamanho / quantDiscos) + 1));
		} else {
			tamanho = (tamanho / quantDiscos);
		}
		StringBuffer valoresDisco = new StringBuffer();

		valoresDisco.append("Convertendo para bits, seu tamanho é de: " + tamanhoArquivo
				+ " bits\nSendo assim, cada disco terá: " + (tamanhoArquivo / quantDiscos) + " bits\n\n");
		valoresDisco.append("\t\t");

		for (int i = 0; i < quantDiscos; i++) {
			vetDisc[i] = (tamanhoArquivo / quantDiscos);
			valoresDisco.append("Disk" + (i + 1) + "\t");
		}
		valoresDisco.append("\r\n");

		for (int i = 0; i < tamanho; i++) {
			String espacos = espaco;
			if ((i + 1) == contador) {
				int mod = contador;
				while (mod != 1) {
					if (mod % 10 == 0) {
						espacos += espaco;
						mod = (mod / 10);
					}
				}

				for (int j = 0; j < quantDiscos; j++) {
					if (j == 0) {
						valoresDisco.append(espacos + "Disk" + (j + 1) + "\t");
					} else {
						valoresDisco.append("Disk" + (j + 1) + "\t");
					}
				}
				contador *= 10;
				valoresDisco.append("\r\n");
			}

			valoresDisco.append("Bloco" + (i + 1) + "\t\t");
			for (int j = 0; j < quantDiscos; j++) {
				if (vetDisc[j] < 32) {
					valoresDisco.append(vetDisc[j] + "\t");
					vetDisc[j] = 0;
				} else {
					vetDisc[j] -= 32;
					valoresDisco.append("32\t");
				}
			}
			valoresDisco.append("\r\n");
		}
		String dir = "src/";
		String arq = "Raid 0 Simulador.txt";
		File diretorio = new File(dir);
		if (diretorio.exists() && diretorio.isDirectory()) {
			File arquivo = new File(dir, arq);
			boolean existe = false;
			if (arquivo.exists()) {
				arquivo.delete();
			}
			FileWriter writer = new FileWriter(arquivo, existe);
			PrintWriter printer = new PrintWriter(writer);
			printer.write(valoresDisco.toString());
			printer.flush();
			printer.close();
			writer.close();
		}
	}

	public void Exibe() throws IOException {
		String dir = "src/";
		String arq = "Raid 0 Simulador.txt";

		File diretorio = new File(dir);
		if (diretorio.exists() && diretorio.isDirectory()) {
			File arquivo = new File(dir, arq);
			if (arquivo.exists() && arquivo.isFile()) {
				FileInputStream fluxo = new FileInputStream(arquivo);
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} else {
				throw new IOException("Arquivo não existe");
			}
		}
	}
}

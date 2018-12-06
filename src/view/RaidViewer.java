package view;

import java.io.IOException;
import javax.swing.JOptionPane;
import controller.RaidController;

public class RaidViewer {

	public static void main(String[] args) throws IOException {
		RaidController control = new RaidController();
		int Menu = 0;
		do {
			Menu = Integer.parseInt(JOptionPane.showInputDialog(
					"1 - Simular Raid 0 e gravar Arquivo\n2 - Ler arquivo e exibir resultados\n9 - Fim"));
			switch (Menu) {
			case (1):
				control.Simular();
				break;
			case (2):
				control.Exibe();
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

}

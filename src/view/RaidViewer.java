package view;

import javax.swing.JOptionPane;
import controller.RaidController;

public class RaidViewer {

	public static void main(String[] args) {
		RaidController control = new RaidController();
		int Menu = 0;

		do {
			Menu = Integer.parseInt(JOptionPane.showInputDialog(
					"1 - Inserir Valores\n2 - Simular Raid 0 com valores inseridos e exibir resultados\n9 - Fim"));
			switch (Menu) {
			case (1):
				control.Val();
				break;
			case (2):
				control.Simular();
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

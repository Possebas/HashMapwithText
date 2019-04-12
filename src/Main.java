import javax.swing.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		FileRead fileProcess = new FileRead();
		Object[] opcoes = { "casoMC4a.txt", "casoMC4b.txt", "casoMC8a.txt","casoMC8b.txt",
							"casoMC10a.txt", "casoMC10b.txt","casoMC12a.txt", "casoMC12b.txt",
							"casoMC14a.txt", "casoMC14b.txt"};
		String resposta = "";
		do {
			resposta = (String)  JOptionPane.showInputDialog(null,
					"Qual caso de teste deseja utilizar ?",
					"Pergunta",
					JOptionPane.PLAIN_MESSAGE,
					null,
			opcoes,
			"não");
		} while (resposta.equals("") || resposta.equals("não"));
		switch(resposta){
			case ("casoMC4a.txt"): fileProcess.process("casoMC4a.txt");break;
			case ("casoMC4b.txt"): fileProcess.process("casoMC4b.txt");break;
			case ("casoMC8a.txt"): fileProcess.process("casoMC8a.txt");break;
			case ("casoMC8b.txt"): fileProcess.process("casoMC8b.txt");break;
			case ("casoMC10a.txt"): fileProcess.process("casoMC10a.txt");break;
			case ("casoMC10b.txt"): fileProcess.process("casoMC10b.txt");break;
			case ("casoMC12a.txt"): fileProcess.process("casoMC12a.txt");break;
			case ("casoMC12b.txt"): fileProcess.process("casoMC12b.txt");break;
			case ("casoMC14a.txt"): fileProcess.process("casoMC14a.txt");break;
			case ("casoMC14b.txt"): fileProcess.process("casoMC14b.txt");break;
			default: System.out.println("Nome de arquivo inválido");
		}
	}
}

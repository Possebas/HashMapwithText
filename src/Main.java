import javax.swing.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		FileRead fileProcessor = new FileRead(); //objeto da classe leitora de arquivo

		//vetor com os casos de testes possíveis
		Object[] opcoes = { "casoMC4a.txt", "casoMC4b.txt", "casoMC8a.txt","casoMC8b.txt",
							"casoMC10a.txt", "casoMC10b.txt","casoMC12a.txt", "casoMC12b.txt",
							"casoMC14a.txt", "casoMC14b.txt"};
		String resposta;

		//uma interface bem simples para o usuário escolher qual caso de teste deseja selecionar
		//tanto as opções no vetor como a interface, não permitem o usuário "burlar" a escolha.
		do {
			resposta = (String)  JOptionPane.showInputDialog(null,
					"Qual caso de teste deseja utilizar ?",
					"Pergunta",
					JOptionPane.PLAIN_MESSAGE,
					null,
			opcoes,
			"não");
		} while (resposta.equals("") || resposta.equals("não"));

		//um switch simples para selecionar e já executar o teste escolhido
		switch(resposta){
			case ("casoMC4a.txt"): fileProcessor.process("casoMC4a.txt");break;
			case ("casoMC4b.txt"): fileProcessor.process("casoMC4b.txt");break;
			case ("casoMC8a.txt"): fileProcessor.process("casoMC8a.txt");break;
			case ("casoMC8b.txt"): fileProcessor.process("casoMC8b.txt");break;
			case ("casoMC10a.txt"): fileProcessor.process("casoMC10a.txt");break;
			case ("casoMC10b.txt"): fileProcessor.process("casoMC10b.txt");break;
			case ("casoMC12a.txt"): fileProcessor.process("casoMC12a.txt");break;
			case ("casoMC12b.txt"): fileProcessor.process("casoMC12b.txt");break;
			case ("casoMC14a.txt"): fileProcessor.process("casoMC14a.txt");break;
			case ("casoMC14b.txt"): fileProcessor.process("casoMC14b.txt");break;
			default: System.out.println("Nome de arquivo inválido");
		}
	}
}

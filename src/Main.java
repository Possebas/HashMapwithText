import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		FileRead fileProcess = new FileRead();

		// write your code here
		Scanner keyB = new Scanner(System.in);
		System.out.println("Digite qual caso de teste deseja utilizar...");
		String caseTest = keyB.nextLine();
		switch(caseTest){
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

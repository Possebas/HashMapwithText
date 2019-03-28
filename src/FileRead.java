import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	public void process(String cTeste) {
		File arq = new File("C:\\Users\\1513 IRON\\.git\\T1-TriboBarbara\\casos", cTeste);
		System.out.println("\nCaso de teste escolhido foi: "+cTeste+"\n");
		try {
			//Indicamos o arquivo que será lido
			FileReader fileReader = new FileReader(arq);
			GeneralTree tree = new GeneralTree();

			//Criamos o objeto bufferReader que nos
			// oferece o método de leitura readLine()
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String first = bufferedReader.readLine();
			int valueF = Integer.valueOf(first);
			//System.out.println("Primeiro valor: "+ valueF);
			//String que irá receber cada linha do arquivo
			String line = "";
			//Fazemos um loop linha a linha no arquivo,
			// enquanto ele seja diferente de null.
			//O método readLine() devolve a linha na
			// posicao do loop para a variavel linha.
			long tempoInicio = System.currentTimeMillis();
			while ( ( line = bufferedReader.readLine() ) != null) {
				//Aqui imprimimos a linha
				//System.out.println(line);
				String[] array = line.split(" ");
				int terrace = Integer.valueOf(array[2]);
				tree.add(array[0], array[1], terrace);

			}
			tree.setTerraceFather(valueF);
//			System.out.println("Filhosssssssss: "+tree.list);

			long tempoFinal = System.currentTimeMillis();
			long tempoTotal = tempoFinal-tempoInicio;
			System.out.println("\nTempo total de execução: " +(tempoTotal / 1000)+ " segundos");
//			System.out.println("RAÍZ: "+ tree.getRoot());
//			System.out.println("Quantidade de terras do pai principal(raíz): "+tree.getTerraceFather());
//			System.out.println("Pai de Docrenlax é: "+tree.getFather("Rimvingnipanclox"));
			//liberamos o fluxo dos objetos ou fechamos o arquivo
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

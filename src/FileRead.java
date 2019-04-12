import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class FileRead {
	public void process(String cTeste) {

		long initTime = System.currentTimeMillis();

		HashMap<String, Barbarian> warriors = new HashMap<>();
		TribeHashMap nodes = new TribeHashMap();
		HashSet<String> fathers = new HashSet<>(); //guarda o nome de todos os barbaros que possuem filhos
		HashSet<String> childs = new HashSet<>(); //guarda o nome de todos os barbaros que possuem dad

		String name,dad;
		double valueF = 0;
		//C:\Users\1513 IRON\.git\T1-TriboBarbara\casos
		File arq = new File("C:\\Users\\Gustavo\\Desktop\\Algoritmos e Estrutura de Dados II\\T1-TriboBarbara\\casos", cTeste);
	
		System.out.println("\nCaso de teste escolhido foi: "+cTeste+"\n");

		try {
			//Indicamos o arquivo que será lido
			FileReader fileReader = new FileReader(arq);

			//Criamos o objeto bufferReader que nos
			// oferece o método de leitura readLine()
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String first = bufferedReader.readLine();
			//String que irá receber cada linha do arquivo
			String line = "";
			//Fazemos um loop linha a linha no arquivo,
			// enquanto ele seja diferente de null.
			//O método readLine() devolve a linha na
			// posicao do loop para a variavel linha.
			while (bufferedReader.ready()) {
				//Aqui imprimimos a linha
				valueF = Double.valueOf(first);
				line = bufferedReader.readLine();
				String[] array = line.split(" ");
				double terrace = Double.valueOf(array[2]);

				dad = array[0];
				name = array[1];
				fathers.add(dad);
				childs.add(name);

				warriors.put(name, new Barbarian(dad, name, terrace));
				nodes.put(dad, name);
			}
			//liberamos o fluxo dos objetos ou fechamos o arquivo
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String root = "";
		for(String p : fathers)
		{
			if(!childs.contains(p))
				root = p;
		}
		warriors.put(root, new Barbarian(root, null, valueF));
		ArrayList<Barbarian> leafs = new ArrayList<>();
		leafs = nodes.calcula(root, warriors, leafs);

		Barbarian bigger = new Barbarian("","",0);
		for(Barbarian b : leafs)
		{
			if(b.getTerrace()> bigger.getTerrace())
				bigger = b;
		}

		System.out.println("Nome do guerreiro da última geração com mais terras: " + bigger.getName() + "\nQuantidade de terras: " + (int)bigger.getTerrace());

		long endTime = System.currentTimeMillis();
		long totalTime = endTime-initTime;

		System.out.println("\nTempo total de execução: "+totalTime+" milissegundos");

	}
}

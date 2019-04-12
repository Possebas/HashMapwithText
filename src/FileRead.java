import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class FileRead {
	public void process(String cTeste) {
		long tempoInicio = System.currentTimeMillis();

		HashMap<String, Barbarian> warriors = new HashMap<>();
		TribeHashMap nodes = new TribeHashMap();
		HashSet<String> fathers = new HashSet<>(); //guarda o nome de todos os guerreiros que tem filhos
		HashSet<String> childs = new HashSet<>(); //guarda o nome de todos os guerreiros que possuem um pai

		String nome;
		String pai;
		int valueF = 0;

		File arq = new File("C:\\Users\\1513 IRON\\.git\\T1-TriboBarbara\\casos", cTeste);
		System.out.println("\nCaso de teste escolhido foi: "+cTeste+"\n");

		GeneralTree tree = new GeneralTree();
		try {
			//Indicamos o arquivo que será lido
			FileReader fileReader = new FileReader(arq);

			//Criamos o objeto bufferReader que nos
			// oferece o método de leitura readLine()
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String first = bufferedReader.readLine();
			String line =  "";
			//Fazemos um loop linha a linha no arquivo,
			// enquanto ele seja diferente de null.
			//O método readLine() devolve a linha na
			// posicao do loop para a variavel line.
			while (bufferedReader.ready()) {
				//Aqui imprimimos a linha
				//System.out.println(line);


				valueF = Integer.valueOf(first);
				line = bufferedReader.readLine();
				String[] array = line.split(" ");
				int terrace = Integer.valueOf(array[2]);

				pai = array[0];
				nome = array[1];
				fathers.add(pai);
				childs.add(nome);

				warriors.put(nome, new Barbarian(pai, nome, terrace));
				nodes.put(pai, nome);
			}

			//liberamos o fluxo dos objetos ou fechamos o arquivo
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Verifica a existência do primeiro guerreiro da tribo
		String raiz = "";
		for(String p : fathers)
		{
			if(!childs.contains(p))
				raiz = p;
		}
		warriors.put(raiz, new Barbarian(raiz, null, valueF));
		ArrayList<Barbarian> folhas = new ArrayList<>();
		folhas = nodes.calculate(raiz, warriors, folhas);

		Barbarian maior = new Barbarian("","",0);
		for(Barbarian b : folhas)
		{
			if(b.getTerrace()> maior.getTerrace())
				maior = b;
		}


		System.out.println("Nome do guerreiro: " + maior.getName() + "\nQuantidade de terras: " + maior.getTerrace());

		long tempoFinal = System.currentTimeMillis();
		long tempoTotal = tempoFinal-tempoInicio;
		System.out.println("\nTempo total de execução: " +tempoTotal+ " milisegundos");
	}
}

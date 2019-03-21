import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	public void process(String cTeste) {
		File arq = new File("C:\\Users\\Gustavo\\Desktop\\Algoritmos e Estrutura de Dados II\\T1-TriboBarbara\\casos", cTeste);
		System.out.println("\nConteúdo do arquivo texto:\n");
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
			while ( ( line = bufferedReader.readLine() ) != null) {
				//Aqui imprimimos a linha
				System.out.println(line);
//				String[] array = line.split(" ");
//				int terrace = Integer.valueOf(array[2]);
//				tree.add(array[0], array[1], terrace);
				//System.out.println(tree.getRoot());
				//populateTree(line);
				//System.out.println(array[0]);
				//System.out.println(array[1]);
				//System.out.println(array[2]);

			}
			//System.out.println(tree.positionsPre());
			//System.out.println(tree.getRoot());
			//liberamos o fluxo dos objetos ou fechamos o arquivo
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	private static void populateTree(String line){
//		String[] array = line.split(" ");
//		int terrace = Integer.valueOf(array[2]);
//		GeneralTree tree = new GeneralTree();
//		tree.add(array[0], array[1], terrace);
//		System.out.println(tree.getRoot());
//		//System.out.println(tree.positionsPre());
////		System.out.println(array[0]);
////		System.out.println(array[1]);
////		System.out.println(array[2]);
//	}
}

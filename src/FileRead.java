import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	public static void process(String cTeste) {
		File arq = new File("C:\\Users\\Gustavo\\Desktop\\Algoritmos e Estrutura de Dados II\\T1-TriboBarbara\\casos", cTeste);
		System.out.println("\nConteúdo do arquivo texto:\n");
		try {
			//Indicamos o arquivo que será lido
			FileReader fileReader = new FileReader(arq);

			//Criamos o objeto bufferReader que nos
			// oferece o método de leitura readLine()
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			//String que irá receber cada linha do arquivo
			String linha = "";

			//Fazemos um loop linha a linha no arquivo,
			// enquanto ele seja diferente de null.
			//O método readLine() devolve a linha na
			// posicao do loop para a variavel linha.
			while ( ( linha = bufferedReader.readLine() ) != null) {
				//Aqui imprimimos a linha
				System.out.println(linha);
			}
			//liberamos o fluxo dos objetos ou fechamos o arquivo
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

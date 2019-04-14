import java.util.ArrayList;
import java.util.HashMap;

public class TribeHashMap
{
	private HashMap<String, ArrayList<String>> data;

	public TribeHashMap() {
		data = new HashMap<>();
	}

	public void put (String key, String value) {
		if(data.containsKey(key)) {
			ArrayList<String> aux = data.get(key);
			aux.add(value);
			data.remove(key);
			data.put(key, aux);
		} else {
			ArrayList<String> values2 = new ArrayList<>();
			values2.add(value);
			data.put(key, values2);
		}
	}

	public ArrayList<String> get (String key) {
		return data.get(key);
	}

    /**
     * Método calcula responsável por verificar a quantidade de terra que cada guerreiro da tribo irá ter ao longo da vida.
     * Para isso, são passados três parâmetros: uma String contendo o pai, um HashMap contendo todos os bárbaros e um ArrayList
     * que irá conter só os bárbaros que não possuem nenhum filho.
     */
	public ArrayList<Barbarian> calculate(String father, HashMap<String, Barbarian> warriors, ArrayList<Barbarian> leaves) {
		Barbarian biggestChild = new Barbarian("","",0);
		ArrayList<String> children = data.get(father);
		if(children == null) {
			leaves.add(warriors.get(father));
		}
		else {
		    // Criação de um foreach para percorrer o array criado com os filhos
			for(String s : children) {
				double terraceChild = warriors.get(s).getTerrace();
				double terraceFather = warriors.get(father).getTerrace();
				//O Bárbaro criado irá receber uma quantidade de terra correspondente ao que já tinha, mais a quantidade de terra que seu pai
                // tinha, que foi dividida igualmente pela quantidade de filhos que ele tem.
				Barbarian aux = new Barbarian(s, father, terraceChild + (terraceFather/children.size()));
                //Se o bárbaro auxiliar tiver uma quantidade maior, o bárbaro maior irá receber esse prórpio auxiliar
				if(aux.getTerrace() > biggestChild.getTerrace())
					biggestChild = aux;
				warriors.remove(s);
				warriors.put(s, aux);
				calculate(s, warriors, leaves);
			}
		}

		return leaves;
	}

}

import java.util.ArrayList;
import java.util.HashMap;

public class TribeHashMap
{
    private HashMap<String, ArrayList<String>> content;

    public TribeHashMap() {
        content = new HashMap<>();
    }

    public ArrayList<String> get (String chave) {
        return content.get(chave);
    }

    public void put (String key, String value) {
        if(content.containsKey(key)) {
            ArrayList<String> aux = content.get(key);
            aux.add(value);
            content.remove(key);
            content.put(key, aux);
        } else {
            ArrayList<String> values2 = new ArrayList<>();
            values2.add(value);
            content.put(key, values2);
        }
    }

    public ArrayList<Barbarian> calculate(String father, HashMap<String, Barbarian> warriors, ArrayList<Barbarian> leaves) {
        Barbarian maiorFilho = new Barbarian("","",0);
        ArrayList<String> sons = content.get(father);
        if(sons == null)
        {
            leaves.add(warriors.get(father));
        }
        else {
            for(String s : sons) {
                double terrasFilho = warriors.get(s).getTerrace();
                double terrasPai = warriors.get(father).getTerrace();
                Barbarian aux = new Barbarian(s, father, terrasFilho + (terrasPai/sons.size()));
                if(aux.getTerrace() > maiorFilho.getTerrace())
                    maiorFilho = aux;
                warriors.remove(s);
                warriors.put(s, aux);
                calculate(s, warriors, leaves);
            }
        }

        return leaves;
    }
}

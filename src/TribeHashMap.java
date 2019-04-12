import java.util.ArrayList;

public class TribeHashMap
{
	private java.util.HashMap<String, ArrayList<String>> dados;

	public TribeHashMap()
	{
		dados = new java.util.HashMap<>();
	}

	public void put (String chave, String valor)
	{
		if(dados.containsKey(chave))
		{
			ArrayList<String> aux = dados.get(chave);
			aux.add(valor);
			dados.remove(chave);
			//System.out.println("pai : " + chave + "  filhos: " + aux + "\n");
			dados.put(chave, aux);
		}
		else
		{
			ArrayList<String> valores = new ArrayList<>();
			valores.add(valor);
			dados.put(chave, valores);
		}
	}

	public ArrayList<String> get (String chave)
	{
		return dados.get(chave);
	}

	public ArrayList<Barbarian> calcula(String father, java.util.HashMap<String, Barbarian> barbaros, ArrayList<Barbarian> folhas)
	{
		Barbarian maior = new Barbarian("","",0);
		ArrayList<String> filhos = dados.get(father);
		if(filhos == null)
		{
			folhas.add(barbaros.get(father));
		}
		else
		{
			for(String s : filhos)
			{
				double terrasFilho = barbaros.get(s).getTerrace();
				double terrasPai = barbaros.get(father).getTerrace();
				Barbarian aux = new Barbarian(s, father, terrasFilho + (terrasPai/filhos.size()));
				if(aux.getTerrace() > maior.getTerrace())
					maior = aux;
				barbaros.remove(s);
				barbaros.put(s, aux);
				calcula(s, barbaros, folhas);
			}
		}

		return folhas;
	}

}

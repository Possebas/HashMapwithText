public class Barbarian {
    private String name;
    private String father;
    double terrace;

    public Barbarian(String name, String father, double terrace)
    {
        this.name = name;
        this.father = father;
        this.terrace = terrace;
    }

    public String getName(){
        return name;
    }
    public String getFather(){
        return father;
    }
    public double getTerrace(){
        return terrace;
    }

}

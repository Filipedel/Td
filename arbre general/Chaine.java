public class Chaine implements Sommable<Chaine>{

    private String chaine;
    public Chaine(String chaine){
        this.chaine=chaine;
    }
    public String getChaine(){
        return chaine;
    }
    @Override
    public Chaine sommer(Chaine val) {
        return new Chaine(this.chaine + val.getChaine());
    }

    @Override
    public String toString() {
        return "Chaine{" +
                "chaine='" + chaine + '\'' +
                '}';
    }

    public static void main(String[] args){
        Chaine a = new Chaine("D");
        Chaine b = new Chaine("N");
        System.out.println(a.sommer(b).toString());
    }
}

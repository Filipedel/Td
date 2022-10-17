public  class Entier implements Sommable<Entier>{
    private Integer entier;
    public Entier (Integer entier){
        this.entier=entier;
    }
    public Integer getVal() {
        return entier;
    }
    @Override
    public Entier sommer(Entier val) {
        return new Entier(this.entier + val.getVal());
    }


    @Override
    public String toString() {
        return "Entier{" +
                "entier=" + entier +
                '}';
    }

    public static void main(String[] args){
        Entier a = new Entier(3);
        Entier b = new Entier(5);
        System.out.println(a.sommer(b).toString());
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class main2 {
    public static void main (String[ ] args){
        Predicate<Paire<Integer,Double>> troppetit = p -> p.fst<100;
        Predicate<Paire<Integer,Double>> tropgrand = p -> p.fst>200;
        Predicate<Paire<Integer,Double>> troplourd = p -> p.snd>150.0;
        Predicate<Paire<Integer,Double>> tailleincorrect = p -> troppetit.test(p) || tropgrand.test(p);
        Predicate<Paire<Integer,Double>> taillecorrecte = Predicate.not(tailleincorrect);
        Predicate<Paire<Integer, Double>> poidsCorrect = Predicate.not(troplourd);
        Predicate<Paire<Integer, Double>> accesAutorise = p -> taillecorrecte.test(p) && poidsCorrect.test(p);

        //Question 1

        //Création paires
        Paire<Integer,Double> paire = new Paire<>(99,201.3);
        Paire<Integer,Double> pp = new Paire<>(101,201.4);
        Paire<Integer,Double> pp1 = new Paire<>(99,149.0);
        Paire<Integer,Double> pp2 = new Paire<>(102,149.0);
        Paire<Integer,Double> pp3 = new Paire<>(500,21.3);
        Paire<Integer,Double> yes = new Paire(150,100.0);
        Paire<Integer,Double> no = new Paire(250,100.0);
        //Mettre les paires dans une listes
        List<Paire<Integer,Double>> paires= new ArrayList<>(7);
        paires.add(paire);
        paires.add(pp);
        paires.add(pp1);
        paires.add(pp2);
        paires.add(yes);
        paires.add(no);
        paires.add(pp3);



        //mettre les prédicats dans une liste
        List<Predicate<Paire<Integer,Double>>> predicat = new ArrayList<>(7);
        predicat.add(troppetit);
        predicat.add(tropgrand);
        predicat.add(troplourd);
        predicat.add(taillecorrecte);
        predicat.add(tailleincorrect);
        predicat.add(poidsCorrect);
        predicat.add(accesAutorise);

        //display
        /*
        for (int i = 0; i<paires.size();i++) {
            System.out.println("Client "+(i+1));
            for(int j= 0; j<predicat.size();j++) {
                System.out.println(predicat.get(j).test(paires.get(i)));
            }
        }
*/
        //QUESTION 2
        filtre <Paire<Integer,Double>> main = new filtre<>();
        System.out.println(main.filtragePredicatif(predicat, paires));

    }
}

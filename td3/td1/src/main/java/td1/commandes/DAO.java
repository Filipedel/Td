package td1.commandes;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.Map;
import java.util.HashMap;

import static td1.commandes.Categorie.*;
import td1.paires.Paire;

public class DAO {
    private List<Commande> commandes;

    private DAO(Commande c1, Commande ...cs) {
        commandes = new ArrayList<>();
        commandes.add(c1);
        commandes.addAll(List.of(cs));
    }

    public static DAO instance = null;

    public static final DAO instance() {
        if (instance == null) {
            Produit camembert = new Produit("Camembert", 4.0, NORMAL);
            Produit yaourts = new Produit("Yaourts", 2.5, INTERMEDIAIRE);
            Produit masques = new Produit("Masques", 25.0, REDUIT);
            Produit gel = new Produit("Gel", 5.0, REDUIT);
            Produit tournevis = new Produit("Tournevis", 4.5, NORMAL);
            //
            Commande c1 = new Commande()
                .ajouter(camembert, 1)
                .ajouter(yaourts, 6);
            Commande c2 = new Commande()
                .ajouter(masques, 2)
                .ajouter(gel, 10)
                .ajouter(camembert, 2)
                .ajouter(masques, 3);
            //
            instance = new DAO(c1,c2);
        }
        return instance;
    }

    /**
     * liste de toutes les commandes
     */
    public List<Commande> commandes() { return commandes; }

    /**
     * ensemble des différents produits commandés
     */
    public Set<Produit> produits() {
       return commandes.stream()
                .flatMap(c -> c.lignes().stream())
                .map(Paire::fst)
                .collect(Collectors.toSet());
          /*
        Set<Produit> sp = new HashSet<Produit>() ;
        for(int i = 0 ; i < commandes.size() ; i++) {
            commandes.get(i).lignes().forEach(cl -> {
                sp.add(cl) ;
            });

        };
        return sp ;
*/

    }

    /**
     * liste des commandes vérifiant un prédicat
     */
    public List<Commande> selectionCommande(Predicate<Commande> p) {
        return commandes.stream()
            .filter(p)
            .collect(Collectors.toList());/*
        List <Commande> commandeList = new Arraylist <>();
        for(Commande c: commandes){
            if(p.test(c)){
            commandeList.add(c);}
        }
        return commandeList;*/
    }

    /**
     * liste des commandes dont au moins une ligne vérifie un prédicat
     */
    public List<Commande> selectionCommandeSurExistanceLigne(Predicate<Paire<Produit,Integer>> p) {
        return commandes.stream()
            .filter(c -> c.lignes().stream().anyMatch(p))
            .collect(Collectors.toList());
        /*
        List <Commande> commandeList = new Arraylist <>();
        for(Commande c: commandes){
        for(Paire<Produit,Integer> paire:commande.lignes()){
            if(p.test(c)) {
                commandeList.add(c);
            }
            }
        }
        return commandeList;*/
    }

    /**
     * ensemble des différents produits commandés vérifiant un prédicat
     */
    public Set<Produit> selectionProduits(Predicate<Produit> p) {
        return produits()
            .stream()
            .filter(p)
            .collect(Collectors.toSet());
        /*
          Set<Produit> sp = new HashSet<Produit>() ;
        for(int i = 0 ; i < produits().size() ; i++) {
            produits().get(i).lignes().forEach(cl -> {
                sp.add(cl) ;
            });

        }
        return sp ;
         */
    }

}

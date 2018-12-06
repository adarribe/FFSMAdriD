/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    private LinkedList<Embauche> myEmployeurs = new LinkedList<>(); 

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome, int niveau, Licence l, GroupeSanguin gs) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance,niveau, l ,gs);
        this.numeroDiplome = numeroDiplome;
    }

    public Club employeur() {
        int res = -1;
        for (int i =0;i<myEmployeurs.size();i++){
            if(!myEmployeurs.get(i).estTerminee()){
                res = i;
            }
        }
        if(res<0){
            return null;
        }
        else{
            return myEmployeurs.get(res).getEmployeur();
        }
    }
    
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {  
        myEmployeurs.add(new Embauche(debutNouvelle,this,employeur));
    }

    public List<Embauche> emplois() {
        return myEmployeurs;
    }

}

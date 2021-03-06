package FFSSM;

import java.util.Calendar;
import java.util.HashSet;

public class Plongeur extends Personne {
    int niveau;
    private HashSet<Licence> myLicences = new HashSet<>();
    GroupeSanguin gs;
    
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int niveau, Licence l, GroupeSanguin gs){
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        myLicences.add(l);
        this.gs = gs;
    }

    public Plongeur(Personne p, int niveau, Licence l, GroupeSanguin gs){
        super(p.getNumeroINSEE(),p.getNom(),p.getPrenom(),p.getAdresse(),p.getTelephone(),p.getNaissance());
        this.niveau = niveau;
        myLicences.add(l);
        this.gs = gs;        
    }
    
    public void ajouterLicense(Licence l){
        myLicences.add(l);
    }
    
    public HashSet<Licence> getLicences(){
        return this.myLicences;
    } 

    public void setGS(GroupeSanguin gs){
        this.gs=gs;
    }
    
    public GroupeSanguin getGS(){
        return this.gs;
    }
    
    public void setNiveau(int nv){
        this.niveau = nv;
    }
    
    public int getNiveau(){
        return this.niveau;
    }
    
    public boolean licencesValides (Calendar d){
        boolean valid = false;
        for(Licence l : myLicences){
            if(l.estValide(d)){
                valid = true;
            }
        }
        return valid;
    }
}

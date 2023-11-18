package org.example.business;

import org.example.entity.Projet;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProjetBusiness {
    public static List<Projet> projets;
    ChefProjetBusiness ChPB=new ChefProjetBusiness();
    public ProjetBusiness() {
        projets= new ArrayList<>();
    }



    public boolean addProjet(Projet p){
               return projets.add(p);

    }

    public List<Projet> getProjets() {
        return projets;
    }


    public boolean deleteProjet(int id){
        Iterator<Projet> iterator=projets.iterator();
        while(iterator.hasNext()){
            Projet p=iterator.next();
            if(p.getId()==id){
                iterator.remove();
                return true;
            }
        }
        return false;
    }


    public Projet getProjetByMatricule(String matricule){

        for (Projet l:projets){
            if(l.getChefprojet().getMatricule()==matricule)

                return l;
        }
        return null;
    }
public List<Projet> getProjectsChef(String matchef){
        List<Projet>listp=new ArrayList<>();
        for (int i=0;i<projets.size();i++){
            if( projets.get(i).getChefprojet().equals(matchef)){
                listp.add(projets.get(i));
            }

        }
    return listp;
}

}

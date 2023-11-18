package org.example.ressources;

import org.example.business.ChefProjetBusiness;
import org.example.business.ProjetBusiness;
import org.example.entity.Projet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/projet")
public class ProjetRessources {
public static ProjetBusiness projetBusiness=new ProjetBusiness();
public static ChefProjetBusiness chefprojetBusiness=new ChefProjetBusiness();

@POST
@Path("addProjet")
@Consumes(MediaType.APPLICATION_JSON)
public Response addProjet(Projet projet) {
    if (projetBusiness.addProjet(projet))
        return Response.status(Response.Status.CREATED).build();
    return Response.status(Response.Status.NOT_FOUND).build();
}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogements() {
        List<Projet> liste = projetBusiness.getProjets();
        if (liste.size() == 0)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.status(Response.Status.OK).entity(liste).build();


    }
    @Path("/get/{param}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Projet getProjetByMatricule( @PathParam("param") String param){
             Projet p=projetBusiness.getProjetByMatricule(param);
             if (p!=null){
                 return p;
             }
             else return  null;
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteLogement( @PathParam("id") int id) {
        if (projetBusiness.deleteProjet(id))
            return Response.status(Response.Status.OK).build();


        return Response.status(Response.Status.NOT_FOUND).build();

    }
    @Path("/getChef/{param}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Projet> getProjetByMatriculeChef( @PathParam("param") String param){
        List<Projet> p=projetBusiness.getProjectsChef(param);
       if( p.size()>0){
           return p;
       }
       return null;
    }


}

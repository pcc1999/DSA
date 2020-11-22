package edu.upc.dsa.services;


import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/tracks", description = "Endpoint to Track Service")
@Path("/tracks")
public class Covid19Service {

    private Covid19Manager cm;

    public Covid19Service() {
        this.cm = Covid19ManagerImpl.getInstance();
        if (cm.size()==0) {
            Caso caso0 = new Caso("Ákos", "Schneider", "1998/11/21", "2020/11/21", "Medio", "Hombre", "akos.schneider@estudiantat.upc.edu", 928363722, "Resi", "Confirmado");
            Caso caso1 = new Caso("Toni", "Mur García", "1999/2/26", "2020/11/17", "Alto", "Hombre", "toni.tur@estudiantat.upc.edu", 826382627, "Badal", "No Caso");
            Brote nuevo = new Brote();
            nuevo.addCaso(caso0);
            nuevo.addCaso(caso1);
            this.cm.anadirBrote(nuevo);
        }
    }

    @GET
    @ApiOperation(value = "get all Brotes", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Brote.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBrotes() {

        List<Brote> brotes = this.cm.findAll();

        GenericEntity<List<Brote>> entity = new GenericEntity<List<Brote>>(brotes) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Brote.class),
            @ApiResponse(code = 404, message = "Brote not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBrote(@PathParam("id") int id) {
        Brote b = this.cm.getBrote(id);
        if (b == null) return Response.status(404).build();
        else  return Response.status(201).entity(b).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Brote not found")
    })
    @Path("/{id}")
    public Response borrarBrote(@PathParam("id") int id) {
        Brote b = this.cm.getBrote(id);
        if (b == null) return Response.status(404).build();
        else this.cm.borrarBrote(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateBrote(Brote brote, int id) {

        Brote b = this.cm.updateBrote(id, brote);

        if (b == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Brote.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newBrote(Brote brote) {

        if (brote.getNumCasos()==0)  return Response.status(500).entity(brote).build();
        this.cm.anadirBrote(brote);
        return Response.status(201).entity(brote).build();
    }

    @POST
    @ApiOperation(value = "adds a new Caso in a Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Caso.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newCasoEnBrote(int ID, Caso nuevo) {

        if (nuevo.getFechaInforme().equals("") || nuevo.getApellidos().equals("") || nuevo.getClasificacion().equals("") || nuevo.getCorreoElectronico().equals("") || nuevo.getDireccion().equals("") || nuevo.getFechaNacimiento().equals("") || nuevo.getGenero().equals("") || nuevo.getNivelRiesgo().equals("") || nuevo.getNombre().equals("") || nuevo.getTelf()==0)  return Response.status(500).entity(nuevo).build();
        this.cm.anadirCasoBrote(ID,nuevo);
        return Response.status(201).entity(nuevo).build();
    }

}

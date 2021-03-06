package edu.upc.dsa.services;


import edu.upc.dsa.*;
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
import java.util.List;

import static edu.upc.dsa.Covid19ManagerImpl.getInstance;

@Api(value = "/services", description = "Endpoint to Covid-19 Management Services")
@Path("/covid19")
public class RestService {

    @GET
    @ApiOperation(value = "get all Brotes", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Brote.class, responseContainer="List"),
            @ApiResponse(code=404, message ="Brote not found"),
    })
    @Path("/getAllBrotes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBrotes() throws BroteNotFoundException{

        List<Brote> brotes = getInstance().findAll();

        GenericEntity<List<Brote>> entity = new GenericEntity<List<Brote>>(brotes) {};
        if(brotes.size()==0) {
            return Response.status(404).build();
        }
        else {
            return Response.status(201).entity(entity).build();
        }

    }

    @GET
    @ApiOperation(value = "get a Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Brote.class),
            @ApiResponse(code = 404, message = "Brote not found")
    })
    @Path("/getBrote/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBrote(@PathParam("id") int id) throws BroteNotFoundException {
        Brote b = getInstance().getBrote(id);
        if (b == null) return Response.status(404).build();
        else  return Response.status(201).entity(b).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Brote not found")
    })
    @Path("/deleteBrote/{id}")
    public Response borrarBrote(@PathParam("id") int id) throws BroteNotFoundException {
        Brote b = getInstance().getBrote(id);
        if (b == null) return Response.status(404).build();
        else getInstance().borrarBrote(id);
        return Response.status(201).build();
    }
/*
    @POST
    @ApiOperation(value = "update a Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Brote not found")
    })
    @Path("/updateBrote/{ID}/")
    public Response updateBrote(@PathParam("Brote") Brote brote,@PathParam("ID") int id) throws ExceptionBroteNotFound{

        Brote b = getInstance().updateBrote(id, brote);

        if (b == null) return Response.status(404).build();

        return Response.status(201).build();
    }
*/
    @POST
    @ApiOperation(value = "create a new Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Brote.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/addBrote/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newBrote(Brote brote) {

        getInstance().anadirBrote(new Brote());
        return Response.status(201).build();
    }

    @POST
    @ApiOperation(value = "adds a new Caso in a Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Caso.class),
            @ApiResponse(code = 500, message = "Empty Caso")

    })

    @Path("/nuevoCaso/{ID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newCaso(@PathParam("ID") int ID, Caso nuevo) throws BroteNotFoundException {
        String nombre = nuevo.getNombre();
        String apellidos = nuevo.getApellidos();
        String informe = nuevo.getFechaInforme();
        String nacimiento = nuevo.getFechaNacimiento();
        String clasificacion = nuevo.getClasificacion();
        String genero = nuevo.getGenero();
        String nivelRiesgo = nuevo.getNivelRiesgo();
        String mail = nuevo.getCorreoElectronico();
        int telf = nuevo.getTelf();
        String direccion = nuevo.getDireccion();
        if (nuevo.getFechaInforme().equals("") || nuevo.getApellidos().equals("") || nuevo.getClasificacion().equals("") || nuevo.getCorreoElectronico().equals("") || nuevo.getDireccion().equals("") || nuevo.getFechaNacimiento().equals("") || nuevo.getGenero().equals("") || nuevo.getNivelRiesgo().equals("") || nuevo.getNombre().equals("") || nuevo.getTelf()==0)  return Response.status(500).entity(nuevo).build();
        else {
            getInstance().anadirCasoBrote(ID, new Caso(nombre, apellidos, nacimiento, informe, nivelRiesgo, genero, mail, telf, direccion, clasificacion));
        }
        return Response.status(201).entity(nuevo).build();
    }

}

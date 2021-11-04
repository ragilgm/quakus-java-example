package controller;

import dto.UserDto;
import dto.UserRequestDto;
import lombok.extern.slf4j.Slf4j;
import service.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Slf4j
public class UserController {

    @Inject
    private UserService userService;


    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDto getById(@PathParam("id") Long id) {
        log.info("incomming request .");
        return userService.getUserById(id);
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDto createUser(@Valid UserRequestDto userRequestDto) {
        log.info("incomming request .");
        return userService.createUser(userRequestDto);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDto updateUser(@PathParam("id") Long id, UserRequestDto userRequestDto) {
        log.info("incomming request .");
       return userService.updateUser(id,userRequestDto);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDto deleteUser(@PathParam("id") Long id) {
        log.info("incomming request .");
        return userService.deleteUser(id);
    }

}

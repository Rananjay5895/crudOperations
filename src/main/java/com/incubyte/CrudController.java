package com.incubyte;

import io.micronaut.http.annotation.*;

@Controller("/subscribe")
public class UserController {
    private final CrudService crudService;

    public CrudController(CrudService crudService) {

        this.crudService = crudService;
    }

    @Post("/")
    public Response<User> save(@Body User user) {
        User savedUser =crudService.save(user);
        //TODO: Create static methods that will allow you to pass just the user
        return Response.success(savedUser);
        return new Response<>(savedUser, Response.Status.SUCCESS, null, null);
    }

    @Get("/subscriber/{id}")
    public Response<User> findById(@PathVariable Long id) {
        User user = crudService.findById(id);
        return new Response<>(user, Response.Status.SUCCESS, null, null);

    }

    @Put("/{id}")
    public Response<User> update(@PathVariable Long id, @Body User user) {
        User updatedUser = crudService.update(id, user);
        return new Response<>(updatedUser,Response.Status.SUCCESS,null,null);
    }

    @Delete("/{id}")
    public Response<String> deleteById(@PathVariable Long id) {
        return crudService.deleteById(id);
    }

}

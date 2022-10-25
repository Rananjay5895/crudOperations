package com.incubyte;

import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;

//TODO: Move it to Test Folder Structure
@Client("/subscribe")
public interface CrudClient {
    @Get("/subscriber/{id}")
    Response<User> findById(@PathVariable Long id);

    @Post("/")
    Response<User> save(User user);

    @Put("/{id}")
    Response<User> update(@PathVariable Long id , @Body User user);

    @Delete("/{id}")
    Response<User> deleteById(@PathVariable Long id);

}

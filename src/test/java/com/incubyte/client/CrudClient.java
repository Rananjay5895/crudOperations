package com.incubyte.client;

import com.incubyte.Response;
import com.incubyte.User;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;

@Client("/subscribe")
public interface CrudClient {
    @Get("/subscriber/{id}")
    Response<User> findById(@PathVariable Long id);

    @Post("/")
    Response<User> save(@Body User user);

    @Put("/{id}")
    Response<User> update(@PathVariable Long id , @Body User user);

    @Delete("/{id}")
    Response<User> deleteById(@PathVariable Long id);

}

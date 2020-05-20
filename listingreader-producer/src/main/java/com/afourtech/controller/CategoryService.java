package com.afourtech.controller;

import com.afourtech.beans.CategoryDataResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Path("/internal/listingreader/v1")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryService {

  private final int port=8010;
  private final String protocol="http";
  private final String host="localhost";

  @GET
  @Path("/category/{categoryId}")
  public CategoryDataResponse getCategoryById(@PathParam("categoryId") String categoryId) {
    throw new NotImplementedException();
  //TODO: Retrieve data from dummy DAO and populated CategoryData or just return the same value always
  // i.e.   return new CategoryData();

  }

  @GET
  @Path("/categories")
  public CategoryDataResponse getAllCategories() {

    //TODO: Retrieve data from dummy DAO and populated CategoryData or just return the same value always
    // i.e.   return new array of  CategoryData();
    throw new NotImplementedException();
  }
}
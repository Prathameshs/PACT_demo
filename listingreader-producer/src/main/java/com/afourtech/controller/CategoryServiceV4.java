package com.afourtech.controller;

import com.afourtech.beans.CategoryDataResponse;
import com.afourtech.dao.data.CategoryDataDAO;
import com.afourtech.model.Status;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/internal/listingreader/v1")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryServiceV4 {

  private final int port = 8010;
  private final String protocol = "http";
  private final String host = "localhost";

  @GET
  @Path("/category/{categoryId}")
  public CategoryDataResponse getCategoryById(@PathParam("categoryId") String categoryId) {
    CategoryDataResponse categoryDataResponse=new CategoryDataResponse(new Status(), new CategoryDataDAO().getSpecificCategory(categoryId));
    return categoryDataResponse;
  }

  @GET
  @Path("/categories")
  public CategoryDataResponse getAllCategories() {
    CategoryDataResponse categoryDataResponse = new CategoryDataResponse(new Status(),
        new CategoryDataDAO().getAllCategories());
    return categoryDataResponse;
  }

  /*
  *//**
   * @Descrition Method To Validate the Return Data Type Error
   *//*
  @GET
  @Path("/category/{categoryId}")
  public CategoryDataResponseV2 getCategoryById(@PathParam("categoryId") String categoryId) {
    CategoryDataResponseV2 categoryDataResponse=new CategoryDataResponseV2(new StatusV2(), new CategoryDataDAO().getSpecificCategory(categoryId));
    return categoryDataResponse;
  }*/



 /* @GET
  @Path("/category/{categoryId}")
  public CategoryDataResponseV3 getCategoryById(@PathParam("categoryId") String categoryId) {
    CategoryDataResponseV3 categoryDataResponse = new CategoryDataResponseV3(new StatusV3(),
        new CategoryDataDAO().getSpecificCategory(categoryId));
    return categoryDataResponse;
  }*/

}
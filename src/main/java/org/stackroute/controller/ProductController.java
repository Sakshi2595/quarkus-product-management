package org.stackroute.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.stackroute.model.Product;
import org.stackroute.service.ProductService;

// Add annotations for Path, Produces,Consumes
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {
    //inject ProductService Class
    @Inject
    ProductService productService;


    //add controller methods for addProduct
    @POST
    public Response addProduct(Product product) {
        Product newProduct = productService.addProduct(product);
        return Response.status(Response.Status.CREATED).entity(product).build();
    }

    //add controller methods for getAllProducts
    @GET
    public Response getAllProducts() {
        return Response.ok(productService.getAllProducts()).build();
    }

    //add controller methods for getProductById
    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") Long id) {
        return Response.ok(productService.getProductById(id)).build();
    }

    //add controller methods for updateProduct
    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") Long id, Product product) {
        product.setId(id);
        return Response.ok(productService.updateProduct(id, product)).build();
    }

    //add controller methods for deleteProduct
    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        productService.deleteProduct(id);
        return Response.ok().build();
    }

}

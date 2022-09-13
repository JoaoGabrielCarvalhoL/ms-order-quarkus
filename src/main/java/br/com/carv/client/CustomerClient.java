package br.com.carv.client;

import br.com.carv.dto.CustomerDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/customers")
@RegisterRestClient
@ApplicationScoped
public interface CustomerClient {

    @GET
    @Path("/{id}")
    CustomerDto findById(@PathParam("id") Long id);
}

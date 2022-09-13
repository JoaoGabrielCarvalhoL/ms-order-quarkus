package br.com.carv.controller;

import br.com.carv.dto.OrderDto;
import br.com.carv.service.OrderService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/orders")
public class OrderController {

    private OrderService orderService;

    @Inject
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return Response.status(Response.Status.OK).entity(orders).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveNewOrder(OrderDto orderDto) {
        orderService.saveNewOrder(orderDto);
        return Response.status(Response.Status.CREATED).build();
    }
}

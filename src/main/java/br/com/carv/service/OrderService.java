package br.com.carv.service;

import br.com.carv.exception.NotFoundException;
import br.com.carv.client.CustomerClient;
import br.com.carv.client.ProductClient;
import br.com.carv.dto.CustomerDto;
import br.com.carv.dto.OrderDto;
import br.com.carv.entity.OrderEntity;
import br.com.carv.repository.OrderRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrderService {
    private OrderRepository orderRepository;
    @RestClient
    @Inject
    private CustomerClient customerClient;

    @RestClient
    @Inject
    private ProductClient productClient;

    @Inject
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveNewOrder(OrderDto orderDto) {
        CustomerDto dto = customerClient.findById(orderDto.getCustomerId());

        if (dto.getName().equals(orderDto.getCustomerName()) &&
                productClient.findById(orderDto.getProductId()) != null) {
            orderRepository.persist(new OrderEntity(orderDto));
        } else {
            throw new NotFoundException("not found exception.generic");
        }
    }

    public List<OrderDto> getAllOrders(){
        PanacheQuery<OrderEntity> query = orderRepository.findAll();
        List<OrderDto> orders = query.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
        return orders;
    }
}

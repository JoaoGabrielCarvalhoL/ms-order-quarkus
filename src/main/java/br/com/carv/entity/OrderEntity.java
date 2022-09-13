package br.com.carv.entity;

import br.com.carv.dto.OrderDto;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orderProducts")
public class OrderEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private String customerName;

    private Long productId;

    private BigDecimal orderValue;

    public OrderEntity() {

    }

    public OrderEntity(Long customerId, String customerName, Long productId, BigDecimal orderValue) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.productId = productId;
        this.orderValue = orderValue;
    }

    public OrderEntity(OrderDto dto) {
        this.customerId = dto.getCustomerId();
        this.customerName = dto.getCustomerName();
        this.productId = dto.getProductId();
        this.orderValue = dto.getOrderValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(BigDecimal orderValue) {
        this.orderValue = orderValue;
    }
}

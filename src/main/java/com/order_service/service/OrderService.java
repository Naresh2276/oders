package com.order_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.order_service.entity.OrderEntity;
import com.order_service.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // CREATE
    public OrderEntity createOrder(OrderEntity order) {

        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        return orderRepository.save(order);
    }

    // GET ALL
    public List<OrderEntity> getAllOrders() {

        return orderRepository.findAll();
    }

    // GET BY ID
    public OrderEntity getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Order not found with id: " + id));
    }

    // UPDATE
    public OrderEntity updateOrder(Long id, OrderEntity order) {

        OrderEntity existingOrder = orderRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Order not found with id: " + id));

        existingOrder.setCustomerId(order.getCustomerId());
        existingOrder.setProductCode(order.getProductCode());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setAmount(order.getAmount());
        existingOrder.setStatus(order.getStatus());
        existingOrder.setUpdatedBy(order.getUpdatedBy());
        existingOrder.setUpdatedAt(LocalDateTime.now());

        return orderRepository.save(existingOrder);
    }

    // DELETE
    public String deleteOrder(Long id) {

        OrderEntity existingOrder = orderRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Order not found with id: " + id));

        orderRepository.delete(existingOrder);

        return "Order deleted successfully";
    }
}
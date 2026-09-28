package com.order_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order_service.entity.OrderEntity;
import com.order_service.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(
            @RequestBody OrderEntity order) {

        return ResponseEntity.ok(
                orderService.createOrder(order));
    }

    // GET ALL
    @GetMapping /
    public ResponseEntity<List<OrderEntity>> getAllOrders() {

        return ResponseEntity.ok(
                orderService.getAllOrders());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getOrderById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                orderService.getOrderById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<OrderEntity> updateOrder(
            @PathVariable Long id,
            @RequestBody OrderEntity order) {

        return ResponseEntity.ok(
                orderService.updateOrder(id, order));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                orderService.deleteOrder(id));
    }
}

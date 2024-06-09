package com.n3.mebe.controller;

import com.n3.mebe.dto.response.order.OrderResponse;
import com.n3.mebe.service.iml.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public List<OrderResponse> getOrdersList() {
        return orderService.getOrdersList();
    }


}

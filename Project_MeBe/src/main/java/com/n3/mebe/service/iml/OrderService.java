package com.n3.mebe.service.iml;


import com.n3.mebe.dto.request.order.OrderRequest;
import com.n3.mebe.dto.response.order.OrderResponse;
import com.n3.mebe.entity.Order;
import com.n3.mebe.repository.IOrderReository;
import com.n3.mebe.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderReository orderReository;


    @Override
    public Order createOrder(OrderRequest orderRequest) {
        return null;
    }

    @Override
    public Order updateOrder(OrderRequest orderRequest) {
        return null;
    }

    @Override
    public void deleteOrder(String orderId) {

    }


    /**
     *  Request from Client
     *
     */




    /**
     *  Response from Client
     *
     */

    // <editor-fold default state="collapsed" desc="Get List Orders">
    @Override
    public List<OrderResponse> getOrdersList() {
        List<Order> list = orderReository.findAll();
        List<OrderResponse> orderResponseList = new ArrayList<>();

        for (Order order : list) {
            OrderResponse orderResponse = new OrderResponse();

            orderResponse.setOrderId(order.getOrderId());
            orderResponse.setUser(order.getUser());
            orderResponse.setVoucher(order.getVoucher());
            orderResponse.setStatus(order.getStatus());
            orderResponse.setDeliveryFee(order.getDeliveryFee());
            orderResponse.setTotalAmount(order.getTotalAmount());
            orderResponse.setDepositeAmount(order.getDepositeAmount());
            orderResponse.setOrderType(order.getOrderType());
            orderResponse.setPaymentStatus(order.getPaymentStatus());
            orderResponse.setNote(order.getNote());
            orderResponse.setCreatedAt(order.getCreatedAt());
            orderResponse.setUpdatedAt(order.getUpdatedAt());

            orderResponseList.add(orderResponse);
        }

        return orderResponseList;
    }// </editor-fold>
}

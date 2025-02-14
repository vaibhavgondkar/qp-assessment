package com.questionpro.serviceimpl;

import com.questionpro.dto.OrderItem;
import com.questionpro.dto.OrderRequest;
import com.questionpro.entity.Order;
import com.questionpro.repo.OrderRepository;
import com.questionpro.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    public static final Logger logger = LoggerFactory.getLogger(GroceryItemServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        try {
            logger.info("Inside create order method");
            Order order = new Order();
            List<OrderItem> orderItems = orderRequest.getOrderItems().stream().map(item -> {
                OrderItem orderItem = new OrderItem();
                orderItem.setItemId(item.getItemId());
                orderItem.setQuantity(item.getQuantity());
                return orderItem;
            }).collect(Collectors.toList());
            order.setUserId(orderRequest.getUserId());
            order.setOrderItems(orderItems);
            return orderRepository.save(order);
        } catch (Exception e) {
            logger.error("Error creating order ", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

package com.questionpro.service;

import com.questionpro.dto.OrderRequest;
import com.questionpro.entity.Order;

public interface OrderService {
    Order createOrder(OrderRequest orderRequest);

}

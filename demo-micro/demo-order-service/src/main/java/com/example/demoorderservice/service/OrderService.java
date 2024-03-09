package com.example.demoorderservice.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demoorderservice.dto.InventoryResponse;
import com.example.demoorderservice.dto.OrderRequest;
import com.example.demoorderservice.model.Order;
import com.example.demoorderservice.model.OrderLineItem;
import com.example.demoorderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClient;

    public void placeOrder(OrderRequest orderRequest) throws Exception {
        Order order = new Order();

        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItem> list = orderRequest.getOrderLineItemDto()
                .stream()
                .map(dto -> {
                    OrderLineItem orderLineItem = new OrderLineItem();
                    orderLineItem.setPrice(dto.getPrice());
                    orderLineItem.setQuantity(dto.getQuantity());
                    orderLineItem.setSkuCode(dto.getSkuCode());
                    return orderLineItem;
                })
                .collect(Collectors.toList());

        order.setOrderLineItems(list);

        List<String> request = order.getOrderLineItems().stream()
                .map(item -> item.getSkuCode()).collect(Collectors.toList());

        InventoryResponse[] result = webClient.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("sku-code", request).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        for(InventoryResponse item : result){
            if(!item.isInStock()){
                throw new Exception("Fail to place order, please try again");
            }
        }

        orderRepository.save(order);
    }
}

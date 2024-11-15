package com.lsoria.pizzaservice.domain.model;

import com.lsoria.pizzaservice.domain.abstraction.Promotion;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private User user;
    private LocalDate orderDate;
    private List<OrderItem> orderItems;
    private List<Promotion> applicablePromotions;
    private boolean isDeliveryFree;


    public Order(User user, LocalDate orderDate, List<OrderItem> orderItems, List<Promotion> availablePromotions) {
        this.user = user;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.applicablePromotions = availablePromotions.stream()
                .filter(promo -> promo.isApplicable(orderDate))
                .collect(Collectors.toList());
        applyPromotions();
    }

    public double calculateTotal() {
        double total = orderItems.stream().mapToDouble(OrderItem::calculateItemPrice).sum();
        for (Promotion promo : applicablePromotions) {
            total = promo.applyDiscount(total);
        }
        return total;
    }

    private void applyPromotions() {
        if (applicablePromotions.stream().anyMatch(FreeDeliveryPromotion.class::isInstance)) {
            this.isDeliveryFree = true;
        }
    }
}

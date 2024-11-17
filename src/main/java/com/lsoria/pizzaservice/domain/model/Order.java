package com.lsoria.pizzaservice.domain.model;

import com.lsoria.pizzaservice.domain.abstraction.Promotion;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    private List<Promotion> promotions;
    private boolean deliveryFree;


    public Order(User user, LocalDate orderDate, List<OrderItem> orderItems, List<Promotion> availablePromotions) {
        this.user = user;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.promotions = availablePromotions;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;

        boolean hasPromotions = this.promotions != null && !this.promotions.isEmpty();

        for (OrderItem orderItem : this.orderItems) {
            double itemPrice = orderItem.getPizza().calculatePrice();

            if (!hasPromotions) {
                totalPrice += itemPrice * orderItem.getQuantity();
            } else {
                int actualQuantity = orderItem.getQuantity();

                for (Promotion promotion : this.promotions) {
                    if (promotion instanceof TwoForOnePromotion) {
                        totalPrice += itemPrice * ((double) actualQuantity / 2);
                    } else {
                        totalPrice += itemPrice * actualQuantity;
                    }
                }
            }
        }

        return totalPrice;
    }

}

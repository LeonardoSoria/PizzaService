package com.lsoria.pizzaservice.application.port.output;

import com.lsoria.pizzaservice.domain.abstraction.Promotion;

import java.util.List;

public interface PromotionOutputPort {
        List<Promotion> getPromotions();
}

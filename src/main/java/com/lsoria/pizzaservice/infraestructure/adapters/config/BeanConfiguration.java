package com.lsoria.pizzaservice.infraestructure.adapters.config;

import com.lsoria.pizzaservice.application.service.OrderService;
import com.lsoria.pizzaservice.application.service.factory.concrete.CustomPizzaFactory;
import com.lsoria.pizzaservice.application.service.factory.concrete.PredefinedPizzaFactory;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.adapter.IngredientPersistenceAdapter;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.adapter.OrderPersistenceAdapter;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.adapter.PromotionPersistenceAdapter;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.adapter.RecipePersistenceAdapter;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper.IngredientPersistenceMapper;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper.OrderPersistenceMapper;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper.RecipePersistenceMapper;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository.IngredientRepository;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository.OrderRepository;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository.PromotionRepository;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository.RecipeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public OrderPersistenceAdapter orderPersistenceAdapter(final OrderRepository orderRepository, final OrderPersistenceMapper orderPersistenceMapper) {
        return new OrderPersistenceAdapter(orderRepository, orderPersistenceMapper);
    }

    @Bean
    public IngredientPersistenceAdapter ingredientPersistenceAdapter(final IngredientRepository ingredientRepository,
                                                                     final IngredientPersistenceMapper ingredientPersistenceMapper) {
        return new IngredientPersistenceAdapter(ingredientRepository, ingredientPersistenceMapper);
    }

    @Bean
    public RecipePersistenceAdapter recipePersistenceAdapter(final RecipeRepository recipeRepository,
                                                             final RecipePersistenceMapper recipePersistenceMapper) {
        return new RecipePersistenceAdapter(recipeRepository, recipePersistenceMapper);
    }

    @Bean
    public PromotionPersistenceAdapter promotionPersistenceAdapter(final PromotionRepository promotionRepository) {
        return new PromotionPersistenceAdapter(promotionRepository);
    }

    @Bean
    public CustomPizzaFactory customPizzaFactory(final IngredientPersistenceAdapter ingredientPersistenceAdapter) {
        return new CustomPizzaFactory(ingredientPersistenceAdapter);
    }

    @Bean
    public PredefinedPizzaFactory predefinedPizzaFactory(final RecipePersistenceAdapter recipePersistenceAdapter) {
        return new PredefinedPizzaFactory(recipePersistenceAdapter);
    }

    @Bean
    public OrderService orderService(final OrderPersistenceAdapter orderPersistenceAdapter,
                                     final PromotionPersistenceAdapter promotionPersistenceAdapter,
                                     final PredefinedPizzaFactory pizzaFactory,
                                     final CustomPizzaFactory customPizzaFactory) {
        return new OrderService(orderPersistenceAdapter, promotionPersistenceAdapter, pizzaFactory, customPizzaFactory);
    }
}

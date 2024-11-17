-- CREATE DATABASE pizzaDB;

USE pizzaDB;
-- USERS
INSERT INTO user_entity (id, email, name)
VALUES (1, 'test@example.com', 'Leonardo Soria');

-- INGREDIENTS
INSERT INTO ingredient_entity VALUES (1, 'peperoni', 10);
INSERT INTO ingredient_entity VALUES (2, 'tomate', 5);
INSERT INTO ingredient_entity VALUES (3, 'queso', 8);
INSERT INTO ingredient_entity VALUES (4, 'jamon', 12);
INSERT INTO ingredient_entity VALUES (5, 'piña', 200);

-- RECIPES
INSERT INTO recipe_entity VALUES (1, 'Pizza clasica con tomate, jamon y queso', 'Pizza clasica');
INSERT INTO recipe_entity VALUES (2, 'Pizza clasica con tomate, jamon, queso y peperoni', 'Pizza de peperoni');
INSERT INTO recipe_entity VALUES (3, 'Pizza clasica con tomate, jamon, queso y piña', 'Pizza Hawaiana');

-- INGREDIENTS_RECIPES
-- Clasica Ingredients
INSERT INTO recipe_ingredient VALUES (1, 2);
INSERT INTO recipe_ingredient VALUES (1, 3);
INSERT INTO recipe_ingredient VALUES (1, 4);

-- Peperoni Ingredients
INSERT INTO recipe_ingredient VALUES (2, 1);
INSERT INTO recipe_ingredient VALUES (2, 2);
INSERT INTO recipe_ingredient VALUES (2, 4);
INSERT INTO recipe_ingredient VALUES (2, 3);

-- Hawaiana Ingredients
INSERT INTO recipe_ingredient VALUES (3, 2);
INSERT INTO recipe_ingredient VALUES (3, 3);
INSERT INTO recipe_ingredient VALUES (3, 4);
INSERT INTO recipe_ingredient VALUES (3, 5);

-- PROMOTIONS
INSERT INTO promotion_entity (id, description, name, promotion_type)
VALUES (1, 'Two pizzas for the price of one on Tuesdays and Wednesdays', '2x1 Pizza Promotion', 'TWO_FOR_ONE'),
       (2, 'Free delivery on Thursdays', 'Free Delivery Promotion', 'FREE_DELIVERY');
       
INSERT INTO promotion_entity_applicable_days (promotion_entity_id, applicable_days)
VALUES (1, 'TUESDAY'), -- TUESDAY for "2x1 Pizza Promotion"
       (1, 'WEDNESDAY'), -- WEDNESDAY for "2x1 Pizza Promotion"
       (2, 'THURSDAY'); -- THURSDAY for "Free Delivery Promotion"




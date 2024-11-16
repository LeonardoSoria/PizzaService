CREATE DATABASE pizzaDB;

USE pizzaDB;
-- USERS
INSERT INTO user_entity (id, email, name)
VALUES (1, 'test@example.com', 'Leonardo Soria');

SELECT * FROM user_entity;

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
INSERT INTO recipe_ingredient VALUES (1, 1);
INSERT INTO recipe_ingredient VALUES (1, 2);
INSERT INTO recipe_ingredient VALUES (1, 4);
INSERT INTO recipe_ingredient VALUES (1, 3);

-- Hawaiana Ingredients
INSERT INTO recipe_ingredient VALUES (1, 2);
INSERT INTO recipe_ingredient VALUES (1, 3);
INSERT INTO recipe_ingredient VALUES (1, 4);
INSERT INTO recipe_ingredient VALUES (1, 5);


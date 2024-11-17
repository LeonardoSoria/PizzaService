# Project Setup and Testing

To get started with the project, please follow the instructions below to set up the database and test the application.

## 1. Run SQL Commands to Set Up the Database

Before running the app, you need to execute the following SQL commands to set up the required data in the database.

Run the SQL file located at `src/main/resources/pizzaDB-data.sql` in your MySQL database to create and populate the necessary tables.

# Pizza Service - Order Creation API

This API allows users to create an order, including pizzas, custom pizzas with ingredients, and delivery details. The service calculates the total price based on the selected items and applies any promotions available (e.g., 2 for 1, free delivery).

## Endpoint

**POST** `localhost:8080/api/orders/create`

### **Request Body**

The request body should be a JSON object with the following structure:

```json
{
    "userId": "1",
    "orderDate": "2024-11-11",
    "pizzaOrder": [
        {
            "pizzaRecipeId": 1,
            "quantity": 2
        },
        {
            "ingredients": [
                {
                    "ingredientId": 1
                },
                {
                    "ingredientId": 2
                },
                {
                    "ingredientId": 5
                }
            ],
            "quantity": 3
        }
    ],
    "deliveryAddress": "Av siempre viva numero 123"
}
```

### **Response Expected**

The response is a JSON object with the following structure:
```json
{
    "orderItemResponse": [
        {
            "pizzaName": "Pizza clasica",
            "quantity": 2
        },
        {
            "pizzaName": "Custom Pizza",
            "quantity": 3
        }
    ],
    "pizzaQuantity": 5,
    "totalPrice": 695.0,
    "deliveryFree": false
}
```




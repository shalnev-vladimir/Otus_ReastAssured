package user.createNewUser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.OrderClient;

import static org.hamcrest.Matchers.hasKey;

class GetOrderTest {

    /**
     * Позитивный тест.
     * Проверяем, что можно получить заказ с id в диапазоне от 1 до 10-и.
     */
    @Test
    void findExistingOrderByIdTest() {
        OrderClient orderClient = new OrderClient();
        orderClient.getExistingOrder().statusCode(200);
    }

    /**
     * Проверяем, что строка "shipDate" не null и не пустая
     */
    @Test
    void checkShipDateIsNotNullOrEmptyTest() {
        OrderClient orderClient = new OrderClient();
        String shipDate = orderClient.getExistingOrder().extract().path("shipDate");
        Assertions.assertNotNull(shipDate);
        Assertions.assertNotEquals("", shipDate);
    }

    /**
     * Проверяем, что в body ответа есть строки id, petId, quantity, shipDate, status, complete
     */
    @Test
    void checkRequiredFieldsPresentInResponseBodyTest() {
        OrderClient orderClient = new OrderClient();
        orderClient.getExistingOrder()
                .body("$", hasKey("id"))
                .body("$", hasKey("petId"))
                .body("$", hasKey("quantity"))
                .body("$", hasKey("shipDate"))
                .body("$", hasKey("status"))
                .body("$", hasKey("complete"));
    }

}

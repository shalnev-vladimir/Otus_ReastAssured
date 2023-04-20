package user.createNewUser;

import dto.OrderDTO;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import services.OrderClient;

import static org.hamcrest.CoreMatchers.equalTo;

class CreateNewOrderTest {

    /**
     * Проверяем, что можно создать заказ и возвращается при этом statusCode(200).
     */
    @Test
    void createOrderTest() {
        OrderClient orderClient = new OrderClient();

        OrderDTO orderDTO = OrderDTO
                .builder()
                .id(RandomUtils.nextInt())
                .petId(RandomUtils.nextInt())
                .quantity(RandomUtils.nextInt())
                .complete(true)
                .build();

        orderClient.placeAnOrderForAPet(orderDTO)
                .statusCode(200);
    }

    /**
     * Проверяем, что значение полей в ответе (body) заполнены теми же значениями,
     * которые были отправлены в запросе.
     */
    @Test
    void checkResponseFieldsAreFilledWithTheSameValuesAsInTheQueryTest() {
        int id = RandomUtils.nextInt();
        int petId = RandomUtils.nextInt();
        int quantity = RandomUtils.nextInt();

        OrderClient orderClient = new OrderClient();

        OrderDTO orderDTO = OrderDTO
                .builder()
                .id(id)
                .petId(petId)
                .quantity(quantity)
                .complete(true)
                .build();

        orderClient.placeAnOrderForAPet(orderDTO).assertThat()
                .body("id", equalTo(id))
                .body("petId", equalTo(petId))
                .body("quantity", equalTo(quantity))
                .body("complete", equalTo(true));
    }

}

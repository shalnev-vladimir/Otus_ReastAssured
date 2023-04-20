package services;

import dto.OrderDTO;
import io.restassured.response.ValidatableResponse;
import util.RandomDataGenerator;

import static io.restassured.RestAssured.given;

public class OrderClient extends RestAssuredClient {

    private static final String STORE_ORDER = "store/order";

    public ValidatableResponse placeAnOrderForAPet(OrderDTO orderDTO) {
        return given().
                spec(getBaseSpec())
                .log().all()
                .body(orderDTO)
                .when()
                .post(STORE_ORDER)
                .then()
                .log().all();

    }

    public ValidatableResponse getExistingOrder() {
        return given().
                spec(getBaseSpec())
                .log().all()
                .when()
                .get("store/order/" + RandomDataGenerator.getRandomNumberFromOneToTen())
                .then()
                .log().all();
    }
}

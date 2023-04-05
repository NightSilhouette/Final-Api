package org.example.TestDZ;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;




public class ExampleTest extends AbstractTest {

  //неверный логин пароль
  @Test
  void vhod() {
    given()
            .config(RestAssured
                    .config()
                    .encoderConfig(encoderConfig()
                            .encodeContentTypeAs("applycation/x-www-form-urlencoded", ContentType.TEXT)))

            .formParam("username", "1")
            .formParam("password", "1")
            .post(getBaseUrl())
            .then()
            .statusCode(401);

  }


  //Пустой логин пароль
  @Test
  void vhod1() {
    given()
            .config(RestAssured
                    .config()
                    .encoderConfig(encoderConfig()
                            .encodeContentTypeAs("applycation/x-www-form-urlencoded", ContentType.TEXT)))

            .formParam("username", "")
            .formParam("password", "")
            .post(getBaseUrl())
            .then()
            .statusCode(401);
  }

  @Test
  void vhod2() {
    given()
            .config(RestAssured
                    .config()
                    .encoderConfig(encoderConfig()
                            .encodeContentTypeAs("applycation/x-www-form-urlencoded", ContentType.TEXT)))

            .formParam("username", "iiiyruk97@mail.ru")
            .formParam("password", "92a3d3671d")
            .post(getBaseUrl())
            .then()
            .statusCode(200);


  }
}
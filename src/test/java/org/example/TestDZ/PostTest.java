package org.example.TestDZ;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
public class PostTest extends AbstractTestPost {


    //Тест ASC своего поста
    @Test
    void post() {
        given()
                .header("X-Auth-Token",getApiKey())
                .queryParam("order","ASC")
                .queryParam("page","1")
                .queryParam("sort","createdAt")
                .get(getBaseUrl())
                .then()
                .statusCode(200);
    }
 //Тест Desc своего поста
    @Test
    void post1() {
        given()
                .header("X-Auth-Token",getApiKey())
                .queryParam("order","DESC")
                .queryParam("page","1")
                .queryParam("sort","createdAt")
                .get(getBaseUrl())
                .then()
                .statusCode(200);
    }
    //Тест на своего поста page 0
    @Test
    void post2() {
        given()
                .header("X-Auth-Token",getApiKey())
                .queryParam("order","DESC")
                .queryParam("page","0")
                .queryParam("sort","createdAt")
                .get(getBaseUrl())
                .then()
                .statusCode(200);
    }
    //Тест на своего поста page 10
    @Test
    void post3() {
        given()
                .header("X-Auth-Token",getApiKey())
                .queryParam("order","DESC")
                .queryParam("page","10")
                .queryParam("sort","createdAt")
                .get(getBaseUrl())
                .then()
                .statusCode(200);
    }
    //Тест на своего поста page 2
    @Test
    void post4() {
        given()
                .header("X-Auth-Token",getApiKey())
                .queryParam("order","DESC")
                .queryParam("page","2")
                .queryParam("sort","createdAt")
                .get(getBaseUrl())
                .then()
                .statusCode(200);
    }


////////////////// ЧУЖЫЕ ПОСТЫ
///////////////////  ЧУЖЫЕ ПОСТЫ



    //Чужой пост  ALL
    @Test
    void post5() {
        given()
                .header("X-Auth-Token",getApiKey())
                .queryParam("order","ALL")
                .queryParam("page","1")
                .queryParam("sort","createdAt")
                .queryParam("owner","notMe")
                .get(getBaseUrl())
                .then()
                .statusCode(500);
    }
    //Чужой пост  desc
    @Test
    void post6() {
        given()
                .header("X-Auth-Token",getApiKey())
                .queryParam("order","DESC")
                .queryParam("page","10")
                .queryParam("sort","createdAt")
                .queryParam("owner","notMe")
                .get(getBaseUrl())
                .then()
                .statusCode(200);
    }
    //Чужой пост  ASC
    @Test
    void post7() {
        given()
                .header("X-Auth-Token",getApiKey())
                .queryParam("order","ASC")
                .queryParam("page","10")
                .queryParam("sort","createdAt")
                .queryParam("owner","notMe")
                .get(getBaseUrl())
                .then()
                .statusCode(200);
    }
    //Чужой пост  page-10
    @Test
    void post8() {
        given()
                .header("X-Auth-Token",getApiKey())
                .queryParam("order","ASC")
                .queryParam("page","-10")
                .queryParam("sort","createdAt")
                .queryParam("owner","notMe")
                .get(getBaseUrl())
                .then()
                .statusCode(200);
    }
    //Чужой пост  page 10000
    @Test
    void post9() {
        given()
                .header("X-Auth-Token",getApiKey())
                .queryParam("order","ASC")
                .queryParam("page","10000")
                .queryParam("sort","createdAt")
                .queryParam("owner","notMe")
                .get(getBaseUrl())
                .then()
                .statusCode(200);
    }
}

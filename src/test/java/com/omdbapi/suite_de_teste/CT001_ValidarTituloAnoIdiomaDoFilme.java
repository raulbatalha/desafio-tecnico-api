package com.omdbapi.suite_de_teste;

import com.omdbapi.utils.ConfiguracaoDeBase;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class CT001_ValidarTituloAnoIdiomaDoFilme {
    ConfiguracaoDeBase base;
    private static String tituloDoFilme;
    private static String anoDoFilme;
    private static String idiomaDoFilme;
    private static String idFilme;
    private static String ApiKey;
    private static String baseURL = "http://www.omdbapi.com/?i={idFilme}&apikey={ApiKey}";

    @Test
    public void validarTituloAnoIdiomaDoFilme() {
        base = new ConfiguracaoDeBase();
        Response respostaDoServidor = given()
                .contentType("application/json")
                .pathParam("idFilme", base.getIdDoFilme())
                .pathParam("ApiKey", base.getApiKey())
                .body(base.getCorpoFilmeEncontrado())
                .when().post(baseURL);
        respostaDoServidor.then().assertThat()
//                .body(matchesJsonSchemaInClasspath("src/configuracao/corpoDaApi.json"))
                .body("Title", containsString("The Social Network"))
                .body("Year", containsString("2010"))
                .body("Language", containsString("English, French"))
                .statusCode(200);
        tituloDoFilme = respostaDoServidor.jsonPath().getString("Title");
        anoDoFilme = respostaDoServidor.jsonPath().getString("Year");
        idiomaDoFilme = respostaDoServidor.jsonPath().getString("Language");
        System.out.println("Titulo do filme: " + tituloDoFilme + "\nAno do Filme: " + anoDoFilme + "\nIdioma do Filme: " + idiomaDoFilme);
    }

    @Test
    public void buscaFilmeInexistente() {
        base = new ConfiguracaoDeBase();
        Response respostaDoServidor = given()
                .contentType("application/json")
                .pathParam("idFilme", base.getIdDoFilmeNaoEncontrado())
                .pathParam("ApiKey", base.getApiKey())
                .body(base.getCorpoFilmeNaoEncontrado())
                .when().post(baseURL);
        respostaDoServidor.then().assertThat()
                .body("Response", containsString("False"))
                .body("Error", containsString("Movie not found!"))
                .statusCode(200);
        System.out.println("Mensagem do servidor: \n" + respostaDoServidor.body().asString());
    }
}
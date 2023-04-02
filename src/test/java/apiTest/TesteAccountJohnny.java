package apiTest;

import apiTest.pojo.Configuracao;
import apiTest.pojo.Usuario;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

class TesteAccountJohnny {

    public TesteAccountJohnny() throws IOException {
    }

    public String leArquivoJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //Instancia o objeto Gson
    Gson gson = new Gson();
    //Lê o arquivo json e instancia o objeto Configuracao
    String configuracaoJson = leArquivoJson("src/test/resources/json/configuracao.json");
    Configuracao configuracao = gson.fromJson(configuracaoJson, Configuracao.class);

    @Test
    @DisplayName("Teste de criação de uma conta")
    @Order(1) //Executa em primeiro
    void testeCriarUmaConta() throws IOException {
        //Le arquivo com informação de um usuário
        String jsonBody = leArquivoJson("src/test/resources/json/usuarioBookStore.json");

        //Transforma o json em um objeto usuario
        Usuario usuario = gson.fromJson(jsonBody, Usuario.class);

            given()
                .log().all()
                .contentType("application/json")
                .body(jsonBody)
            .when()
                .post(configuracao.getBaseUrl() + configuracao.getEndpoints().getUser())
            .then()
                .log().all()
                .statusCode(406)
                .body("message", is("User exists!"));
    };

    @ParameterizedTest
    @Order(2) //Executa em segundo
    @CsvSource(value = {
            "Frieda,11peaN*ts",
            "Shermy,11peaN*ts",
            "PigPen,11peaN*ts"
            }, delimiter = ',') //Separa os valores por virgula
    @DisplayName("Teste de criação Parametrizada de contas")
    void TesteDeCriacaoParametrizadaDeContas(String username, String password) throws IOException {
        // Cria um usuário
        Usuario usuario = new Usuario();

        //Seta os valores do usuário
        usuario.setUserName(username);
        usuario.setPassword(password);

        //Converte para json string
        String jsonBodyParametrizado = gson.toJson(usuario);

        //Executa
        given()
                .log().all()
                .contentType("application/json")
                .body(jsonBodyParametrizado)
        .when()
                .post(configuracao.getBaseUrl() + configuracao.getEndpoints().getUser())
        .then()
                .log().all()
                .statusCode(406)
                .body("message", is("User exists!"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/src/test/resources/csv/massaBookstoreUsers.csv", delimiter = ',', numLinesToSkip = 1) //Lê o arquivo csv
    @Order(3) //Executa em terceiro
    @DisplayName("Teste de criação Parametrizada de contas usando CSV")
    void TesteDeCriacaoParametrizadaDeContasCSV(String username, String password) throws IOException {
        // Cria um usuário
        Usuario usuario = new Usuario();

        //Seta os valores do usuário
        usuario.setUserName(username);
        usuario.setPassword(password);

        //Converte para json string
        String jsonBodyParametrizado = gson.toJson(usuario);

        //Executa
        given()
                .log().all()
                .contentType("application/json")
                .body(jsonBodyParametrizado)
        .when()
                .post(configuracao.getBaseUrl() + configuracao.getEndpoints().getUser())
        .then()
                .log().all()
                .statusCode(406)
                .body("message", is("User exists!"));
    }
}

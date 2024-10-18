import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        // Substitua pelo seu endpoint e chave de API
        String endpoint = "https://analise-de-texto.cognitiveservices.azure.com/text/analytics/v3.0/sentiment";
        String apiKey = "352bfa9e39d3433394a4007de103bae4";
        
        // Criação do cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        
        // Criação da requisição HTTP
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endpoint))
            .header("Ocp-Apim-Subscription-Key", apiKey)
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{ \"documents\": [{ \"id\": \"1\", \"text\": \"minha mãe não me dá atenção\" }] }"))
            .build();
        
        // Enviar a requisição e obter a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        // Exibir a resposta no console
        System.out.println(response.body());
    }
}

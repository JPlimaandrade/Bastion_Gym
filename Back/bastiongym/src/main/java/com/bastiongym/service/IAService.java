package com.bastiongym.service;

import com.bastiongym.dto.IAInput;
import com.bastiongym.dto.IAOutput;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class IAService {

    private final RestClient restClient;

    public IAService(RestClient restClient) {
        this.restClient = restClient;
    }

    // Metodo pra enviar mensagem para a IA e receber uma resposta
    public IAOutput perguntar(IAInput input) {

        Map<String, Object> sistema = Map.of(
                "role", "system",
                "content", "Você é o assistente virtual do BastionGYM. " +
                        "Responda sempre em português do Brasil, " +
                        "de forma clara, objetiva e amigável."
        );

        Map<String, Object> mensagem = Map.of(
                "role", "user",
                "content", input.getMensagem()
        );

        Map<String, Object> request = Map.of(
                "model", "openrouter/free",
                "messages", List.of(sistema, mensagem),
                "max_tokens", 1000
        );
        String apiKey = System.getenv("OPENROUTER_API_KEY");

        Map<String, Object> resposta = restClient.post()
                .uri("https://openrouter.ai/api/v1/chat/completions")
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(request)
                .retrieve()
                .body(Map.class);

        List<Map<String, Object>> choices =
                (List<Map<String, Object>>) resposta.get("choices");

        Map<String, Object> choice = choices.getFirst();

        Map<String, Object> message =
                (Map<String, Object>) choice.get("message");

        String texto = (String) message.get("content");

        IAOutput output = new IAOutput();
        output.setResposta(texto);

        return output;
    }
}
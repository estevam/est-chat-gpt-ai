package ca.est.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ca.est.response.ChatRequest;
import ca.est.response.ChatResponse;

@RestController
public class ChatController {
    
    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${openai.model}")
    private String model;
    
    @Value("${openai.api.url}")
    private String apiUrl;
    /**
     * Handling GET requests to "/chat" endpoint
     * @param prompt
     * @return
     */
    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {
    	// Creating a request object with the provided model and prompt
        ChatRequest request = new ChatRequest(model, prompt);
        
        // Making a POST request to the API endpoint and expecting a ChatResponse
        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);
        
        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }
        
        // Returning the content of the first choice in the response
        return response.getChoices().get(0).getMessage().getContent();
    }
}

package aiecommerce.controller;

import aiecommerce.service.Agent;
import dev.langchain4j.service.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AgentController {
    private final Agent agent;

    @GetMapping("/agent")
    public String agent(@RequestParam String sessionId,
                        @RequestParam String userMessage) {
        Result<String> result = agent.answer(sessionId, userMessage);
        return result.content();
    }
}

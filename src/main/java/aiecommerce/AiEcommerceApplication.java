package aiecommerce;

import aiecommerce.service.Agent;
import dev.langchain4j.service.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@Slf4j
@SpringBootApplication(scanBasePackages = {"aiecommerce"})
public class AiEcommerceApplication {

	@Bean
	ApplicationRunner interactiveRunner(Agent agent) {
		return args -> {
			try (Scanner scanner = new Scanner(System.in)) {
				while (true) {
					log.info("==================================================");
					log.info("User: ");
					String userQuery = scanner.nextLine();
					log.info("==================================================");

					if ("exit".equalsIgnoreCase(userQuery)) {
						break;
					}

					Result<String> agentAnswer = agent.answer("1", userQuery);
					log.info("==================================================");
					log.info("Agent: " + agentAnswer.content());
				}
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AiEcommerceApplication.class, args);
	}

}

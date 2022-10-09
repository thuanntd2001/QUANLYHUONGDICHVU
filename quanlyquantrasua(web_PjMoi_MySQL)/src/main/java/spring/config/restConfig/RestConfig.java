package spring.config.restConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class RestConfig {
	@Bean
	public WebClient webInit(){
	WebClient webClient = WebClient.builder()
    .baseUrl("http://localhost:8081")
    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
    .build();
	return webClient;
	}
}

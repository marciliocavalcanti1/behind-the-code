package br.com.softblue.bluewitter.utils;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.softblue.bluewitter.domain.usuario.Usuario;
import lombok.Data;

@Data
public class ApiGitHubService {

	private ApiGitHubService() {
	}

	private static final String URI = "https://api.github.com/users/";
	private static RestTemplate restTemplate = new RestTemplate();

	public static Usuario request(String loginUserGitHub) throws JsonParseException, JsonMappingException, IOException {
		
		ResponseEntity<String> response = restTemplate.getForEntity(URI + loginUserGitHub, String.class);
        
		if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusCode());
        }
        
		return JsonUtil.fromJson(response.getBody(), Usuario.class);
	}
}

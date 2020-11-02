package br.com.softblue.bluewitter.utils;

import org.springframework.web.client.RestTemplate;

import br.com.softblue.bluewitter.domain.usuario.Usuario;
import lombok.Data;

@Data
public class ApiGitHubService {

	private ApiGitHubService() {}
	
	private static final String URI = "https://api.github.com/users/";

	public static Usuario request(String loginUserGitHub) {
		return new RestTemplate().getForEntity(URI + loginUserGitHub, Usuario.class).getBody();
	}
}

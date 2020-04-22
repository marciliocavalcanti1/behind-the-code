package br.com.softblue.bluewitter.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.softblue.bluewitter.domain.usuario.Usuario;

public class ApiGitHub {
	
	Usuario data;
	
	public Usuario request(Usuario loginUserGitHub) {

		try {

			URL uri = new URL("https://api.github.com/users/" + loginUserGitHub);
			HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output = br.readLine();
			
			data = returnJson(output);

			conn.disconnect();
			
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		return data;
	}

	public Usuario returnJson(String msg) throws JsonParseException, JsonMappingException, IOException {

		Usuario user = new ObjectMapper().readValue(msg, Usuario.class);

		return user;
	}
}

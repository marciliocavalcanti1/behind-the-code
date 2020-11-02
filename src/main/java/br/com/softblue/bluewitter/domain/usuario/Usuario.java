package br.com.softblue.bluewitter.domain.usuario;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name = "USUARIO")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Usuario {
	
	@Id
	@JsonProperty("login")
	private String id;
	
	@JsonProperty("name")
	private String nome;
	
	@JsonProperty("avatar_url")
	private String avatar;
	
	public String getFormattedId() {
		return "@" + id;
	}
}

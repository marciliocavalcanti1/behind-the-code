package br.com.softblue.bluewitter.domain.usuario;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USUARIO")
public @Data class Usuario {
	
	@Id
	private String id;
	
	private String nome;
	
	public String getFormattedId() {
		return "@" + id;
	}

}

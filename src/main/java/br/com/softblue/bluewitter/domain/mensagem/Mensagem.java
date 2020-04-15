package br.com.softblue.bluewitter.domain.mensagem;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "MENSAGEM")
@SequenceGenerator(name = "ID_MESSAGE_SQ", sequenceName = "ID_MESSAGE_SQ", allocationSize = 1, initialValue = 1)
public class Mensagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_MESSAGE_SQ")
	private Integer id;
	
	@Column(name = "DATA_HORA")
	private LocalDateTime dataHora;
	
	private String texto;
	
}

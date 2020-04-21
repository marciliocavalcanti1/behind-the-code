package br.com.softblue.bluewitter;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.softblue.bluewitter.domain.mensagem.Mensagem;
import br.com.softblue.bluewitter.domain.mensagem.MensagemRepository;
import br.com.softblue.bluewitter.domain.usuario.Usuario;
import br.com.softblue.bluewitter.domain.usuario.UsuarioRepository;

@SpringBootTest
class BluewitterApplicationTests {

	private final MensagemRepository mensagemRepository;
	private final UsuarioRepository usuarioRepository;

	@Autowired
	BluewitterApplicationTests(MensagemRepository mensagemRepository, UsuarioRepository usuarioRepository) {
		this.mensagemRepository = mensagemRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	@Test
	void cadastrarUsuarios() {
		
		Usuario usuario1 = new Usuario();
		usuario1.setId("ctosin");
		usuario1.setNome("Carlos");
		
		usuarioRepository.save(usuario1);
		
		Usuario usuario2 = new Usuario();
		usuario2.setId("milani");
		usuario2.setNome("André");
		
		usuarioRepository.save(usuario2);
		
		Usuario usuario3 = new Usuario();
		usuario3.setId("mcavalcanti");
		usuario3.setNome("Marcílio");
		
		usuarioRepository.save(usuario3);
	}
	
	@Test
	void cadastrarMensagem() {
		
		Mensagem mensagem = new Mensagem();
		mensagem.setDataHora(LocalDateTime.now());
		mensagem.setTexto("Mensagem para fins de teste!");

		mensagemRepository.save(mensagem);
	}
}

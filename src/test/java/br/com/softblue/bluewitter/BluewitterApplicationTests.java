package br.com.softblue.bluewitter;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.softblue.bluewitter.domain.mensagem.Mensagem;
import br.com.softblue.bluewitter.domain.mensagem.MensagemRepository;

@SpringBootTest
class BluewitterApplicationTests {

	private final MensagemRepository mensagemRepository;

	@Autowired
	BluewitterApplicationTests(MensagemRepository mensagemRepository) {
		this.mensagemRepository = mensagemRepository;
	}

	@Test
	void cadastrarMensagem() {
		Mensagem mensagem = new Mensagem();
		mensagem.setDataHora(LocalDateTime.now());
		mensagem.setTexto("Mensagem para fins de teste!");

		mensagemRepository.save(mensagem);
	}
}

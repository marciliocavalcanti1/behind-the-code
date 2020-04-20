package br.com.softblue.bluewitter.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.softblue.bluewitter.domain.mensagem.Mensagem;
import br.com.softblue.bluewitter.domain.mensagem.MensagemRepository;
import br.com.softblue.bluewitter.domain.usuario.Usuario;
import br.com.softblue.bluewitter.domain.usuario.UsuarioRepository;

@Controller
@RequestMapping("/mensagem")
public class MensagemController {
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/nova")
	public String nova(Model model) {
		Mensagem mensagem = new Mensagem();
		model.addAttribute("mensagem", mensagem);
	
		List<Usuario> usuarios = usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("usuarios", usuarios);
		
		return "create-message";
	}
	
	@PostMapping(path = "/criar")
	public String criar(Mensagem mensagem) {
		if(!mensagem.getTexto().isEmpty()) {
			mensagem.setDataHora(LocalDateTime.now());
			mensagemRepository.save(mensagem);
		}
		
		return "";
	}
}

package br.com.softblue.bluewitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.softblue.bluewitter.domain.usuario.Usuario;
import br.com.softblue.bluewitter.domain.usuario.UsuarioRepository;
import br.com.softblue.bluewitter.utils.ApiGitHub;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/novo")
	public String nova(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		
		return "create-user";
	}
	
	@PostMapping(path = "/criar")
	public String criar(Usuario loginUserGitHub) throws JsonProcessingException {
		
		ApiGitHub call = new ApiGitHub();
		
		try {
			
			Usuario user = call.request(loginUserGitHub);
			
			if(user != null) {
				
				if(user.getNome() == null) {
					user.setNome(user.getId());
				}
				
				usuarioRepository.save(user);
				
				return "redirect:/mensagem/listar";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/usuario/novo";
	}
	
}

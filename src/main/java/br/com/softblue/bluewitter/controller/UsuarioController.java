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
import br.com.softblue.bluewitter.utils.ApiGitHubService;

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

		try {

			Usuario user = ApiGitHubService.request(loginUserGitHub.getId());
			
			Boolean userExist = usuarioRepository.existsById(user.getId());

			if(userExist) {
				
				System.err.println("Usuário já cadastrado na base de dados!");
				
				return "redirect:/mensagem/listar";
			}
			
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

		System.err.println("Usuário não cadastrado no Github!");

		return "redirect:/usuario/novo";
	}

}

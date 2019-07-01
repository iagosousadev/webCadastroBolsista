package br.com.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ufc.model.Aluno;
import br.com.ufc.model.Orientador;
import br.com.ufc.service.AlunoService;
import br.com.ufc.service.OrientadorService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private OrientadorService orientadorService;
	
	@RequestMapping("/cadastro")
	private ModelAndView cadastrarAluno() {
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject("aluno", new Aluno());
		List<Orientador> orientadores = orientadorService.listar();
		mv.addObject("listaorientadores", orientadores);
		return mv;
	}
	
	@RequestMapping("/salvar")
	private ModelAndView salvarAluno(@Validated Aluno aluno, BindingResult result) {
		ModelAndView mv = new ModelAndView("cadastro");
		if (result.hasErrors())
			return mv;
		mv.addObject("aluno", new Aluno());
		alunoService.cadastrar(aluno);
		mv.addObject("mensagem", "cadastro com sucesso");
		return mv;
	}
	
	@RequestMapping("/bemvindo")
	private ModelAndView bemVindo() {
		ModelAndView mv = new ModelAndView("bemvindo");
		return mv;
	}
	
	@RequestMapping("/login")
	private ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

}

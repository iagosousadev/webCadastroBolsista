package br.com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.model.Aluno;
import br.com.ufc.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public void cadastrar(Aluno aluno) {
		alunoRepository.save(aluno);
	}
	
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}

}

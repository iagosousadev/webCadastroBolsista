package br.com.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.model.Orientador;
import br.com.ufc.repository.OrientadorRepository;

@Service
public class OrientadorService {
	
	@Autowired
	private OrientadorRepository orientadorRepository;
	
	public List<Orientador> listar(){
		return orientadorRepository.findAll();
	}

}

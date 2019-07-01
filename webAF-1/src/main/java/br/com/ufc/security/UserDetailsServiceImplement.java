package br.com.ufc.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.ufc.model.Aluno;
import br.com.ufc.repository.AlunoRepository;

@Repository
@Transactional
public class UserDetailsServiceImplement implements UserDetailsService {
		
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Aluno aluno = alunoRepository.findByLogin(login);
		if(aluno == null)
			throw new UsernameNotFoundException("Aluno não encontrado!");
		return new User(aluno.getNome(), aluno.getSenha(), true, true, true, true, aluno.getAuthorities());
	}

}

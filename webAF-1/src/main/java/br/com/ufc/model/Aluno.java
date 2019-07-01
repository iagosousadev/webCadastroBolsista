package br.com.ufc.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


@Entity
public class Aluno {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long matricula;
	
	@NotBlank(message = "Preencha seu login")
	private String login;
	
	@NotBlank(message = "Informe uma senha")
	private String senha;
	
	@NotBlank(message = "Preencha seu nome")
	private String nome;
	
	@NotBlank(message= "Preencha sua bolsa")
	private String bolsa;
	
	@NotBlank(message = "Informe o seu orientador")
	private String orientador;
	
	@NotBlank(message = "Informa sua data de nascimento")
	private String datanascimento;
	
	private final Set<GrantedAuthority> authorities;

	public Aluno() {
		this.authorities = new HashSet<GrantedAuthority>();
		this.authorities.add(new SimpleGrantedAuthority("ALUNO"));
	}
	
	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBolsa() {
		return bolsa;
	}

	public void setBolsa(String bolsa) {
		this.bolsa = bolsa;
	}

	public String getOrientador() {
		return orientador;
	}

	public void setOrientador(String orientador) {
		this.orientador = orientador;
	}

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}
	
	public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }
	
	
	
	
}

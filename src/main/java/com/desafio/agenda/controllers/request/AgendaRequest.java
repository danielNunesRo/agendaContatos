package com.desafio.agenda.controllers.request;

public class AgendaRequest {
	
	private String name;
	private String telefone;
	private String nascimento;
	private String email;
	public AgendaRequest(String name, String telefone, String nascimento, String email) {
		super();
		this.name = name;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.email = email;
	}
	
	public AgendaRequest() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

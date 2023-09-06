package com.desafio.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.agenda.controllers.request.AgendaRequest;
import com.desafio.agenda.domain.Agenda;
import com.desafio.agenda.exceptions.ContatoNotFoundException;
import com.desafio.agenda.repositories.AgendaRepositories;



@Service
public class AgendaService {
	
	@Autowired
	private AgendaRepositories agendaRepository;
	
	public Agenda adicionarContato(String name, String telefone, String nascimento, String email) {
		Agenda novaAgenda = new Agenda();
		novaAgenda.setName(name);
		novaAgenda.setTelefone(telefone);
		novaAgenda.setNascimento(nascimento);
		novaAgenda.setEmail(email);
		
		return agendaRepository.save(novaAgenda);
	}
	
	public Agenda buscarContatoPorId(Long id) {
        return agendaRepository.findById(id).orElse(null);
    }
	
	public List<Agenda> findAllContatos() {
        return agendaRepository.findAll();
    }
	
	public void excluirContato(Long contatoId) {
        agendaRepository.deleteById(contatoId);
    }
	
	public Agenda atualizarContato(Long id, AgendaRequest request) throws ContatoNotFoundException {
        Optional<Agenda> optionalAgenda = agendaRepository.findById(id);

        if (optionalAgenda.isPresent()) {
            Agenda agenda = optionalAgenda.get();
            
            agenda.setName(request.getName());
            agenda.setTelefone(request.getTelefone());
            agenda.setNascimento(request.getNascimento());
            agenda.setEmail(request.getEmail());

            
            return agendaRepository.save(agenda);
        } else {
            throw new ContatoNotFoundException("Contato com ID " + id + " não encontrado.");
        }
    }
}

package com.desafio.agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.agenda.controllers.request.AgendaRequest;
import com.desafio.agenda.domain.Agenda;
import com.desafio.agenda.exceptions.ContatoNotFoundException;
import com.desafio.agenda.services.AgendaService;


@RestController
@RequestMapping(value = "/agenda")
public class AgendaController {
	
	@Autowired
	private AgendaService agendaService;
	
	@GetMapping
	public ResponseEntity<List<Agenda>> findAllContatos() {
		List<Agenda> contatos = agendaService.findAllContatos();
        return ResponseEntity.ok(contatos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Agenda> buscarContatoPorId(@PathVariable Long id) {
		Agenda contato = agendaService.buscarContatoPorId(id);
		if(contato != null) {
			return new ResponseEntity<>(contato, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	 public ResponseEntity<Agenda> adicionarContato(@RequestBody AgendaRequest request) {
	        Agenda novaAgenda = agendaService.adicionarContato(request.getName(), request.getTelefone(),request.getNascimento(), request.getEmail());
	        return new ResponseEntity<>(novaAgenda, HttpStatus.CREATED);
	    }
	
	@DeleteMapping("/{agendaId}")
    public ResponseEntity<Void> excluirContato(@PathVariable Long agendaId) {
        agendaService.excluirContato(agendaId);
        return ResponseEntity.noContent().build();
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Agenda> atualizarContato(@PathVariable Long id, @RequestBody AgendaRequest request) {
        try {
            Agenda contatoAtualizado = agendaService.atualizarContato(id, request);
            return new ResponseEntity<>(contatoAtualizado, HttpStatus.OK);
        } catch (ContatoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
}

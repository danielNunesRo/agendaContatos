package com.desafio.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.agenda.domain.Agenda;

public interface AgendaRepositories extends JpaRepository<Agenda, Long> {

}

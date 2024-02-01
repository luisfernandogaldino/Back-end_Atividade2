package com.controleTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controleTarefas.entities.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas,Long>{

}

package com.controleTarefas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleTarefas.entities.Tarefas;
import com.controleTarefas.repository.TarefasRepository;

@Service
	public class TarefasService {

		private final TarefasRepository tarefasRepository;

		@Autowired

		public TarefasService(TarefasRepository tarefasRepository) {
			this.tarefasRepository = tarefasRepository;
		}
		public  List<Tarefas> buscaTodosTarefas(){
			return tarefasRepository.findAll();
		}
		public Tarefas buscaTarefasId(Long id) {
			Optional <Tarefas> Pedidos = tarefasRepository.findById(id);
			return Pedidos.orElse(null);
		}
		public Tarefas salvaTarefas(Tarefas Tarefas){
			return tarefasRepository.save(Tarefas);
		}
		public Tarefas alterarTarefas(Long id, Tarefas alterarTarefas) {
			Optional <Tarefas> existeTarefas = tarefasRepository.findById(id);
			if (existeTarefas.isPresent()) {
				alterarTarefas.setId(id);
				return tarefasRepository.save(alterarTarefas);
			}
			return null;
		}
		public boolean apagarTarefas (Long id) {
			Optional <Tarefas> existeTarefas = tarefasRepository.findById(id);
			if (existeTarefas.isPresent()) {
				tarefasRepository.deleteById(id);
				return true;
			}
			return false;


		}
	}

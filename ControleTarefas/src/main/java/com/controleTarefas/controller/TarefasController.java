package com.controleTarefas.controller;

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

import com.controleTarefas.entities.Tarefas;
import com.controleTarefas.service.TarefasService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/tarefas")
public class TarefasController {

	private final TarefasService tarefasService;

	@Autowired
	public TarefasController(TarefasService tarefasService) {
		this.tarefasService = tarefasService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarefas> buscaTarefasControlId(@PathVariable Long id) {
		Tarefas tarefas = tarefasService.buscaTarefasId(id);
		if (tarefas != null) {
			return ResponseEntity.ok(tarefas);
		} else 
			return ResponseEntity.notFound().build();
	}
	@GetMapping
	public ResponseEntity<List<Tarefas>> buscaTodosTarefasControl() {
		List<Tarefas> Tarefas = tarefasService.buscaTodosTarefas();
		return ResponseEntity.ok(Tarefas);
	}

	@PostMapping
	public ResponseEntity<Tarefas> salvaTarefasControl(@RequestBody @Valid Tarefas tarefas) {
		Tarefas salvaTarefas = tarefasService.salvaTarefas(tarefas);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTarefas);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tarefas> alterarTarefasControl(@PathVariable Long id, @RequestBody @Valid Tarefas Tarefas) {
		Tarefas alterarTarefas = tarefasService.alterarTarefas(id, Tarefas);
		if (alterarTarefas != null) {
			return ResponseEntity.ok(Tarefas);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Tarefas> apagaTarefasControl(@PathVariable Long id) {
		boolean apagar = tarefasService.apagarTarefas(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}

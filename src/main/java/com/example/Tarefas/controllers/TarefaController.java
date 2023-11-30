package com.example.Tarefas.controllers;

import com.example.Tarefas.entities.Tarefa;
import com.example.Tarefas.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TarefaController {

    private final TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService){
        this.tarefaService=tarefaService;
    }

    @GetMapping
    public List<Tarefa>getAllTarefas(){
        return tarefaService.getAllTarefas();
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa){
        return tarefaService.createTarefa(tarefa);
    }

    @GetMapping("/{id}")
    public Tarefa getTarefaById(@PathVariable Long id) {
        return tarefaService.getTarefaById(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizartarefa(@PathVariable Long id, @RequestBody Tarefa taskDetails) {
        return tarefaService.updateTarefa(id, taskDetails);
    }

    @DeleteMapping("/{id}")
    public String deletarTarefa(@PathVariable Long id) {
        if (tarefaService.deleteTarefa(id)) {
            return "Tarefa deletada com sucesso";
        } else {
            return "Erro ao deletar a tarefa. Verifique o ID fornecido.";
        }
    }
}
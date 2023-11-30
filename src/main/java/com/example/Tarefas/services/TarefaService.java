package com.example.Tarefas.services;

import com.example.Tarefas.entities.Tarefa;
import com.example.Tarefas.repositories.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefasRepository TarefasRepository;

    @Autowired
    public TarefaService(TarefasRepository TarefasRepository) {
        this.TarefasRepository = TarefasRepository;
    }

    public List<Tarefa> getAllTarefas() {
        return TarefasRepository.findAll();
    }

    public Tarefa createTarefa(Tarefa tarefa) {
        return TarefasRepository.save(tarefa);
    }

    public Tarefa getTarefaById(Long id) {
        return TarefasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa not found with id: " + id));
    }

    public Tarefa updateTarefa(Long id, Tarefa tarefaDetails) {
        Optional<Tarefa> tarefaOptional = TarefasRepository.findById(id);
        if (tarefaOptional.isPresent()) {
            Tarefa tarefa = tarefaOptional.get();

            tarefa.setTitulo(tarefaDetails.getTitulo());
            tarefa.setDescricao(tarefaDetails.getDescricao());
            tarefa.setFinalizada(tarefaDetails.isFinalizada());

            return TarefasRepository.save(tarefa);
        } else {
            throw new RuntimeException("Tarefa not found with id: " + id);
        }
    }

    public boolean deleteTarefa(Long id) {
        Optional<Tarefa> tarefaOptional = TarefasRepository.findById(id);
        if (tarefaOptional.isPresent()) {
            TarefasRepository.delete(tarefaOptional.get());
            return true; 
            return false;
        }
    }
}

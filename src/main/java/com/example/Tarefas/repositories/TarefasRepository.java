package com.example.Tarefas.repositories;

import com.example.Tarefas.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public class TarefasRepository extends JpaRepository<Tarefa,Long> {
    
}

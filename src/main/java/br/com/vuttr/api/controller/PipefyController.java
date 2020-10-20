package br.com.vuttr.api.controller;

import br.com.vuttr.api.model.Pipefy;
import br.com.vuttr.api.repository.PipefyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pipefy")
public class PipefyController {

    @Autowired
    private PipefyRepository repository;

    @PostMapping
    public void cardDone(){
        System.out.println("-----------------------------");
        Pipefy pipefy = new Pipefy(LocalDateTime.now());
        repository.save(pipefy);
    }

    @GetMapping
    public List<Pipefy> get(){
        return repository.findAll();
    }
}

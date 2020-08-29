package br.com.vuttr.api.controller;

import br.com.vuttr.api.controller.dto.ToolsDto;
import br.com.vuttr.api.controller.form.ToolsForm;
import br.com.vuttr.api.model.Tools;
import br.com.vuttr.api.repository.ToolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/tools")
public class ToolsController {
    @Autowired
    private ToolsRepository repository;

    @GetMapping
    public Page<ToolsDto> listar(Pageable page){
        Page<Tools> tools = repository.findAll(page);
        return ToolsDto.converter(tools);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ToolsDto> cadastrar(@RequestBody @Valid ToolsForm form, UriComponentsBuilder uriBuilder){
        Tools tools = form.converter();
        repository.save(tools);
        URI uri = uriBuilder.path("/tools/{id}").buildAndExpand(tools.getId()).toUri();
        return ResponseEntity.created(uri).body(new ToolsDto(tools));
    }


}

package br.com.vuttr.api.controller;

import br.com.vuttr.api.controller.dto.ToolsDetalhesDto;
import br.com.vuttr.api.controller.dto.ToolsDto;
import br.com.vuttr.api.controller.form.ToolsForm;
import br.com.vuttr.api.model.Tools;
import br.com.vuttr.api.repository.ToolsRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/tools")
public class ToolsController {
    @Autowired
    private ToolsRepository repository;

    @GetMapping
    @ApiOperation( value = "Listar todos as feramenstas e filtar por tag")
    public Page<ToolsDto> listarTodos(@RequestParam(required = false) String tag,Pageable page){
        if(tag == null){
            Page<Tools> tools = repository.findAll(page);
            return ToolsDto.converter(tools);
        }else {
            Page<Tools> tools = repository.findByTags(tag,page);
            return ToolsDto.converter(tools);
        }

    }

    @PostMapping
    @Transactional
    public ResponseEntity<ToolsDto> cadastrar(@RequestBody @Valid ToolsForm form, UriComponentsBuilder uriBuilder){
        Tools tools = form.converter();
        repository.save(tools);
        URI uri = uriBuilder.path("/tools/{id}").buildAndExpand(tools.getId()).toUri();
        return ResponseEntity.created(uri).body(new ToolsDto(tools));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToolsDetalhesDto> detales(@PathVariable Long id){
        Optional<Tools> tools = repository.findById(id);
        if(tools.isPresent()){
            return ResponseEntity.ok(new ToolsDetalhesDto(tools.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id){
        Optional<Tools> tools = repository.findById(id);
        if (tools.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}

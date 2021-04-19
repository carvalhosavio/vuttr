package br.com.vuttr.api.controller;

import br.com.vuttr.api.controller.dto.ToolsDetalhesDto;
import br.com.vuttr.api.controller.dto.ToolsDto;
import br.com.vuttr.api.controller.form.ToolsForm;
import br.com.vuttr.api.model.Tools;
import br.com.vuttr.api.repository.ToolsRepository;
import br.com.vuttr.api.services.ToolsService;
import io.swagger.annotations.ApiOperation;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tools",produces = "application/json")
public class ToolsController {

    private final ToolsService toolsService;

    @Autowired
    public ToolsController(ToolsService toolsService){
        this.toolsService = toolsService;
    }

    @GetMapping()
    @ApiOperation( value = "Listar todos as feramenstas e filtar por tag")
    public ResponseEntity<Page<ToolsDto>> findAllTags(@RequestParam(required = false) String tag,Pageable page){
        Page<Tools> allTags = toolsService.findAllAndTags(tag,page);
        return ResponseEntity.status(HttpStatus.OK).body(ToolsDto.converter(allTags));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ToolsDto> createToosl(@RequestBody @Valid ToolsForm form, UriComponentsBuilder uriBuilder){
        if(toolsService.toolsTitleExists(form)){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Tools tools = toolsService.save(form);
        URI uri = uriBuilder.path("/tools/{id}").buildAndExpand(tools.getId()).toUri();
        return ResponseEntity.created(uri).body(new ToolsDto(tools));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToolsDetalhesDto> findById(@PathVariable Long id){
        Optional<Tools> tools = toolsService.findById(id);
        return tools.map(value -> ResponseEntity.ok(new ToolsDetalhesDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Tools> tools = toolsService.findById(id);
        if (!tools.isPresent()){
            return ResponseEntity.notFound().build();
        }
        toolsService.delete(tools.get());
        return ResponseEntity.noContent().build();
    }

}

package br.com.vuttr.api.controller;

import br.com.vuttr.api.controller.dto.ToolsDto;
import br.com.vuttr.api.model.Tools;
import br.com.vuttr.api.repository.ToolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tools")
public class ToolsController {
    @Autowired
    private ToolsRepository repository;

    @GetMapping
    public Page<ToolsDto> listar(Pageable page){
        Page<Tools> tools = repository.findAll(page);
        String teste[];
        return ToolsDto.converter(tools);
    }


}

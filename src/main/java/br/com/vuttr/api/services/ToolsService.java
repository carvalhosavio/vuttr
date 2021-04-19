package br.com.vuttr.api.services;

import br.com.vuttr.api.controller.form.ToolsForm;
import br.com.vuttr.api.model.Tools;
import br.com.vuttr.api.repository.ToolsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author savio
 */
@Service
public class ToolsService {
    private final ToolsRepository toolsRepository;

    public ToolsService(ToolsRepository toolsRepository){
        this.toolsRepository = toolsRepository;
    }

    public Page<Tools> findAllAndTags(String tag, Pageable page) {
        Page<Tools> tools;
        if(tag == null){
            tools = toolsRepository.findAll(page);
        }else {
            tools = toolsRepository.findByTags(tag, page);
        }
        return tools;
    }


    public Tools save(ToolsForm form) {
        Tools tools = form.converter();
        return toolsRepository.save(tools);
    }

    public boolean toolsTitleExists(ToolsForm form) {
        Optional<Tools> tools = toolsRepository.findByTitle(form.getTitle());
        return tools.isPresent();
    }

    public Optional<Tools> findById(Long id) {
        return toolsRepository.findById(id);
    }

    public void delete(Tools tools) {
        toolsRepository.delete(tools);
    }
}

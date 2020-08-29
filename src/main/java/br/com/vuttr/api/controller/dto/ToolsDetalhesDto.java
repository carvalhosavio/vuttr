package br.com.vuttr.api.controller.dto;

import br.com.vuttr.api.model.Tools;
import lombok.Data;

import java.util.List;

@Data
public class ToolsDetalhesDto {
    private Long id;
    private String title;
    private String link;
    private String description;
    private List<String> tags;

    public ToolsDetalhesDto(Tools tools) {
        this.id = tools.getId();
        this.title = tools.getTitle();
        this.link = tools.getLink();
        this.description = tools.getDescription();
        this.tags = tools.getTags();
    }
}

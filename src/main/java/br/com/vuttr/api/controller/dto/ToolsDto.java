package br.com.vuttr.api.controller.dto;

import br.com.vuttr.api.model.Tools;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class ToolsDto {
    private Long id;
    private String title;
    private String link;
    private String description;
    private List<String> tags;

    public ToolsDto(Tools tools){
        this.id = tools.getId();
        this.title = tools.getTitle();
        this.link = tools.getLink();
        this.description = tools.getDescription();
        this.tags = tools.getTags();
    }

    public static Page<ToolsDto> converter(Page<Tools> tools) {
        return tools.map(ToolsDto::new);
    }
}

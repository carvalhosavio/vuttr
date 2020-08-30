package br.com.vuttr.api.controller.dto;

import br.com.vuttr.api.model.Tools;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ToolsDetalhesDto {
    @Getter
    private Long id;
    @Getter
    private String title;
    @Getter
    private String link;
    @Getter
    private String description;
    @Getter
    private List<String> tags;

    public ToolsDetalhesDto(Tools tools) {
        this.id = tools.getId();
        this.title = tools.getTitle();
        this.link = tools.getLink();
        this.description = tools.getDescription();
        this.tags = tools.getTags();
    }
}

package br.com.vuttr.api.controller.dto;

import br.com.vuttr.api.model.Tools;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ToolsDto {
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

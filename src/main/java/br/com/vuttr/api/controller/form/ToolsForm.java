package br.com.vuttr.api.controller.form;

import br.com.vuttr.api.model.Tools;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ToolsForm {

    @NotEmpty @NotNull
    private String title;
    @NotEmpty @NotNull
    private String link;
    @NotEmpty @NotNull
    private String description;
    @NotEmpty @NotNull
    private List<String> tags;

    public Tools converter() {
        return new Tools(this.title,this.link,this.description,this.tags);
    }
}

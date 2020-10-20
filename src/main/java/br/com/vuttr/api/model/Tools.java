package br.com.vuttr.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tools")
public class Tools {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String link;
    @Column(nullable = false)
    private String description;
    @ElementCollection
    @Column(nullable = false)
    private List<String> tags;

    public Tools(String title, String link, String description, List<String> tags) {
        super();
        this.title = title;
        this.link = link;
        this.description = description;
        this.tags = tags;
    }

}

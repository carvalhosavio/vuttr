package br.com.vuttr.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tools")
public class Tools {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String link;
    @Column
    private String description;
    @Column
    private String tags;
}

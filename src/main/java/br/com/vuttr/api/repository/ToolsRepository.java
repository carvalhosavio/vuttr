package br.com.vuttr.api.repository;

import br.com.vuttr.api.model.Tools;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolsRepository extends JpaRepository<Tools,Long> {
    Page<Tools> findByTags(String tag, Pageable page);
}

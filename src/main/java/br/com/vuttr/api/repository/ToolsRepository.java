package br.com.vuttr.api.repository;

import br.com.vuttr.api.model.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolsRepository extends JpaRepository<Tools,Long> {
}

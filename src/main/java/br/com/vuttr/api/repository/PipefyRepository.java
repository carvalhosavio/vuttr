package br.com.vuttr.api.repository;

import br.com.vuttr.api.model.Pipefy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PipefyRepository extends JpaRepository<Pipefy, Long> {
}

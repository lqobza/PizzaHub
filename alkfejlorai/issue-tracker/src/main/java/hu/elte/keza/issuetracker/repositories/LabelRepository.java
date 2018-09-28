package hu.elte.keza.issuetracker.repositories;

import hu.elte.keza.issuetracker.entities.Label;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends CrudRepository<Label, Long> {
    
}

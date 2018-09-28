package hu.elte.keza.issuetracker.repositories;

import hu.elte.keza.issuetracker.entities.Issue;
import hu.elte.keza.issuetracker.entities.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Long> {
    List<Issue> findAllByCreatedBy(User user);
}

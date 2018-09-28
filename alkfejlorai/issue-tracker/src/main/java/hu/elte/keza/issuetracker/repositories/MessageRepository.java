package hu.elte.keza.issuetracker.repositories;

import hu.elte.keza.issuetracker.entities.Message;
import hu.elte.keza.issuetracker.entities.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findAllByCreatedBy(User user);
}

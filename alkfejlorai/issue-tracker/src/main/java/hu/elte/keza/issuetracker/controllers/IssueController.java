package hu.elte.keza.issuetracker.controllers;

import hu.elte.keza.issuetracker.entities.Issue;
import hu.elte.keza.issuetracker.entities.Label;
import hu.elte.keza.issuetracker.entities.Message;
import hu.elte.keza.issuetracker.repositories.LabelRepository;
import hu.elte.keza.issuetracker.repositories.MessageRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("issues")
@RestController
public class IssueController extends BaseController<Issue, CrudRepository<Issue, Long>> {
    
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private LabelRepository labelRepository;
    
    @GetMapping("/{id}/messages")
    public ResponseEntity<Iterable<Message>> messages(@PathVariable Long id) {
        Optional<Issue> optionalIssue = getEntity(id);
        if(optionalIssue.isPresent()) {
            return ResponseEntity.ok(optionalIssue.get().getMessages());
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/{id}/messages")
    public ResponseEntity<Message> newMessage(@PathVariable Long id, @RequestBody Message message) {
        Optional<Issue> optionalIssue = getEntity(id);
        if(optionalIssue.isPresent()) {
            Issue issue = optionalIssue.get();
            message.setIssue(issue);
            return ResponseEntity.ok(messageRepository.save(message));
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/{id}/labels")
    public ResponseEntity<Iterable<Label>> labels(@PathVariable Long id) {
        Optional<Issue> optionalIssue = getEntity(id);
        if(optionalIssue.isPresent()) {
            return ResponseEntity.ok(optionalIssue.get().getLabels());
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/{id}/labels")
    public ResponseEntity<Label> addLabel(@PathVariable Long id, @RequestBody Label label) {
        Optional<Issue> optionalIssue = getEntity(id);
        if(optionalIssue.isPresent()) {
            Label newLabel = labelRepository.save(label);
            optionalIssue.get().getLabels().add(newLabel);
            saveEntity(optionalIssue.get());
            return ResponseEntity.ok(newLabel);
        }
        return ResponseEntity.notFound().build();
    }
    
    
}

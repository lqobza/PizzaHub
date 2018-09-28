package hu.elte.keza.issuetracker.controllers;

import hu.elte.keza.issuetracker.entities.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("messages")
@RestController
public class MessageController extends BaseController<Message, CrudRepository<Message, Long>> {
    
    
}
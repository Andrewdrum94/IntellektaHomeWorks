package com.intellekta.controller;

import com.intellekta.jpa.entity.Message;
import com.intellekta.jpa.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MessageController {

    private final MessageRepo messageRepo;
    private String name = "User";
    private String filter;

    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String sendLogin(@RequestParam String name) {
        this.name = name;
        return "redirect:/messages";
    }

    @GetMapping("/messages")
    public String getMessages(Map<String, Object> model) {
        model.put("name", name);
        model.put("messages", messageRepo.findAll());
        return "messages";
    }

    @PostMapping("/messages")
    public String add(@RequestParam("text") String text, @RequestParam("tag") String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "redirect:/messages";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;
        this.filter = filter;

        if (messageRepo.findByTag(filter).isEmpty()) {
            model.put("message", "No such tag exists");
            model.put("cond", true);
            return "messages";
        }
        else if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        }
        else {
            messages = messageRepo.findAll();
        }
        model.put("messages", messages);
        return "filter";
    }

    @GetMapping("/filter")
    public String getFilteredMessages(Map<String, Object> model) {
        System.out.println(filter);
            model.put("messages", messageRepo.findByTag(filter));
        filter = "";
        return "filter";
    }


}

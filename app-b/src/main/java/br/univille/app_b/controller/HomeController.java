package br.univille.app_b.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;
import io.dapr.client.domain.CloudEvent;

import io.dapr.Topic;



@RestController
@RequestMapping("/api")
public class HomeController {
    
    //  ******** APPLICAÇÃO B  ************

    @GetMapping()
    public ResponseEntity index() {
        System.out.println("Hello from App B");
        return ResponseEntity.ok().body("Hello from App B");
    }

    @Topic(pubsubName = "pubsub-dapr", name = "topicdapr")
    @PostMapping(path = "/startbasync", consumes = MediaType.ALL_VALUE)
    public ResponseEntity startBAsync(@RequestBody(required = false) 
                                        CloudEvent<String> cloudEvent){

        System.out.println("App B has started!");
        var id = cloudEvent.getId();
        var mensagem = cloudEvent.getData();

        System.out.println("MENSAGEM = " + mensagem);
        System.out.println("ID DA MENSAGEM = " + id);

        return ResponseEntity.ok().build();
    }
}

package br.univille.app_a.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import io.dapr.client.domain.HttpExtension;


@RestController
@RequestMapping("/api")
public class HomeController {

    //  ******** APPLICAÇÃO A  ************

    @GetMapping()
    public ResponseEntity index() {
     
        try {
            DaprClient daprClient = new DaprClientBuilder().build();
            daprClient.invokeMethod("app-b", "/api", null, HttpExtension.GET).block();
        } catch (Exception e){
            // TODO: Exception handling
        }

        return ResponseEntity.ok().body("Hello from App A");
    }
}

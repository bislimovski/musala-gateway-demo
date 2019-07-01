package com.musala.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "<p>Welcome to my musala-gateway-demo app</p>" +
                "<br />" +
                "<p>Please import \'MusalaGateway.postman_collection.json\' in Postman</p>" +
                "<br />" +
                "<p>Routes:</p>" +
                "<ul>" +
                "<li>GET    - http://localhost:8090/gateways</li>" +
                "<li>GET    - http://localhost:8090/gateways/1</li>" +
                "<li>POST   - http://localhost:8090/gateways</li>" +
                "<li>PUT    - http://localhost:8090/gateways/1</li>" +
                "<li>DELETE - http://localhost:8090/gateways/1</li>" +
                "<li></li>" +
                "<li>GET    - http://localhost:8090/gateways/1/peripherals</li>" +
                "<li>GET    - http://localhost:8090/gateways/1/peripherals/1</li>" +
                "<li>POST   - http://localhost:8090/gateways/1/peripherals</li>" +
                "<li>PUT    - http://localhost:8090/gateways/1/peripherals/1</li>" +
                "<li>DELETE - http://localhost:8090/gateways/1/peripherals/1</li>" +
                "</ul>";
    }
}

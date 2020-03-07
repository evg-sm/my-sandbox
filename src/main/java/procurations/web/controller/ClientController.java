package procurations.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import procurations.model.Client;
import procurations.service.ClientService;

@RestController
@RequestMapping(value = ClientController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    static final String REST_URL = "/client";

    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public Client get(@PathVariable int id) {
        return clientService.get(id);
    }
}

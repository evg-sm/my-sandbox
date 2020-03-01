package procurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import procurations.dto.Client;
import procurations.repository.ClientRepository;

@RestController
@RequestMapping(value = ApiController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    static final String REST_URL = "/client";

    @Autowired
    ClientRepository repository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/fetch/{id}")
    public Client getMethod(@PathVariable int id) {
        return repository.getSingleClientById(id);
    }
}

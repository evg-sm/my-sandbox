package procurations.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import procurations.model.Procuration;
import procurations.service.ProcurationService;

@RestController
@RequestMapping(value = ProcurationController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProcurationController {

    static final String REST_URL = "/procuration";

    @Autowired
    ProcurationService procurationService;

    @PostMapping("/create/byType/{type}")
    public Procuration createByType(@PathVariable int type) {
        return procurationService.create(type);
    }

    @GetMapping("/get/{id}")
    public Procuration get(@PathVariable int id) {
        return procurationService.get(id);
    }
}

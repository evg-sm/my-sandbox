package procurations.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import procurations.model.ProcurationDto;
import procurations.model.Procuration;
import procurations.service.ProcurationService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = ProcurationController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProcurationController {

    static final String REST_URL = "/procuration";

    @Autowired
    ProcurationService procurationService;

    @PostMapping("/create")
    public Procuration createByType(@Valid @RequestBody ProcurationDto procurationDto) {
        return procurationService.save(procurationDto);
    }

    @GetMapping("/{id}")
    public Procuration get(@PathVariable int id) {
        return procurationService.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        procurationService.delete(id);
    }
}

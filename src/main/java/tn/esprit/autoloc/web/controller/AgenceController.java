package tn.esprit.autoloc.web.controller;

import tn.esprit.autoloc.entities.Agence;
import tn.esprit.autoloc.service.AgenceService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {

    private final AgenceService agenceService;

    public AgenceController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @PostMapping
    public ResponseEntity<Agence> create(@RequestBody Agence agence) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agenceService.create(agence));
    }

    @GetMapping
    public ResponseEntity<List<Agence>> getAll() {
        return ResponseEntity.ok(agenceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> getById(@PathVariable Long id) {
        return ResponseEntity.ok(agenceService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agence> update(@PathVariable Long id, @RequestBody Agence agence) {
        return ResponseEntity.ok(agenceService.update(id, agence));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agenceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}



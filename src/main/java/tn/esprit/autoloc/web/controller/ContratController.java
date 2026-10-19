package tn.esprit.autoloc.web.controller;

import tn.esprit.autoloc.entities.Contrat;
import tn.esprit.autoloc.service.ContratService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    private final ContratService contratService;

    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    @PostMapping
    public ResponseEntity<Contrat> create(@RequestBody Contrat contrat) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.create(contrat));
    }

    @GetMapping
    public ResponseEntity<List<Contrat>> getAll() {
        return ResponseEntity.ok(contratService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> getById(@PathVariable Long id) {
        return ResponseEntity.ok(contratService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrat> update(@PathVariable Long id, @RequestBody Contrat contrat) {
        return ResponseEntity.ok(contratService.update(id, contrat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contratService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

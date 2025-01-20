package tn.esprit.tp1spring.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1spring.Entity.Foyer;
import tn.esprit.tp1spring.Entity.Universite;
import tn.esprit.tp1spring.Service.Interfaces.IUniversite;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/universite")
@AllArgsConstructor
public class UniversiteController {

    IUniversite UniversiteService;

    @GetMapping("showAll")
    public List<Universite> retrieveAllUniversities() {
        return UniversiteService.retrieveAllUniversities();
    }

    @PostMapping("add")
    public Universite addUniversite(@RequestBody Universite u) {
        return UniversiteService.addUniversite(u);
    }

    @PutMapping("update")
    public Universite updateUniversite(@RequestBody Universite u) {
        return UniversiteService.updateUniversite(u);
    }

    @DeleteMapping("delete/{idUniversite}")
    public void removeUniversite(@PathVariable long idUniversite) {
        UniversiteService.removeUniversite(idUniversite);
    }

    @GetMapping("get/{idUniversite}")
    public Universite retrieveUniversite(@PathVariable long idUniversite) {
        return UniversiteService.retrieveUniversite(idUniversite);
    }

    @PostMapping("affecterFoyerAUniversite")
    public Universite affecterFoyerAUniversite(@RequestBody Map<String, Object> request) {
        long idFoyer = ((Number) request.get("idFoyer")).longValue();
        String nomuniversite = (String) request.get("nomuniversite");
        return UniversiteService.affecterFoyerAUniversite(idFoyer, nomuniversite);
    }

    @PostMapping("desaffecterFoyerAUniversite")
    public Universite desaffecterFoyerAUniversite(@RequestBody Map<String, Long> request) {
        long idUniversite = request.get("idUniversite");
        return UniversiteService.desaffecterFoyerAUniversite(idUniversite);
    }
}
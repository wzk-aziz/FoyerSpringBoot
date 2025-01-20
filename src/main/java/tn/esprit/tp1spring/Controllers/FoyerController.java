package tn.esprit.tp1spring.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1spring.Entity.Foyer;
import tn.esprit.tp1spring.Service.Interfaces.IFoyer;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/foyer")
@AllArgsConstructor
public class FoyerController {

    IFoyer FoyerService;

    @GetMapping("showAll")
    public List<Foyer> retrieveFoyers() {
        return FoyerService.retrieveAllFoyers();
    }

    @PostMapping("add")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return FoyerService.addFoyer(f);
    }

    @PutMapping("update")
    public Foyer updateFoyer(@RequestBody Foyer f) {
        return FoyerService.updateFoyer(f);
    }

    @DeleteMapping("delete/{idFoyer}")
    public void removeFoyer(@PathVariable long idFoyer) {
        FoyerService.removeFoyer(idFoyer);
    }

    @GetMapping("get/{idFoyer}")
    public Foyer retrieveFoyer(@PathVariable long idFoyer) {
        return FoyerService.retrieveFoyer(idFoyer);
    }

    @PostMapping("addAndAssignToUniversity")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @RequestParam String nomuniversite) {
        return FoyerService.ajouterFoyerEtAffecterAUniversite(foyer, nomuniversite);
    }
}
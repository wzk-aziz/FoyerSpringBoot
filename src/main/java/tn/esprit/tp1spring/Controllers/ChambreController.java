package tn.esprit.tp1spring.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1spring.Entity.Chambre;
import tn.esprit.tp1spring.Entity.TypeChambre;
import tn.esprit.tp1spring.Service.Interfaces.IChambre;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/chambre")
@AllArgsConstructor
public class ChambreController {

    IChambre ChambreService;

    @PostMapping("add")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return ChambreService.addChambre(chambre);
    }

    @PutMapping("update")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return ChambreService.updateChambre(chambre);
    }

    @DeleteMapping("delete/{idChambre}")
    public void removeChambre(@PathVariable long idChambre) {
        ChambreService.removeChambre(idChambre);
    }

    @GetMapping("get/{idChambre}")
    public Chambre retrieveChambre(@PathVariable long idChambre) {
        return ChambreService.retrieveChambre(idChambre);
    }

    @GetMapping("getByUniversity/{nomUniversite}")
    public List<Chambre> GetChambresParNomUniversité(@PathVariable String nomUniversite) {
        return ChambreService.GetChambresParNomUniversite(nomUniversite);
    }

    @GetMapping("showAll")
    public List<Chambre> retrieveChambres() {
        return ChambreService.retrieveAllChambres();
    }

    @GetMapping("getByBlocAndType")
    public List<Chambre> getChambresParBlocEtType(@RequestParam long idBloc, @RequestParam TypeChambre typeC) {
        return ChambreService.getChambresParBlocEtType(idBloc, typeC);
    }

    @GetMapping("getNonReservedByUniversiteAndType")
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(@RequestParam String nomUniversite, @RequestParam TypeChambre typeC) {
        return ChambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, typeC);
    }


    @GetMapping("/unreserved")
    public List<Chambre> getUnreservedChambresForCurrentYear() {
        return ChambreService.getUnreservedChambresForCurrentYear();
    }

}
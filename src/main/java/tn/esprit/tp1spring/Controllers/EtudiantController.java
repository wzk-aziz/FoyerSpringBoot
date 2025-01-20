package tn.esprit.tp1spring.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1spring.Entity.Etudiant;
import tn.esprit.tp1spring.Service.Interfaces.IEtudiant;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/etudiant")
@AllArgsConstructor
public class EtudiantController {

    IEtudiant EtudiantService;

    @PostMapping("add")
    public List<Etudiant> addEtudiant(@RequestBody List<Etudiant> etudiants){
        return EtudiantService.addEtudiants(etudiants);
    }

    @PutMapping("update")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        return EtudiantService.updateEtudiant(etudiant);
    }

    @DeleteMapping("delete/{idEtudiant}")
    public void removeEtudiant(@PathVariable long idEtudiant){
        EtudiantService.removeEtudiant(idEtudiant);
    }

    @GetMapping("get/{idEtudiant}")
    public Etudiant retrieveEtudiant(@PathVariable long idEtudiant){
        return EtudiantService.retrieveEtudiant(idEtudiant);
    }

    @GetMapping("showAll")
    public List<Etudiant> retrieveEtudiants(){
        return EtudiantService.retrieveAllEtudiants();
    }
}
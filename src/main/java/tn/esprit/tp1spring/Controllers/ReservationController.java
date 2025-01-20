package tn.esprit.tp1spring.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1spring.Entity.Reservation;
import tn.esprit.tp1spring.Service.Interfaces.IReservation;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/reservation")
@AllArgsConstructor
public class ReservationController {

    IReservation ReservationService;

    @GetMapping("showAll")
    public List<Reservation> retrieveAllReservations(){
        return ReservationService.retrieveAllReservation();
    }

    @PostMapping("add")
    public Reservation addReservation(@RequestBody Reservation r){
        return ReservationService.addReservation(r);
    }

    @PutMapping("update")
    public Reservation updateReservation(@RequestBody Reservation r){
        return ReservationService.updateReservation(r);
    }

    @DeleteMapping("delete/{idReservation}")
    public void removeReservation(@PathVariable long idReservation){
        ReservationService.removeReservation(String.valueOf(idReservation));
    }

    @GetMapping("get/{idReservation}")
    public Reservation retrieveReservation(@PathVariable long idReservation){
        return ReservationService.retrieveReservation(String.valueOf(idReservation));
    }

    @PostMapping("add_res_advanced")
    public Reservation ajouterReservation(@RequestBody Map<String, Long> request) {
        long idBloc = request.get("idBloc");
        long cin = request.get("cin");
        return ReservationService.ajouterReservation(idBloc, cin);
    }

    @PostMapping("cancel_res")
    public Reservation annulerReservation(@RequestBody long cin) {
        return ReservationService.annulerReservation(cin);
    }

    @GetMapping("getByAnneeUniversitaireEtNomUniversite")
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(@RequestParam Date anneeUniversitaire, @RequestParam String nomUniversite) {
        return ReservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire, nomUniversite);
    }
}
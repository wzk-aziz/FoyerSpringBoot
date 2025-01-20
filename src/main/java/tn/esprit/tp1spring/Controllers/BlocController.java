package tn.esprit.tp1spring.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1spring.Entity.Bloc;
import tn.esprit.tp1spring.Service.Interfaces.IBloc;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/bloc")
@AllArgsConstructor
public class BlocController {

    IBloc BlocService;

    @PostMapping("add")
    public Bloc ajouterBloc(@RequestBody Bloc bloc) {
        return BlocService.ajouterBloc(bloc);
    }

    @PutMapping("update")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return BlocService.updateBloc(bloc);
    }

    @DeleteMapping("delete/{idBloc}")
    public void removeBloc(@PathVariable long idBloc) {
        BlocService.removeBloc(idBloc);
    }

    @GetMapping("get/{idBloc}")
    public Bloc retrieveBloc(@PathVariable long idBloc) {
        return BlocService.retrieveBloc(idBloc);
    }

    @GetMapping("showAll")
    public List<Bloc> retrieveBlocs() {
        return BlocService.retrieveBlocs();
    }

    @PostMapping("affecterChambresABloc")
    public Bloc affecterChambresABloc(@RequestBody Map<String, Object> request) {
        List<Long> numChambres = (List<Long>) request.get("numChambres");
        long idBloc = ((Number) request.get("idBloc")).longValue();
        return BlocService.affecterChambresABloc(numChambres, idBloc);
    }
}
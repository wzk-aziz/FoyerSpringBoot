package tn.esprit.tp1spring.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1spring.Entity.Bloc;
import tn.esprit.tp1spring.Entity.Chambre;
import tn.esprit.tp1spring.Repository.BlocRepo;
import tn.esprit.tp1spring.Repository.ChambreRepo;
import tn.esprit.tp1spring.Service.Interfaces.IBloc;

import java.util.List;

@Service
@AllArgsConstructor


public class BlocService implements IBloc {

    BlocRepo blocRepo;
    ChambreRepo ChambreRepo;


    @Override
    public Bloc ajouterBloc(Bloc bloc) {
    return blocRepo.save(bloc);
}

    @Override
    public java.util.List<Bloc> retrieveBlocs() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepo.findById(idBloc).get();
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepo.deleteById(idBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) {
        Bloc bloc = blocRepo.findById(idBloc).orElseThrow(() -> new RuntimeException("Bloc non trouvé"));
        List<Chambre> chambres = ChambreRepo.findAllByNumeroChambreIn(numChambres);
        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }
        ChambreRepo.saveAll(chambres);
        return bloc;
    }

}

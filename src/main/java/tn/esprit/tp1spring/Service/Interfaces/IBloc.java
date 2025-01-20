package tn.esprit.tp1spring.Service.Interfaces;

import tn.esprit.tp1spring.Entity.Bloc;

import java.util.List;

public interface IBloc {
    Bloc ajouterBloc(Bloc bloc);
    List<Bloc> retrieveBlocs();
    Bloc updateBloc (Bloc bloc);
    Bloc retrieveBloc (long idBloc);
    void removeBloc (long idBloc);
    Bloc affecterChambresABloc(List<Long> numChambres, long idBloc);
}

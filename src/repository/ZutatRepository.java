package repository;

import model.Zutat;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ZutatRepository implements CrudRepo<String, Zutat>{

    private final List<Zutat> alleZutaten = new ArrayList<>();

    @Override
    public void add(Zutat entity) {
        this.alleZutaten.add(entity);
    }

    @Override
    public void delete(Zutat entity) {
        this.alleZutaten.remove(entity);
    }

    @Override
    public void update(String name, Zutat newEntity) {
        for(Zutat zutat: alleZutaten){
            if(zutat.getName().equals(name)){
                zutat = newEntity;
                break;
            }
        }
    }

    public List<Zutat> filternNachMenge(int newMenge){
        Predicate<Zutat> byMenge = zutat -> zutat.getMenge() > newMenge;
        return alleZutaten.stream().filter(byMenge).collect(Collectors.toList());
    }

    public void printAllZutaten(){
        for(Zutat zutat: alleZutaten){
            System.out.println(zutat.getName()+" "+zutat.getPreis()+" "+zutat.getMenge());
        }
    }
}

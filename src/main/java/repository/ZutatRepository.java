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
        if(newEntity.getPreis() > 0 && newEntity.getPreis() <= 100
                && newEntity.getMenge() >= 1 && newEntity.getMenge() <= 100) {
            for (Zutat zutat : alleZutaten) {
                if (zutat.getName().equals(name)) {
                    zutat.setMenge(newEntity.getMenge());
                    zutat.setPreis(newEntity.getPreis());
                    break;
                }
            }
        }
        else {
            System.out.println("Your update was not possible due to not respecting the constraints");
        }
    }

    public List<Zutat> filternNachMenge(int newMenge){
        Predicate<Zutat> byMenge = zutat -> zutat.getMenge() > newMenge;
        return alleZutaten.stream().filter(byMenge).collect(Collectors.toList());
    }

    public List<Zutat> rabattEinstellen(double prozent) {
        if (prozent > 0 && prozent <= 100) {
            for(Zutat zutat: alleZutaten){
                var copyProzent = prozent;
                var preis = zutat.getPreis();
                if(preis <= 20){
                    copyProzent /= 4;
                    setNeuerPreis(copyProzent, zutat, preis);
                } else if (preis > 20 && preis <= 30) {
                    copyProzent /= 3;
                    setNeuerPreis(copyProzent, zutat, preis);
                } else if (preis > 30 && preis <= 40) {
                    copyProzent /= 2;
                    setNeuerPreis(copyProzent, zutat, preis);
                } else if (preis > 40) {
                    setNeuerPreis(copyProzent, zutat, preis);
                }
            }
        }
        else {
            System.out.println("Der Prozent des Rabatts muss zwischen 0 und 100 sein.");
        }
        return alleZutaten;
    }

    private static void setNeuerPreis(double prozent, Zutat zutat, double preis) {
        preis = (preis * prozent) / 100;
        zutat.setPreis(zutat.getPreis() - preis);
        System.out.println(zutat.getPreis());
    }

    public void printAllZutaten(){
        for(Zutat zutat: alleZutaten){
            System.out.println(zutat.getName()+" "+zutat.getPreis()+" "+zutat.getMenge());
        }
    }

    public List<Zutat> getAlleZutaten() {
        return alleZutaten;
    }
}

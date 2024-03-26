package repository;

import model.Speise;
import model.Zutat;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SpeiseRepository implements CrudRepo<Integer, Speise>{

    private final List<Speise> alleSpeisen = new ArrayList<>();

    public List<Speise> getAlleSpeisen() {
        return alleSpeisen;
    }

    @Override
    public void add(Speise entity) {
        this.alleSpeisen.add(entity);
    }

    @Override
    public void delete(Speise entity) {
        this.alleSpeisen.remove(entity);
    }

    @Override
    public void update(Integer id, Speise newEntity) {
        for(Speise speise: alleSpeisen){
            if(speise.getId() == id) {
                speise = newEntity;
                break;
            }
        }
    }

    public List<Speise> anzeigenNachZutat(Zutat newZutat){
        List<Speise> filteredSpeisen = new ArrayList<>();
        for(Speise speise: alleSpeisen){
            for(Zutat zutat: speise.getZutaten()){
                if(zutat.getName().equals(newZutat.getName()))
                    filteredSpeisen.add(speise);
            }
        }
        return filteredSpeisen;
    }

    public void printAllSpeisen(){
        for(Speise speise: alleSpeisen){
            System.out.println(speise.getId()+" "+speise.getName());
            for(Zutat zutat: speise.getZutaten()){
                System.out.println(zutat.getName()+" "+zutat.getPreis()+" "+zutat.getMenge());
            }
        }
    }
}

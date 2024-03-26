package model;

import java.util.ArrayList;
import java.util.List;

public class Speise {
    private int id;
    private String name;
    List<Zutat> zutaten;

    public Speise(int id, String name) {
        this.id = id;
        this.name = name;
        this.zutaten = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Zutat> getZutaten() {
        return zutaten;
    }

    public void setZutaten(List<Zutat> zutaten) {
        this.zutaten = zutaten;
    }
}

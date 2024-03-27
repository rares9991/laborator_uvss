package model;

public class Zutat {
    private String name;
    private double preis;
    private int menge;

    public Zutat(String name, double preis, int menge) {
        this.name = name;
        this.preis = preis;
        this.menge = menge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }
}

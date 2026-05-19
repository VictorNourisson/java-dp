package fr.sdv.builder;

import java.util.ArrayList;
import java.util.List;

public class Produit {

    private String nom;

    private Grade grade;

    private Categorie categorie;

    private Marque marque;

    private List<Ingredient> ingredients = new ArrayList<>();

    private List<Additif> additifs = new ArrayList<>();

    private List<Allergene> allergenes = new ArrayList<>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Additif> getAdditifs() {
        return additifs;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }
}

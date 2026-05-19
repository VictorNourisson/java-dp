package fr.sdv.builder;

public class ProduitBuilder {

    private Produit produit = new Produit();

    public ProduitBuilder avecNom(String nom) {
        produit.setNom(nom);
        return this;
    }

    public ProduitBuilder avecGrade(Grade grade) {
        produit.setGrade(grade);
        return this;
    }

    public ProduitBuilder avecCategorie(String nom) {
        produit.setCategorie(new Categorie(nom));
        return this;
    }

    public ProduitBuilder avecMarque(String nom) {
        produit.setMarque(new Marque(nom));
        return this;
    }

    public ProduitBuilder ajouterIngredient(String nom, double qteMilligrammes) {
        produit.getIngredients().add(new Ingredient(nom, qteMilligrammes));
        return this;
    }

    public ProduitBuilder ajouterAdditif(String nom, double qteMilligrammes) {
        produit.getAdditifs().add(new Additif(nom, qteMilligrammes));
        return this;
    }

    public ProduitBuilder ajouterAllergene(String nom, double qteMilligrammes) {
        produit.getAllergenes().add(new Allergene(nom, qteMilligrammes));
        return this;
    }

    public Produit build() {
        if (produit.getNom() == null || produit.getNom().isBlank()) {
            throw new IllegalStateException("Le nom du produit est obligatoire");
        }
        if (produit.getGrade() == null) {
            throw new IllegalStateException("Le grade du produit est obligatoire");
        }
        if (produit.getCategorie() == null) {
            throw new IllegalStateException("La catégorie du produit est obligatoire");
        }
        if (produit.getMarque() == null) {
            throw new IllegalStateException("La marque du produit est obligatoire");
        }
        return produit;
    }
}

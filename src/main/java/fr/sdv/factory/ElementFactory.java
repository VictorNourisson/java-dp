package fr.sdv.factory;

public class ElementFactory {

    public Element creerElement(TypeElement typeElement, String nom, double valeur, Unite unite) {
        switch (typeElement) {
            case INGREDIENT:
                return new Ingredient(nom, valeur, unite);
            case ALLERGENE:
                return new Allergene(nom, valeur, unite);
            case ADDITIF:
                return new Additif(nom, valeur, unite);
            default:
                throw new IllegalArgumentException("Type d'élément non pris en charge");
        }
    }
}

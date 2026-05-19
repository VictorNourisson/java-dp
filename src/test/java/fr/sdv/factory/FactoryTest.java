package fr.sdv.factory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FactoryTest {

    private static final double DELTA = 0.0000001;

    @Test
    public void testCreerIngredient() {
        ElementFactory factory = new ElementFactory();
        Element element = factory.creerElement(TypeElement.INGREDIENT, "Farine", 200.0, Unite.MILLI_GRAMMES);

        assertTrue(element instanceof Ingredient);
        assertEquals("Farine", element.getNom());
        assertEquals(200.0, element.getValeur(), DELTA);
        assertEquals(Unite.MILLI_GRAMMES, element.getUnite());
    }

    @Test
    public void testCreerAllergene() {
        ElementFactory factory = new ElementFactory();
        Element element = factory.creerElement(TypeElement.ALLERGENE, "Gluten", 12.5, Unite.MILLI_GRAMMES);

        assertTrue(element instanceof Allergene);
        assertEquals("Gluten", element.getNom());
        assertEquals(12.5, element.getValeur(), DELTA);
        assertEquals(Unite.MILLI_GRAMMES, element.getUnite());
    }

    @Test
    public void testCreerAdditif() {
        ElementFactory factory = new ElementFactory();
        Element element = factory.creerElement(TypeElement.ADDITIF, "E100", 30.0, Unite.MICRO_GRAMMES);

        assertTrue(element instanceof Additif);
        assertEquals("E100", element.getNom());
        assertEquals(30.0, element.getValeur(), DELTA);
        assertEquals(Unite.MICRO_GRAMMES, element.getUnite());
    }
}

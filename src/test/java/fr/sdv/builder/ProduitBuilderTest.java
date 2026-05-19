package fr.sdv.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProduitBuilderTest {

    private static final double DELTA = 0.0000001;

    @Test
    public void testBuildProduitCasNominal() {
        Produit produit = new ProduitBuilder()
                .avecNom("Céréales")
                .avecGrade(Grade.B)
                .avecCategorie("Petit déjeuner")
                .avecMarque("BioFood")
                .ajouterIngredient("Blé", 1500.0)
                .ajouterIngredient("Sucre", 300.0)
                .ajouterAdditif("E100", 12.0)
                .ajouterAllergene("Gluten", 50.0)
                .build();

        assertNotNull(produit);
        assertEquals("Céréales", produit.getNom());
        assertEquals(Grade.B, produit.getGrade());
        assertEquals("Petit déjeuner", produit.getCategorie().getNom());
        assertEquals("BioFood", produit.getMarque().getNom());
        assertEquals(2, produit.getIngredients().size());
        assertEquals(1, produit.getAdditifs().size());
        assertEquals(1, produit.getAllergenes().size());
        assertEquals("Blé", produit.getIngredients().get(0).getNom());
        assertEquals(1500.0, produit.getIngredients().get(0).getQteMilligrammes(), DELTA);
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildSansNom() {
        new ProduitBuilder()
                .avecGrade(Grade.A)
                .avecCategorie("Boisson")
                .avecMarque("Marque")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildSansGrade() {
        new ProduitBuilder()
                .avecNom("Jus")
                .avecCategorie("Boisson")
                .avecMarque("Marque")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildSansCategorie() {
        new ProduitBuilder()
                .avecNom("Jus")
                .avecGrade(Grade.A)
                .avecMarque("Marque")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildSansMarque() {
        new ProduitBuilder()
                .avecNom("Jus")
                .avecGrade(Grade.A)
                .avecCategorie("Boisson")
                .build();
    }
}

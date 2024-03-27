package repository;

import model.Zutat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZutatRepositoryTest {

    private final ZutatRepository sut = new ZutatRepository();

    @BeforeEach
    void setup(){
        Zutat zutat1 = new Zutat("onion", 10, 62);
        Zutat zutat2 = new Zutat("tomato", 12.7, 80);
        Zutat zutat3 = new Zutat("potato", 15.5, 23);
        Zutat zutat4 = new Zutat("garlic", 7.75, 97);
        Zutat zutat5 = new Zutat("pepper", 8.25, 4);

        sut.add(zutat1);
        sut.add(zutat2);
        sut.add(zutat3);
        sut.add(zutat4);
        sut.add(zutat5);
    }

    // Testfälle für ECP
    @Test
    void update_ec1() {
        // Given
        Zutat newZutat = new Zutat("tomato", 13, 74);

        // When
        sut.update("tomato", newZutat);

        // Then
        assertEquals(newZutat.getMenge(), sut.getAlleZutaten().get(1).getMenge());
        assertEquals(newZutat.getPreis(), sut.getAlleZutaten().get(1).getPreis());
    }

    @Test
    void update_ec4() {
        // Given
        Zutat newZutat = new Zutat("tomato", -17, 74);

        // When
        sut.update("tomato", newZutat);

        // Then
        assertEquals(80, sut.getAlleZutaten().get(1).getMenge());
        assertEquals(12.7, sut.getAlleZutaten().get(1).getPreis());
    }

    @Test
    void update_ec6() {
        // Given
        Zutat newZutat = new Zutat("tomato", -17, 744);

        // When
        sut.update("tomato", newZutat);

        // Then
        assertEquals(80, sut.getAlleZutaten().get(1).getMenge());
        assertEquals(12.7, sut.getAlleZutaten().get(1).getPreis());
    }

    @Test
    void update_ec9() {
        // Given
        Zutat newZutat = new Zutat("tomato", 1234.12, 744);

        // When
        sut.update("tomato", newZutat);

        // Then
        assertEquals(80, sut.getAlleZutaten().get(1).getMenge());
        assertEquals(12.7, sut.getAlleZutaten().get(1).getPreis());
    }

    // Testfälle für BVA
    @Test
    void update_c11() {
        // Given
        Zutat newZutat = new Zutat("tomato", 100, 1);

        // When
        sut.update("tomato", newZutat);

        // Then
        assertEquals(newZutat.getMenge(), sut.getAlleZutaten().get(1).getMenge());
        assertEquals(newZutat.getPreis(), sut.getAlleZutaten().get(1).getPreis());
    }

    @Test
    void update_c12() {
        // Given
        Zutat newZutat = new Zutat("tomato", 100, 100);

        // When
        sut.update("tomato", newZutat);

        // Then
        assertEquals(newZutat.getMenge(), sut.getAlleZutaten().get(1).getMenge());
        assertEquals(newZutat.getPreis(), sut.getAlleZutaten().get(1).getPreis());
    }

    @Test
    void update_c21() {
        // Given
        Zutat newZutat = new Zutat("tomato", 0, 1);

        // When
        sut.update("tomato", newZutat);

        // Then
        assertEquals(80, sut.getAlleZutaten().get(1).getMenge());
        assertEquals(12.7, sut.getAlleZutaten().get(1).getPreis());
    }

    @Test
    void update_c17() {
        // Given
        Zutat newZutat = new Zutat("tomato", -70, 0);

        // When
        sut.update("tomato", newZutat);

        // Then
        assertEquals(80, sut.getAlleZutaten().get(1).getMenge());
        assertEquals(12.7, sut.getAlleZutaten().get(1).getPreis());
    }

    @Test
    void update_c20() {
        // Given
        Zutat newZutat = new Zutat("tomato", 0, -51);

        // When
        sut.update("tomato", newZutat);

        // Then
        assertEquals(80, sut.getAlleZutaten().get(1).getMenge());
        assertEquals(12.7, sut.getAlleZutaten().get(1).getPreis());
    }

}
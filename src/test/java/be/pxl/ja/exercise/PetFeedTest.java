package be.pxl.ja.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PetFeedTest {

    private static final int INITIAL_ENERGY = 50;
    private Pet pet;

    @BeforeEach
    public void init(){
        System.out.println("Creating pet for testing...");
        pet = new Pet(INITIAL_ENERGY);
    }

    @Test
    public void feedIncreasesEnergyWith20(){
        pet.feed("dogFood");
        assertEquals(INITIAL_ENERGY + 20, pet.getEnergy());
    }

    @Test
    public void feedThrowsWrongFoodException(){
        WrongFoodException exception = assertThrows(WrongFoodException.class, ()-> pet.feed("chocolate"));
        assertEquals("You cannot feed the pet chocolat", exception.getMessage());
        assertEquals(50, pet.getEnergy());
    }

    @Test
    public void feedPetTooMuchDoesNotExceeds100(){
        pet.feed("dogFood");
        pet.feed("fish");
        pet.feed("dogFood");
        assertEquals(Pet.MAX_ENERGY, pet.getEnergy());
    }
}

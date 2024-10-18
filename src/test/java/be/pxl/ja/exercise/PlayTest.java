package be.pxl.ja.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayTest {

    private static final int INITIAL_ENERGY = 50;
    private Pet pet;

    @BeforeEach
    public void init(){
        System.out.println("Creating pet for testing...");
        pet = new Pet(INITIAL_ENERGY);
    }

    @Test
    public void feedDecreasesEnergyWith30() throws PetTiredException{
        pet.play();
        assertEquals(INITIAL_ENERGY - 30, pet.getEnergy());
    }

    @Test
    public void playThrowsPetTiredExceptionWhenEnergyBelow20(){
        pet = new Pet(10);
        PetTiredException exception = assertThrows(PetTiredException.class, ()-> pet.play());
        assertEquals("Pet doesn't have the energy to play.", exception.getMessage());
        assertEquals(10, pet.getEnergy());
    }


    @Test
    public void playCannotDropEnergyBelow0() throws PetTiredException{
        //ARRANGE = testdata
        pet = new Pet(20);
        //ACT = testmethode
        pet.play();
        //ASSERT = verifieren
        assertEquals(Pet.MIN_ENERGY, pet.getEnergy());
    }
}

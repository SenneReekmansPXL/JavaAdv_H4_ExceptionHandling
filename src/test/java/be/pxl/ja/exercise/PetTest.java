package be.pxl.ja.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PetTest {

    @Test
    public void testContructorWIthEnergyBelowZero(){
        Pet pet = new Pet(-5);
        assertNotNull(pet);
        assertEquals(0, pet.getEnergy());
    }

    @Test
    public void  testContructorWIthEnergyBetween0And100(){
        Pet pet = new Pet(10);
        assertNotNull(pet);
        assertEquals(10,pet.getEnergy());
    }

    @Test
    public void  testContructorWIthEnergyAbove100(){
        Pet pet = new Pet(105);
        assertNotNull(pet);
        assertEquals(100, pet.getEnergy());
    }

    @Test
    public void testToString(){
        Pet pet = new Pet(98);
        assertEquals("Pet's energy is 98", pet.toString());
    }


}

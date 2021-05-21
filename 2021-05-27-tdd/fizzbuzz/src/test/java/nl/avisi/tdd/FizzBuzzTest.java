package nl.avisi.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @Test
    public void sayNumber() {
        assertEquals("1", FizzBuzz.say(1));
        assertEquals("2", FizzBuzz.say(2));
    }

    @Test
    public void sayFizz() {
        assertEquals("Fizz", FizzBuzz.say(3));
        assertEquals("Fizz", FizzBuzz.say(6));
    }

    @Test
    public void sayBuzz() {
        assertEquals("Buzz", FizzBuzz.say(5));
        assertEquals("Buzz", FizzBuzz.say(10));
    }

    @Test
    public void sayFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.say(15));
        assertEquals("FizzBuzz", FizzBuzz.say(30));
    }
}

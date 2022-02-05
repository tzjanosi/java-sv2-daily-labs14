package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {
    PairFinder pairFinder;

    @BeforeEach
    void init() {
        pairFinder = new PairFinder();
    }

    @Test
    void pairFinderTest(){
        assertEquals(0,pairFinder.findPairs(new int[] {1, 2, 3, 4}));
        assertEquals(4,pairFinder.findPairs(new int[] {7, 1, 5, 7, 3, 3, 5, 7, 6, 7}));
        assertEquals(1,pairFinder.findPairs(new int[] {5, 1, 4, 5}));
    }

}
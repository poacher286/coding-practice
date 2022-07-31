package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortSentenceTest {

    @Test
    void sortSentence() {
        assertEquals(SortSentence.sortSentence("is2 sentence4 This1 a3"), "This is a sentence");
    }
}
package strings;

import org.javagrader.Grade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@Grade
public class AutoCompleterTest {

    @Test
    @Grade(value=1)
    public void testEmptyTrie() {
        AutoCompleter ac = new AutoCompleter(new String[]{});
        assertNull(ac.complete(""));
        assertNull(ac.complete("a"));
    }

    @Test
    @Grade(value=1)
    public void testPrefixNotInTrie() {
        AutoCompleter ac = new AutoCompleter(new String[]{ "abruptly",  "babylonite", "cinurous", "drabbing", "exocardiac"});
        assertNull(ac.complete("factive"));
        assertNull(ac.complete("babylonites"));
    }

    @Test
    @Grade(value=1)
    public void testPrefixIsKey() {
        String[] dictionary = new String[]{ "abruptly",  "babylonite", "cinurous", "drabbing", "exocardiac"};
        AutoCompleter ac = new AutoCompleter(dictionary);
        for (String word : dictionary) {
            assertEquals(ac.complete(word), word);
        }
    }

    @Test
    @Grade(value=1)
    public void testPrefixInTrie() {
        String[] dictionary = new String[]{ "abruptly", "abrus", "babylonite", "cinurous", "drabbing", "exocardiac"};
        AutoCompleter ac = new AutoCompleter(dictionary);
        for (String word : dictionary) {
            assertEquals(ac.complete(word.substring(0, word.length()-1)), word);
        }
        assertEquals(ac.complete("a"), "abrus");
    }

    @Test
    @Grade(value=1)
    public void testMultipleKeysForPrefix() {
        String[] dictionary = new String[]{ "abruptly", "abrus", "abrui", "babylonite", "cinurous", "drabbing", "exocardiac"};
        AutoCompleter ac = new AutoCompleter(dictionary);
        assertEquals(ac.complete("a"), "abrui");
    }


}

package chapter3.exercises;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/10
 * Time: 20:07
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class StringExercisesTest {
    @Test
    public void countLowercaseLetters() throws Exception {
        assertEquals(0, StringExercises.countLowercaseLetters(""));
    }

    @Test
    public void countsLowercaseLetterExample() throws Exception {
        assertEquals(3, StringExercises.countLowercaseLetters("aBcDeF"));
    }

    @Test
    public void supportNoLowercaseLetters(){
        assertEquals(0, StringExercises.countLowercaseLetters("ABCDEF"));
    }

    @Test
    public void noStringReturnedForEmptyList() throws Exception {
        assertFalse(StringExercises.mostLowercaseString(Collections.emptyList()).isPresent());
    }

    @Test
    public void findMostLowercaseString(){
        Optional<String> result = StringExercises.mostLowercaseString(Arrays.asList("a", "abc", "ABCde"));
        assertEquals(Optional.of("abc"), result);
    }

}
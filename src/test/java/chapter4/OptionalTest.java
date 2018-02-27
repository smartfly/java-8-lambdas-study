package chapter4;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/24
 * Time: 20:07
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class OptionalTest {

    @Test
    public void testGetOptionalValue(){
        Optional<String> a = Optional.of("a");
        assertEquals("a", a.get());
    }

    @Test
    public void testEmptyNullableIsPresentMethod(){
        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);

        assertFalse(emptyOptional.isPresent());

        Optional<String> a = Optional.of("a");
        assertTrue(a.isPresent());
    }

    @Test
    public void testOrElseAndorElseGet(){
        Optional emptyOptional = Optional.empty();
        assertEquals("b", emptyOptional.orElse("b"));
        assertEquals("c", emptyOptional.orElseGet(() -> "c"));
    }

}

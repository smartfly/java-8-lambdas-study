package chapter3;

import chapter1.SampleData;
import chapter1.Track;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/7
 * Time: 17:34
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class SampleTest {

    @Test
    public void testCollection(){
        List<String> collected = Stream.of("a", "b","c")
                .collect(Collectors.toList());
        assertEquals(asList("a", "b", "c"), collected);
    }

    @Test
    public void testToUppercaseByFor(){
        List<String> collected = new ArrayList<>();
        for (String s : asList("a", "b", "hello")){
            String uppercaseString = s.toUpperCase();
            collected.add(uppercaseString);
        }
        assertEquals(asList("A","B","HELLO"), collected);
    }


    @Test
    public void testToUppercaseByMap(){
        List<String> collected = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        assertEquals(asList("A", "B", "HELLO"), collected);
    }

    @Test
    public void testBeginningWithNumbersByFor(){
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String value : asList("a", "1abc", "abc1")){
            if (isDigit(value.charAt(0))){
                beginningWithNumbers.add(value);
            }
        }
        assertEquals(asList("1abc"), beginningWithNumbers);
    }

    @Test
    public void testBeginningWithNumberByFilter(){
        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(Collectors.toList());
        assertEquals(asList("1abc"), beginningWithNumbers);
    }

    @Test
    public void testFlatMap(){
        List<Integer> together = Stream.of(asList(1, 2),asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 2, 3, 4), together);
    }

    @Test
    public void testMaxOrMin(){
        List<Track> tracks = asList(new Track("Bakai", 524),
                new Track("Violates for Your Furs", 378),
                new Track("Time Was", 451));
        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();
        assertEquals(tracks.get(1), shortestTrack);
    }

    @Test
    public void testSum(){
        int count = Stream.of(1, 2, 3, 4)
                .reduce(0, (acc, element) -> acc + element);
        assertEquals(10, count);
    }

    @Test
    public void testSumByBinaryOperator(){
        BinaryOperator<Integer> accumulator = (acc, elemet) -> acc + elemet;
        int count = accumulator.apply(
                        accumulator.apply(
                            accumulator.apply(0, 1),
                        2),
                    3);
        assertEquals(6, count);
    }

    @Test
    public void testMultiOperator(){
        Set<String> origins = SampleData.sampleShortAlbum.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getNationality()).collect(Collectors.toSet());
        assertEquals(new HashSet(Arrays.asList("UK")), origins);
    }
}

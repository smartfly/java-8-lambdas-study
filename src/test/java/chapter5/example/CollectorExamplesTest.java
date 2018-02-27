package chapter5.example;

import chapter1.SampleData;
import org.junit.Test;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/26
 * Time: 20:35
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class CollectorExamplesTest {
    @Test
    public void averageNumberOfTracks() throws Exception {
        CollectorExamples examples = new CollectorExamples();
        assertEquals(examples.averageNumberOfTracks(SampleData.albums.collect(Collectors.toList())), 2.0, 0.01);
    }

    @Test
    public void toCollectTreeSet() throws Exception {
        CollectorExamples examples = new CollectorExamples();
        assertEquals(examples.toCollectTreeSet(Stream.of(1, 2, 3)), new TreeSet<>(asList(1, 2, 3)));
    }

    @Test
    public void testBiggestGroup(){
        CollectorExamples examples = new CollectorExamples();
        assertEquals(examples.biggestGroup(SampleData.threeArtists()).get(), SampleData.theBeatles);
    }

}
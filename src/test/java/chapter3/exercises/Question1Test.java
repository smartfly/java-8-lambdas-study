package chapter3.exercises;

import chapter1.Album;
import chapter1.SampleData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static chapter1.SampleData.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/10
 * Time: 15:57
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class Question1Test {

    @Test
    public void addUp1() throws Exception {
        assertEquals(Question1.addUp(Stream.of(1, 2, 3, 4)), 10);
    }

    @Test
    public void addUp2() throws Exception {
        assertEquals(Question1.addUp(Stream.empty()), 0);
    }

    @Test
    public void getNamesAndOrigins() throws Exception {
        List<String> namesAndOrigins = Question1.getNamesAndOrigins(SampleData.getThreeArtists());
        assertEquals(Arrays.asList("John Coltrane", "US", "John Lennon", "UK", "The Beatles", "UK"),
                namesAndOrigins);
    }

    @Test
    public void getAlbumsWithAtMostThreeTracks() throws Exception {
        List<Album> albumList = Arrays.asList(aLoveSupreme, sampleShortAlbum, manyTrackAlbum);
        assertEquals(asList(aLoveSupreme, sampleShortAlbum),
                Question1.getAlbumsWithAtMostThreeTracks(albumList));
    }

}
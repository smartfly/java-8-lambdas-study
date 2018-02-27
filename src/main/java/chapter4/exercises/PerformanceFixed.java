package chapter4.exercises;

import chapter1.Artist;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/24
 * Time: 20:26
 * Description: A Performance by some musicians - eg an Ablum or Gig
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public interface PerformanceFixed {
    String getName();

    Stream<Artist> getMusicians();

    default Stream<Artist> getAllMusicians(){
        return getMusicians().flatMap(artist -> concat(Stream.of(artist), artist.getMembers()));
    }
}

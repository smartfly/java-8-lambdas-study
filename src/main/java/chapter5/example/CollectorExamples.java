package chapter5.example;

import chapter1.Album;
import chapter1.Artist;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toCollection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/26
 * Time: 20:30
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class CollectorExamples {

    public <T> TreeSet<T> toCollectTreeSet(Stream<T> a){

        // BEGIN TO_COLLECTION_TREESET
        return a.collect(toCollection(TreeSet::new));
    }

    public Optional<Artist> biggestGroup(Stream<Artist> artists){
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artists.collect(maxBy(Comparator.comparing(getCount)));
    }

    public double averageNumberOfTracks(List<Album> albums){
        return albums.stream()
                .collect(averagingInt(album -> album.getTrackList().size()));
    }

}

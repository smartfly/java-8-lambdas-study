package chapter4.exercises;

import chapter1.Artist;

import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/24
 * Time: 20:31
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class ArtistsFixed {

    private List<Artist> artists;

    public ArtistsFixed(List<Artist> artists) {
        this.artists = artists;
    }

    public Optional<Artist> getArtist(int index){
        if (index < 0 || index >= artists.size()){
            return Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    public String getArtistName(int index){
        Optional<Artist> artist = getArtist(index);
        return artist.map(Artist::getName)
                .orElse("unknown");
    }

}

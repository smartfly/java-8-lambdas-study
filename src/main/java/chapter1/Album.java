package chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/7
 * Time: 15:37
 * Description: Album 专辑，由若干曲目组成
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public final class Album implements Performance{

    /**
     * 专辑名称
     */
    private String name;

    /**
     * 专辑上所有曲目
     */
    private List<Track> tracks;

    /**
     * 参与创作本专辑的艺术家列表
     */
    private List<Artist> musicians;

    public Album(String name, List<Track> tracks, List<Artist> musicians){
        Objects.requireNonNull(name);
        Objects.requireNonNull(tracks);
        Objects.requireNonNull(musicians);

        this.name = name;
        this.tracks = new ArrayList<>(tracks);
        this.musicians = new ArrayList<>(musicians);
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return the tracks
     */
    public Stream<Track> getTracks() {
        return tracks.stream();
    }

    /**
     * @return the musicians
     */
    @Override
    public Stream<Artist> getMusicians() {
        return musicians.stream();
    }

    /**
     * Used in imperative code examples that need to iterate over a list
     * @return the musicians
     */
    public List<Track> getTrackList(){
        return Collections.unmodifiableList(tracks);
    }

    /**
     * @return a main musician
     */
    public Artist getMainMusician(){
        return musicians.get(0);
    }

    public Album copy(){
        List<Track> tracks = getTracks()
                .map(Track::copy)
                .collect(Collectors.toList());

        List<Artist> musicians = getMusicians()
                .map(Artist::copy)
                .collect(Collectors.toList());
        return new Album(name, tracks, musicians);
    }

}

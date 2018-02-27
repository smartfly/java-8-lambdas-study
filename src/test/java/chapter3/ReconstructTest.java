package chapter3;

import chapter1.Album;
import chapter1.Track;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/7
 * Time: 19:46
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class ReconstructTest {

    @Test
    public void testOrigin(){

    }

    /**
     * 找出长度大于1分钟的曲目，最原始方法
     * @param albums
     * @return
     */
    public Set<String> findLongTracks(List<Album> albums){
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                if (track.getLength() > 60){
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }


    /**
     * 找出长度大于1分钟的曲目，重构第1步
     * @param albums
     * @return
     */
    public Set<String> findLongTracks1Step(List<Album> albums){
        Set<String> trackNames = new HashSet<>();

        albums.stream().forEach(album -> {
            album.getTracks().forEach(track -> {
                if (track.getLength() > 60){
                    String name = track.getName();
                    trackNames.add(name);
                }
            });
        });

        return trackNames;
    }

    /**
     * 找出长度大于1分钟的曲目，重构第2步
     * @param albums
     * @return
     */
    public Set<String> findLongTracks2Step(List<Album> albums){
        Set<String> trackNames = new HashSet<>();

        albums.stream().forEach(album -> {
            album.getTracks()
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .forEach(name -> trackNames.add(name));
        });
        return trackNames;
    }


    /**
     * 找出长度大于1分钟的曲目，重构第3步
     * @param albums
     * @return
     */
    public Set<String> findLongTracks3Step(List<Album> albums){
        Set<String> trackNames = new HashSet<>();

        albums.stream()
                .flatMap(album -> album.getTracks())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .forEach(name -> trackNames.add(name));
        return trackNames;
    }

    /**
     * 找出长度大于1分钟的曲目，重构第4步
     * @param albums
     * @return
     */
    public Set<String> findLongTracks4Step(List<Album> albums){
       return albums.stream()
               .flatMap(album -> album.getTracks())
               .filter(track -> track.getLength() > 60)
               .map(track -> track.getName())
               .collect(Collectors.toSet());
    }



}

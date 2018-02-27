package chapter3.exercises;

import chapter1.Album;
import chapter1.Artist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/10
 * Time: 15:50
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class Question1 {

    /**
     * 计算流中所有数之和
     * @param numbers
     * @return
     */
    public static int addUp(Stream<Integer> numbers){
        return numbers.reduce(0, (acc, element) -> acc + element);
    }

    /**
     * 编写一个函数，接受艺术家列表作为参数，返回一个字符串列表，其中包含艺术家的姓名和国籍
     * @param artists
     * @return
     */
    public static List<String> getNamesAndOrigins(List<Artist> artists){
        return artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(Collectors.toList());
    }

    /**
     * 编写一个函数，接受专辑列表作为参数，返回一个由最多包含3 首歌曲的专辑组成的列表
     * @param input
     * @return
     */
    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input){
        return input.stream()
                .filter(album -> album.getTrackList().size() <= 3)
                .collect(Collectors.toList());
    }

}

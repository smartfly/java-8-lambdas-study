package chapter1;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/7
 * Time: 16:12
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class Chapter1 extends MusicChapter{


    public Chapter1(List<Artist> artists, List<Album> albums) {
        super(artists, albums);
    }

    /**
     * 通过Lambda表达式获取音乐作家名字
     * @return
     */
    public List<String> getNamesOfArtist_Lambda(){
        return artists.stream()
                .map(artist -> artist.getName())
                .collect(Collectors.toList());
    }

    /**
     * 通过方法引用方式获取音乐家名字
     * @return
     */
    public List<String> getNameOfArtists_MethodReference(){
        return artists.stream()
                .map(Artist::getName)
                .collect(Collectors.toList());
    }

    /**
     * 获取艺术家居住在London的
     * @return
     */
    public List<Artist> artistsLivingInLondon(){
        return artists.stream()
                .filter(artist -> "London".equals(artist.getNationality()))
                .collect(Collectors.toList());
    }

}

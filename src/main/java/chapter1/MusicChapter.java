package chapter1;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/7
 * Time: 15:54
 * Description: 音乐章节
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public abstract class MusicChapter {

    /**
     * 创作音乐人
     */
    protected final List<Artist> artists;

    /**
     * 专辑
     */
    protected final List<Album> albums;

    public MusicChapter(List<Artist> artists, List<Album> albums) {
        this.artists = artists;
        this.albums = albums;
        loadData("");
    }

    private void loadData(String file){
    }
}

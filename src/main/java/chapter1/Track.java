package chapter1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/7
 * Time: 15:28
 * Description: Track 专辑中的一支曲目
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public final class Track {

    /**
     * 曲目名称
     */
    private final String name;

    /**
     * 曲目时长
     */
    private final int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    /**
     * get the name of track
     * @return the name
     */
    public String getName(){
        return name;
    }

    /**
     * get the length of the track
     * @return the length of the track in milliseconds
     */
    public int getLength(){
        return length;
    }

    public Track copy(){
        return new Track(name, length);
    }

}

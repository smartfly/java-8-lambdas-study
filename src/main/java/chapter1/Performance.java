package chapter1;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/7
 * Time: 15:33
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public interface Performance {

    public String getName();

    public Stream<Artist> getMusicians();

    //TODO: test
    public default Stream<Artist> getAllMusicians(){
        return getMusicians().flatMap(artist -> Stream.concat(Stream.of(artist), artist.getMembers()));
    }

}

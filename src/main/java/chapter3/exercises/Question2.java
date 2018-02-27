package chapter3.exercises;

import chapter1.Artist;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/10
 * Time: 19:32
 * Description: 第3章-第2题
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class Question2 {
    //
    public static int countBandMembersInternal(List<Artist> artists){
        return (int) artists.stream()
                .flatMap(artist -> artist.getMembers())
                .count();
    }

}

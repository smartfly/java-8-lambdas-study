package chapter3;

import chapter1.Artist;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/7
 * Time: 17:14
 * Description: 流操作样例
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class SampleTest {

    public static final Artist johnColtrane = new Artist("John Coltrane", "US");

    public static final Artist johnLennon = new Artist("John Lennon", "UK");
    public static final Artist paulMcCartney = new Artist("Paul McCartney", "UK");
    public static final Artist georgeHarrison = new Artist("George Harrison", "UK");
    public static final Artist ringoStarr = new Artist("Ringo Starr", "UK");

    public static final List<Artist> membersOfTheBeatles = asList(johnLennon,
            paulMcCartney, georgeHarrison, ringoStarr);

    public static final Artist theBeatles = new Artist("The Beatles", membersOfTheBeatles, "UK");


    public List<Artist> getAllArtist(){
        return Arrays.asList(theBeatles, johnColtrane, johnLennon);
    }

    public static void main(String[] args) {
        SampleTest test = new SampleTest();
        long a = test.getAllArtist().stream().filter(artist -> {
            System.out.println(artist.getName() + " " + artist.getNationality());
            return artist.isFrom("UK");
        })
        .count();
        System.out.println(a);
    }

}

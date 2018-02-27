package chapter4.example;

import chapter1.Album;

import java.util.IntSummaryStatistics;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/23
 * Time: 19:36
 * Description: 基本类型
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class Primitives {

    public static void printTrackLengthStatistics(Album album){
        IntSummaryStatistics trackLengthStats =
                album.getTracks()
                        .mapToInt(track -> track.getLength())
                        .summaryStatistics();
        System.out.println(String.format("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum()
        ));
    }

}

package chapter4.example;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/24
 * Time: 10:17
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public interface Jukebox {

    public default String rock(){
        return "... all over the world!";
    }

}

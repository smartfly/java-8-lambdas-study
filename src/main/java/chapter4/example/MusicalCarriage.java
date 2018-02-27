package chapter4.example;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/24
 * Time: 10:20
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class MusicalCarriage
        implements Carriage, Jukebox {
    @Override
    public String rock() {
        return Carriage.super.rock();
    }
}

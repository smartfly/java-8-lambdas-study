package chapter4.example;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/23
 * Time: 20:38
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public interface Parent {

    public void message(String body);

    public default void welcome(){
        message("Parent: Hi!");
    }

    String getLastMessage();

}

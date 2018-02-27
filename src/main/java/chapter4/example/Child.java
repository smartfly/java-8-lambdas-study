package chapter4.example;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/23
 * Time: 20:44
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public interface Child extends Parent {
    @Override
    default void welcome() {
        message("Child: Hi!");
    }
}

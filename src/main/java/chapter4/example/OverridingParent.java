package chapter4.example;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/24
 * Time: 9:53
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class OverridingParent extends ParentImpl {

    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }
}

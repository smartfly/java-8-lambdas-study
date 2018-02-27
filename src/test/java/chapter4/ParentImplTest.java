package chapter4;

import chapter4.example.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/23
 * Time: 20:41
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class ParentImplTest {

    @Test
    public void parentDefaultUsed(){
        Parent parent = new ParentImpl();
        parent.welcome();
        assertEquals("Parent: Hi!", parent.getLastMessage());
    }

    @Test
    public void childOverrideDefault(){
        Child child = new ChildImpl();
        child.welcome();
        assertEquals("Child: Hi!", child.getLastMessage());
    }

    /**
     * 任何时候，一旦与类中定义的方法产生冲突，都要优先选择类中定义的方法
     */
    @Test
    public void concreteBeatsDefault(){
        /*调用的是类中的具体方法，而不是默认方法*/
        Parent parent = new OverridingParent();
        parent.welcome();
        assertEquals("Class Parent: Hi!", parent.getLastMessage());
    }

    @Test
    public void concreteBeatsCloserDefault(){
        /*类中重写的方法优先级高于接口中定义的默认方法*/
        Child child = new OverridingChild();
        child.welcome();
        assertEquals("Class Parent: Hi!", child.getLastMessage());
    }

}
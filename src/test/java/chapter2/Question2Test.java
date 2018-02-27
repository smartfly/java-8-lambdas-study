package chapter2;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/2
 * Time: 10:21
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */

public class Question2Test{
    @Test
    public void test1(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1970);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        String formatted = Question2.formatter.get().getFormat().format(calendar.getTime());
        assertEquals("1970-1-1", formatted);
    }
}
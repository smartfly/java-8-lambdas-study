package chapter2;

import javax.swing.text.DateFormatter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/2
 * Time: 10:16
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class Question2 {

    public static ThreadLocal<DateFormatter> formatter = new ThreadLocal<DateFormatter>(){
        @Override
        protected DateFormatter initialValue() {
            return new DateFormatter();
        }
    };

}

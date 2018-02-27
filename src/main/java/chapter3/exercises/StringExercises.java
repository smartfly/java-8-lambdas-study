package chapter3.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/10
 * Time: 20:00
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class StringExercises {

    /**
     * 计算字符串小写字母个数
     * @param str
     * @return
     */
    public static int countLowercaseLetters(String str){
        return (int) str.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    /**
     * 找出包含最多小写字母的字符串，对于空列表，返回Optional<String>
     * @param strings
     * @return
     */
    public static Optional<String> mostLowercaseString(List<String> strings){
        return strings.stream()
                .max(Comparator.comparing(StringExercises::countLowercaseLetters));
    }

}

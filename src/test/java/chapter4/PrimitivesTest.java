package chapter4;

import chapter1.SampleData;
import chapter4.example.Primitives;
import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/23
 * Time: 19:41
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class PrimitivesTest {
    @Test
    public void printTrackLengthStatistics() throws Exception {
        Primitives.printTrackLengthStatistics(SampleData.aLoveSupreme);
    }


    @Test
    public void test(){
        overloadMethod("abc");
    }

    private void overloadMethod(Object o){
        System.out.println("Object");
    }

    private void overloadMethod(String s){
        System.out.println("String");
    }

    @Test
    public void testBinaryOperator(){
        overloadedMethod((x,y)-> x + y);
    }

    private interface IntegerBiFunction extends BinaryOperator<Integer>{

    }

    private void overloadedMethod(BinaryOperator<Integer> lambda){
        System.out.println("BinaryOperator");
    }

    private void overloadedMethod(IntegerBiFunction Lambda){
        System.out.println("IntegerBinaryOperator");
    }


    @Test
    public void testNoSubject(){
//        overloadedMethod((x) -> true);
    }

    private interface IntPredicate {
        public boolean test(int value);
    }

    private void overloadedMethod(Predicate<Integer> predicate) {
        System.out.println("Predicate");
    }

    private void overloadedMethod(IntPredicate predicate){
        System.out.println("IntPredicate");
    }

}
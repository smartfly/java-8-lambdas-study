package chapter5;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/26
 * Time: 20:08
 * Description: 元素顺序操作
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class CollectElementOrder {

    /**
     * 在一个有序集合中创建一个流时，流中的元素就按出现顺序排列
     */
    @Test
    public void orderStreamOper(){
        List<Integer> numbers = asList(1, 2, 3, 4);
        List<Integer> sameOrder = numbers.stream()
                .collect(Collectors.toList());
        assertEquals(numbers, sameOrder);
    }

    @Test
    public void noOrderCollectStreamOperate(){
        Set<Integer> numbers = new HashSet<>(asList(4, 19, 2, 1));
        List<Integer> sameOrder = numbers.stream()
                .collect(Collectors.toList());
        /*该断言有时会失败*/
        assertEquals(asList(1, 2, 4, 19), sameOrder);
    }

    @Test
    public void collectMiddleOrderStreamOperate(){
        Set<Integer> numbers = new HashSet<>(asList(4, 3, 2, 1));
        List<Integer> sameOrder = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        assertEquals(asList(1, 2, 3, 4), sameOrder);
    }

    @Test
    public void collectNoRelationStreamOperate(){
        List<Integer> numbers = asList(1, 2, 3, 4);
        List<Integer> stillOrdered = numbers.stream()
                .map(x -> x + 1)
                .collect(Collectors.toList());
        //顺序得到了保留
        assertEquals(asList(2, 3, 4, 5), stillOrdered);
    }

    @Test
    public void collectOrderNonSureStream(){
        List<Integer> numbers = asList(1, 2, 3, 4);
        Set<Integer> unsorted = new HashSet<>(numbers);
        List<Integer> stillUnsorted = unsorted.stream()
                .map(x -> x + 1)
                .collect(Collectors.toList());
        //顺序得不到保证
        assertThat(stillUnsorted, hasItem(2));
        assertThat(stillUnsorted, hasItem(3));
        assertThat(stillUnsorted, hasItem(4));
        assertThat(stillUnsorted, hasItem(5));
    }


}

import org.junit.Test;

import java.util.stream.Stream;

public class SimpleTest {
    @Test
    public void test1() {
        System.out.println(9 >>> 1);
    }

    @Test
    public void test2() {
        Integer[] array = Stream.of(1, 2, 3, 4, 5).toArray(Integer[]::new);
    }
}

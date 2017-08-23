package wenge.com.testkotlin;

import org.junit.Test;

import wenge.com.testkotlin.test.ShortTest;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
//    @Test
//    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
//    }
    @Test
    public void testShort(){
        ShortTest.main(null);
    }
}
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

public class test {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSum() {

        int num1 = 5;
        int num2 = 7;

        int result = Main.sum(num1, num2);
        int expected = 12;
        assertEquals(expected, result);

    }

}

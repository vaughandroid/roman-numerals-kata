package kata;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyGeneratorTests {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1,    "I" },
                { 2,    "II" },
                { 3,    "III" },
                { 4,    "IV" },
                { 5,    "V" },
                { 6,    "VI" },
                { 7,    "VII" },
                { 8,    "VIII" },
                { 9,    "IX" },
                { 10,   "X" },
        });
    }

    private final int input;
    private final String expectedOutput;

    public MyGeneratorTests(int input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void test() throws Exception {
        String output = new MyGenerator().generate(input);
        Assert.assertEquals("Input: " + input, expectedOutput, output);
    }
}
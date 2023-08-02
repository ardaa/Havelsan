import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TwoStacksTest {

    @Test
    public void testPlay() {
        int[] stackA = {4, 2, 4, 6, 1};
        int[] stackB = {2, 1, 8, 5};
        int x = 10;

        int result = TwoStacks.play(stackA, stackB, x);

        int expected = 4;  // Adjust this value based on your expected result
        assertEquals(expected, result);
    }

    @Test
    public void testMain() {
        String input = "2\n5 4 10\n4 2 4 6 1\n2 1 8 5\n3 3 7\n4 2 4\n2 1 8\n";
        InputStream originalSystemIn = System.in;
        PrintStream originalSystemOut = System.out;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            TwoStacks.main(new String[0]);

            String expectedOutput = "4\n3\n";  // Adjust this output based on your expected results
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            System.setIn(originalSystemIn);
            System.setOut(originalSystemOut);
        }
    }
}

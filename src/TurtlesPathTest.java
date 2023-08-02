import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TurtlesPathTest {

    @Test
    public void testCountPaths() {
        int[][] table = {
                {2, 3, 7},
                {5, 4, 2},
                {3, 7, 11}
        };

        TurtlesPath turtlesPath = new TurtlesPath(3, 3);
        int count = turtlesPath.countPaths(table);

        // Replace the expectedValue with the expected output for the given input
        int expectedValue = 4;
        assertEquals(expectedValue, count);
    }

    @Test
    public void testPrintPath() {
        int[][] table = {
                {2, 3, 7},
                {5, 4, 2},
                {3, 7, 11}
        };

        TurtlesPath turtlesPath = new TurtlesPath(3, 3);

        // Redirect System.out for testing printPath
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        turtlesPath.printPath(table);

        // Reset System.out
        System.setOut(System.out);

        String expectedOutput = "1 1\n2 1\n3 1\n3 2\n3 3\n";
        assertEquals(expectedOutput, outputStream.toString());
    }


}

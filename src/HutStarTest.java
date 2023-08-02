import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HutStarTest {

    @Test
    public void testHutPrinter() {
        int n = 5;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        try {
            System.setOut(new PrintStream(outputStream));
            HutStar.hutPrinter(n);

            String expectedOutput = "    *\n   ***\n  *****\n *******\n*********\n***   ***\n***   ***\n***   ***\n";  // Adjust this output based on your expected results
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            System.setOut(originalSystemOut);
        }
    }
}

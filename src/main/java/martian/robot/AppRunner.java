package martian.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class AppRunner {

    public static void main(String[] args) throws IOException {


        System.out.println("Surface boundaries are hardcoded to 5 3 for now.\n1. Enter position in one line e.g. 1 1 E and press enter" +
                "\n2. Enter instruction in another line e.g. RFRFRFRF and press enter." +
                "\n3. Type run and press enter. You should see an output." +
                "\n4. You can repeat the above as many times as you want. To terminate the program type exit and press enter.");
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader reader = new BufferedReader(inputStreamReader);) {

            List<String> inputList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("RUN")) {
                    Optional<String> output = new MarsSurface().callRobot(inputList);
                    System.out.println(output.orElse("Robot did not move try again"));
                    inputList.clear();
                    continue;
                }

                if (line.equalsIgnoreCase("EXIT")) break;

                inputList.add(line);
            }
        }
    }
}

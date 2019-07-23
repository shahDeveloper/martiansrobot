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

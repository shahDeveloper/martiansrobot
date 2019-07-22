package martian.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppRunner {

    public static void main(String[] args) throws IOException {

        List<String> inputList = new ArrayList<>();

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader reader = new BufferedReader(inputStreamReader);) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("RUN")) {
                    Optional<String> output = new Robot().goRobot(inputList);
                    System.out.println(output.orElse("Robot did not move try again"));
                    inputList.clear();
                    continue;
                }

                if (line.equalsIgnoreCase("EXIT")) break;

                inputList.add(line);
            }



           /* String line;
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("RUN")) {
                    break;
                }

                System.out.println(line);
            }*/
        }

    }

}

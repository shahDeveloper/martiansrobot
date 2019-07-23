# martiansrobot
- Java Solution for Martian Robots.
- Build the project with maven.
- Run the main method in AppRunner class.
- Requires Java 8 to run.

Surface boundaries are hardcoded to 5 3 for now. Once you start the app by running the main method follow these instruction/commands.

1. Enter position in one line e.g. 1 1 E (separated by space) and press enter
2. Enter instruction in another line e.g. RFRFRFRF and press enter.
3. Type run and press enter. You should see an output.
4. You can repeat the above as many times as you want. 
5. To terminate the program type exit and press enter.


Remaining Tasks
1. Expand error handling, failure scenarios and validation (some done already as a sample).
2. The grid boundaries are currently hardcoded. We can make this dynamic by capturing an additional line when the app starts and setting the values to gridXLimit and gridYLimit. This could be extended to accommodate minus axis.
3. More test cases are required particularly for covering negative scenarios. Similar to what is done already for happy path scenarios but for negative scenarios.

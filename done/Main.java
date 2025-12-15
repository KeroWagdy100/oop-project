

/*
Write a test Driver (main) to create an array of Drawable with minimum size equal to 2.
3- Add the following features.
a. Use fileIn for input & output. Input fileIn named “input.txt” may contain the following:
2
circle 22.5
cube 23.6
This will create an array of size equal to 2, where the 1st item is a circle with radius = 22.5,
and the 2nd item is a cue with side = 23.6.
Then your program will print the sum of all the Drawable array areas to a fileIn named
“sumAreas.txt”.
b. Use GUI To draw the shapes that appear in the input fileIn.
*/
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static void main(String args[]) 
    {
        final String inputFileName = "input.txt";
        final String outputFileName = "SumAreas.txt";

        
        File fileIn = new File(inputFileName);
        Drawable[] drawables;
        double areaSum = 0.0;

        try (Scanner scanner = new Scanner(fileIn))
        {
            int nShapes = scanner.nextInt();
            drawables = new Drawable[nShapes];
            
            for (int i = 0; i < nShapes; ++i)
            {
                String shapeStr = scanner.next();
                double len = scanner.nextDouble();

                switch (shapeStr)
                {
                    case "circle":
                        System.out.println("Adding Circle, " + len);
                        drawables[i] = new Circle(len);
                        break;

                    case "cube":
                        System.out.println("Adding Cube, " + len);
                        drawables[i] = new Cube(len);
                        break;

                    default:
                        continue;
                        // return;
                }

                areaSum += ((Shape)drawables[i]).getArea();
                System.out.println("Area Sum = " + areaSum);
            }

            try (
                FileWriter fileout = new FileWriter(outputFileName);
                PrintWriter printWriter = new PrintWriter(fileout);
            )
            {
                printWriter.print(areaSum);
            }
            catch (IOException e)
            {
                System.err.println("Error Occurred during file writing\n" + e.getMessage());
                return;
            }
            
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File not found: " + e.getMessage());
            return;
        }

        // DRAWING

        JFrame frame = new JFrame("OOP Shapes GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ShapeDrawingPanel panel = new ShapeDrawingPanel(drawables);
        frame.add(panel);

        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        // frame.setBounds(150, 200, 400, 200);
        // frame.setLayout(null);
        frame.setVisible(true);
    }
}

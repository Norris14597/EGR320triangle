package TrianglePack;
import static java.lang.System.*;
import java.util.Scanner;

/**
 * Created by jonathan norris on 9/10/16.
 */
public class UseTriangle {
    public static void main(String[] args)
    {
        System.out.println("Welcome to the place where all the triangle fun is.");
        System.out.println("Press \'Y\' to proceed or \'N\' to exit");
        Scanner input = new Scanner(System.in);
        String cont = "";
        cont = input.nextLine(); //yes or no to enter triangle sides

        //check whether entry was Y or N or neither
        boolean err = true;
        do
        {
            if (cont.equals("Y"))
                err = false;
            else if (cont.equals("N"))
                err = false;

            if (err == true)
            {
                System.out.println("Error in entry. Press \'Y\' to proceed or \'N\' to exit");
                cont = input.nextLine();
            }
        }
        while (err == true);


        double a = 1;
        double b = 1;
        double c = 1;

        Triangle triangle1 = new Triangle(a, b, c);

        while(cont.equals("Y"))
        {
            System.out.println("Input three positive numbers(integer or decimal).");

            //take three sides from user and set the triangle
            a = input.nextDouble();
            b = input.nextDouble();
            c = input.nextDouble();
            String garb = input.nextLine();//retrieve new line character
            triangle1.setTriangle(a, b, c);

            //triangle1.printTriangle(triangle1); //testing only
            boolean isValidTriangle = triangle1.isProperTriangle(triangle1);

            if (isValidTriangle) //output triangle type if valid triangle
            {
                if(triangle1.isEquilateral(triangle1))
                    System.out.println("The triangle entered is an equilateral.");
                if(triangle1.isIsosceles(triangle1))
                    System.out.println("The triangle entered is an isosceles.");
                if(triangle1.isScalene(triangle1))
                    System.out.println("The triangle entered is a scalene.");
                System.out.println("");
            }
            else //output appropriate message if not a triangle
            {
                System.out.println("You're dumb and don't know anything about triangles.");
                System.out.println("Try a real triangle next time.");
                System.out.println("");
            }

            System.out.println("Still need help with triangles???");
            System.out.println("Enter \'Y\' to continue then...");
            System.out.println("Or we can finally be done if you enter \'N\'");

            cont = input.nextLine();//user continue program

            do
            {
                if (cont.equals("Y"))
                    err = false;
                else if (cont.equals("N"))
                    err = false;
                else
                    err = true;

                if (err == true)
                {
                    System.out.println("Error in entry. Press \'Y\' to proceed or \'N\' to exit");
                    cont = input.nextLine();
                }
            }
            while (err == true);


        }

        System.out.println("");
        System.out.println("Good Riddance!!!!");

    }

}

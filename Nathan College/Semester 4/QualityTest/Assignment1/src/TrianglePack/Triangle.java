package TrianglePack;
import static java.lang.System.*;

/**
 * Created by jonathan norris on 9/10/16.
 */
public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;
    private double[] sidesArray = {1,1,1};

    public Triangle(double a, double b, double c) //constructor
    {
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;

        this.sidesArray[0] = a;
        this.sidesArray[1] = b;
        this.sidesArray[2] = c;
    }
    public void printTriangle(Triangle triangle) //print triangle sides with index for testing
    {
        System.out.println("You've entered: A = " + triangle.getSideA() + " B = " + triangle.getSideB() + " C = " + triangle.getSideC());
        for (int i = 0; i < 3; i++)
            System.out.println("Index" + i + ": " + triangle.getSideArray(i));
        System.out.println("");
    }
    public boolean isProperTriangle(Triangle triangle) //determines proper triangle through triangle inequality
    {
        //check whether sides are 0... not needed but keep anyways
        if(triangle.getSideA() == 0 || triangle.getSideB() == 0 || triangle.getSideC() == 0)
        {
            boolean proper = false;
            return proper;
        }
        else //check triangle inequality theorem
        {
            int largestIndex = getLargestIndex(triangle);
            double sumTwoSides = 0; //sum of sides that aren't largest/hypotenuse

            if (largestIndex == 0)
                sumTwoSides = getSideB() + getSideC();
            else if (largestIndex == 1)
                sumTwoSides = getSideA() + getSideC();
            else if (largestIndex == 2)
                sumTwoSides = getSideA() + getSideB();

            return (sumTwoSides > getSideArray(largestIndex));//triangle inequality returns true if real triangle
        }
    }
    private int getLargestIndex(Triangle triangle) //returns index of largest side (0,1,2)
    {
        int largestIndex = 0; //start at first index being largest
        double largest = -1_000_000; //store largest side
        for (int i = 0; i < 3; i++)
        {
            if (getSideArray(i) >= largest)//if value at index is greater
            {
                largest = getSideArray(i); //set current largest triangle side
                largestIndex = i; //store largest index
            }
        }
        return largestIndex;
    }
    public void setTriangle(double a, double b, double c) //set triangle sides
    {
        setSideA(a);
        setSideB(b);
        setSideC(c);
        setSidesArray(a, b, c);
    }
    public boolean isEquilateral(Triangle triangle)
    {
        return ((triangle.getSideA() == triangle.getSideB()) && (triangle.getSideA() == triangle.getSideC()));
    }
    public boolean isIsosceles(Triangle triangle)
    {
        return ((triangle.getSideA() == triangle.getSideB() && triangle.getSideA() != triangle.getSideC()) ||
                (triangle.getSideA() == triangle.getSideC() && triangle.getSideA() != triangle.getSideB()) ||
                (triangle.getSideB() == triangle.getSideC() && triangle.getSideB() != triangle.getSideA()));
    }
    public boolean isScalene(Triangle triangle)
    {
        return (triangle.getSideA() != triangle.getSideB() && triangle.getSideA() != triangle.getSideC());
    }
    private double getSideArray(int index) //return double value at array index
    {
        return this.sidesArray[index];
    }
    private void setSidesArray(double a, double b, double c) //sets side array with constructor
    {
        this.sidesArray[0] = a;
        this.sidesArray[1] = b;
        this.sidesArray[2] = c;
    }
    private double getSideA()
    {
        return this.sideA;
    }
    private double getSideB()
    {
        return this.sideB;
    }
    private double getSideC()
    {
        return this.sideC;
    }
    private void setSideA(double sideA)
    {
        this.sideA = sideA;
    }
    private void setSideB(double sideB)
    {
        this.sideB = sideB;
    }
    private void setSideC(double sideC)
    {
        this.sideC = sideC;
    }

}

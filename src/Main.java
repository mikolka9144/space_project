import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Simulation simp = new Simulation();
        int first_U1_cost = simp.estimate_cost_of_cardio_test("phase_1.txt",RocketType.U1);
        int first_U2_cost = simp.estimate_cost_of_cardio_test("phase_1.txt",RocketType.U2);
        int second_U1_cost = simp.estimate_cost_of_cardio_test("phase_2.txt",RocketType.U1);
        int second_U2_cost = simp.estimate_cost_of_cardio_test("phase_2.txt",RocketType.U2);
        System.out.printf("Total cost of tests is: %d million $%n",first_U1_cost+first_U2_cost+second_U1_cost+second_U2_cost);
    }
}
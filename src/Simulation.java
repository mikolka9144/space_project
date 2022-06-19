import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    /**
     *
     * @return
     * Returns amount of money spent on tests
     */
    public int estimate_cost_of_cardio_test(String package_filename, RocketType rocketType) throws FileNotFoundException {
        System.out.println("Mission: "+package_filename);
        ArrayList<Integer> cardio_1 = sumCardioForPackage(package_filename);
        int atempts = do_rocket_test(rocketType,cardio_1);
        System.out.printf("Rockets %s took %d attempts%n",rocketType.name,atempts);
        return atempts*rocketType.cost;
    }

    /**
     * Executes a test for launching rocket
     * @return
     * returns a number of launches necessary to transfer everything in cardio
     */
    public int do_rocket_test(RocketType rocketType,ArrayList<Integer> cardio){
        ArrayList<Rocket> rockets = new ArrayList<>();
        Rocket curr_rocket = new Rocket(rocketType);
        for (int item : cardio) {
            if(curr_rocket.conHandle(item)) curr_rocket.Handle(item);
            else {
                rockets.add(curr_rocket);
                curr_rocket = new Rocket(rocketType);
                // don't mind me, I'm just going to assume, that empty rocket can handle given item
                curr_rocket.Handle(item);
            }
        }
        int atempts = 0;
        for (Rocket rocket: rockets) {
            atempts += rocket.SimulateLaunch();
        }
        return atempts;
    }
    private ArrayList<Integer> sumCardioForPackage(String package_filename) throws FileNotFoundException {
        File file = new File(package_filename);
        Scanner reader = new Scanner(file);
        ArrayList<Integer> total_cordio = new ArrayList<>();
        while (reader.hasNextLine()){
            String[] cardio_str = reader.nextLine().split("=");
            total_cordio.add(Integer.parseInt(cardio_str[cardio_str.length-1]));
        }
        return total_cordio;
    }
}

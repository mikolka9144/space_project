public class Rocket {
    private final RocketType rocketType;
    private int cargo_in_kilos;

    public float getCrashChance() {
        float fullness_ratio = cargo_in_kilos/ (float)rocketType.max_weight;
        return rocketType.land_crash_chance*fullness_ratio;
    }

    public float getExplosionChance() {
        float fullness_ratio = cargo_in_kilos/ (float)rocketType.max_weight;
        return  rocketType.launch_explosion_chance* fullness_ratio;
    }


    Rocket(RocketType rocketType) {
        this.rocketType = rocketType;
    }
    public boolean conHandle(int item_size){
        return item_size+cargo_in_kilos< rocketType.max_weight;
    }
    public void Handle(int item_size){
        cargo_in_kilos += item_size;
    }

    /**
     * Simulates a full flight cycle (Starts and lands)
     * @return number of attempts necessary for successful cycle
     */
    public int SimulateLaunch(){
        int i = 1;
        while (true){
            if (SimulateCycle()) return i;
            System.out.println("Rocket Crashed!!!");
            i++;
        }
    }
    private boolean SimulateCycle(){
        //Math.random() generated a random number from 0.0 to 1.0
        return getCrashChance()<Math.random() && getExplosionChance()<Math.random();
    }
}



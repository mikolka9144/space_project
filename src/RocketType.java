public class RocketType {
    public String name;
    public int cost;
    public int max_weight;
    public float launch_explosion_chance;
    public float land_crash_chance;

    RocketType(String name,int cost_in_milions, int max_cargo_in_kilos, float launch_explosion_chance, float land_crash_chance){
        this.name = name;

        this.cost = cost_in_milions;
        this.max_weight = max_cargo_in_kilos;
        this.launch_explosion_chance = launch_explosion_chance;
        this.land_crash_chance = land_crash_chance;
    }
    public static RocketType U1 = new RocketType("U-1",100,18000,0.05f,0.01f);
    public static RocketType U2 = new RocketType("U-2",120,29000,0.04f,0.08f);
}

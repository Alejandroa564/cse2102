public class CarRunner {

    public static void main(String[] args) {

        // Instantiate a HybridVehicle object
        HybridVehicle myHybrid = new HybridVehicle();

        // Set costs of gasoline and electricity
        myHybrid.setCostPerGallon(3.50);
        myHybrid.setCostPerKWh(0.24);

        // Fully Gas Mode Example
        myHybrid.setMilesfromGas(120.0);   // 120 miles driven on gasoline
        myHybrid.setGallonsfromGas(6.0);   // 6 gallons used
        double gasMPG = myHybrid.calcGasMPG();
        System.out.println("MPG in fully gas mode: " + gasMPG);

        // Fully Electric Mode Example
        myHybrid.setElectricMiles(300.0);  // 300 miles driven on electric
        myHybrid.setTotalkWh(70.0);        // 70 kWh used
        double MPGe = myHybrid.calcMPGe();
        System.out.println("MPGe in fully electric mode: " + MPGe);

        // Hybrid Mode (Average Efficiency)
        double averageHybridMPG = myHybrid.calcAverageHybridEfficiency();
        System.out.println("Average MPG in hybrid mode: " + averageHybridMPG);

        // Cost calculation examples
        double gasTripCost = myHybrid.calcGasCost(120.0);  // Cost of a 120-mile trip in gas mode
        System.out.println("Cost for 120 miles in gas mode: $" + gasTripCost);

        double electricTripCost = myHybrid.calcElectricCost(120.0);  // Cost of a 120-mile trip in electric mode
        System.out.println("Cost for 120 miles in electric mode: $" + electricTripCost);
    }
}

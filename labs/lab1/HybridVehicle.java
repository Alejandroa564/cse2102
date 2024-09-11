public class HybridVehicle implements ElectricInterface, GasolineInterface {

    private double gasMiles;
    private double electricMiles;
    private double gallons;
    private double kWh;
    private double costPerGallon;
    private double costPerKWh;
    
    private final double MPG_E = 33.7;

    // Calculate Gas MPG
    public double calcGasMPG() {
        if (gallons == 0) return 0;  // Prevent division by zero
        return gasMiles / gallons;
    }

    // Calculate Electric MPGe
    public double calcMPGe() {
        if (kWh == 0) return 0;  // Prevent division by zero
        return (electricMiles / kWh) * MPG_E;
    }

    // Gasoline methods
    public void setMilesfromGas(double miles) {
        this.gasMiles = miles;
    }

    public void setGallonsfromGas(double gallons) {
        this.gallons = gallons;
    }

    public void setCostPerGallon(double cost) {
        this.costPerGallon = cost;
    }

    public double getCostPerGallon() {
        return this.costPerGallon;
    }

    // Electric methods
    public void setElectricMiles(double totalElectricMiles) {
        this.electricMiles = totalElectricMiles;
    }

    public void setTotalkWh(double totalkWh) {
        this.kWh = totalkWh;
    }

    public void setCostPerKWh(double cost) {
        this.costPerKWh = cost;
    }

    public double getCostPerKWh() {
        return this.costPerKWh;
    }

    // Hybrid efficiency
    public double calcAverageHybridEfficiency() {
        double gasMPG = calcGasMPG();
        double MPGe = calcMPGe();
        return (gasMPG + MPGe) / 2;
    }

    // Calculate cost of gasoline mode
    public double calcGasCost(double distance) {
        return (distance / calcGasMPG()) * getCostPerGallon();
    }

    // Calculate cost of electric mode
    public double calcElectricCost(double distance) {
        return (distance / calcMPGe()) * getCostPerKWh();
    }
}

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HybridVehicleTest {

    private HybridVehicle hybrid;

    @Before
    public void setUp() {
        // Set up a new HybridVehicle instance before each test
        hybrid = new HybridVehicle();
        hybrid.setCostPerGallon(3.50);  // Set default cost for gasoline
        hybrid.setCostPerKWh(0.24);     // Set default cost for electricity
    }

    @Test
    public void testCalcGasMPG() {
        // Set miles and gallons for gas mode
        hybrid.setMilesfromGas(120.0);
        hybrid.setGallonsfromGas(6.0);

        // Expecting 120 miles / 6 gallons = 20 MPG
        assertEquals(20.0, hybrid.calcGasMPG(), 0.001);
    }

    @Test
    public void testCalcMPGe() {
        // Set miles and kWh for electric mode
        hybrid.setElectricMiles(300.0);
        hybrid.setTotalkWh(70.0);

        // Expecting (300 miles / 70 kWh) * 33.7 kWh = 144.43 MPGe
        assertEquals(144.43, hybrid.calcMPGe(), 0.01);
    }

    @Test
    public void testCalcAverageHybridEfficiency() {
        // Set up for gas mode
        hybrid.setMilesfromGas(120.0);
        hybrid.setGallonsfromGas(6.0);

        // Set up for electric mode
        hybrid.setElectricMiles(300.0);
        hybrid.setTotalkWh(70.0);

        // Average MPG = (20 MPG from gas mode + 144.43 MPGe from electric mode) / 2 = 82.215
        assertEquals(82.215, hybrid.calcAverageHybridEfficiency(), 0.001);
    }

    @Test
    public void testCalcGasCost() {
        // Set up for gas mode
        hybrid.setMilesfromGas(120.0);
        hybrid.setGallonsfromGas(6.0);

        // Cost for 120 miles with 20 MPG and $3.50 per gallon = 120 miles / 20 MPG * $3.50 = $21.00
        assertEquals(21.00, hybrid.calcGasCost(120.0), 0.001);
    }

    @Test
    public void testCalcElectricCost() {
        // Set up for electric mode
        hybrid.setElectricMiles(300.0);
        hybrid.setTotalkWh(70.0);

        // Cost for 120 miles with 144.43 MPGe and $0.24 per kWh = 120 miles / 144.43 MPGe * $0.24 = $0.199
        assertEquals(0.199, hybrid.calcElectricCost(120.0), 0.001);
    }

    @Test
    public void testSetCostPerGallon() {
        // Set the cost per gallon and verify it is set correctly
        hybrid.setCostPerGallon(3.80);
        assertEquals(3.80, hybrid.getCostPerGallon(), 0.001);
    }

    @Test
    public void testSetCostPerKWh() {
        // Set the cost per kWh and verify it is set correctly
        hybrid.setCostPerKWh(0.26);
        assertEquals(0.26, hybrid.getCostPerKWh(), 0.001);
    }
}

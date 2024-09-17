
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CeilingFanProgramTest {

    @Test
    void testInitialFanState() {
        CeilingFanProgram fan = new CeilingFanProgram();
        assertEquals(0, fan.getSpeed());
        assertFalse(fan.isReversed());
    }

    @Test
    void testPullingCordSpeed() {
        CeilingFanProgram fan = new CeilingFanProgram();
        fan.pullingCordSpeed();
        assertEquals(1, fan.getSpeed());

        fan.pullingCordSpeed();
        assertEquals(2, fan.getSpeed());

        fan.pullingCordSpeed();
        assertEquals(3, fan.getSpeed());

        fan.pullingCordSpeed(); // Back to off
        assertEquals(0, fan.getSpeed());
    }

    @Test
    void testPullingCordDirection() {
        CeilingFanProgram fan = new CeilingFanProgram();
        assertFalse(fan.isReversed());

        fan.pullingCordDirection();
        assertTrue(fan.isReversed());

        fan.pullingCordDirection();
        assertFalse(fan.isReversed());
    }

    @Test
    void testPullingSpeedAndDirectionTogether() {
        CeilingFanProgram fan = new CeilingFanProgram();
        fan.pullingCordSpeed(); // Speed 1
        fan.pullingCordDirection(); // Reverse

        assertEquals(1, fan.getSpeed());
        assertTrue(fan.isReversed());

        fan.pullingCordSpeed(); // Speed 2
        assertEquals(2, fan.getSpeed());
        assertTrue(fan.isReversed());

        fan.pullingCordSpeed(); // Speed 3
        fan.pullingCordDirection(); // Back to normal direction
        assertEquals(3, fan.getSpeed());
        assertFalse(fan.isReversed());

        fan.pullingCordSpeed(); // Back to off
        assertEquals(0, fan.getSpeed());
        assertFalse(fan.isReversed());
    }
}

package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class AlarmTest {

    private Alarm alarm;
    private Sensor sensor;

    @Before
    public void prepare() {
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmOnAtLowPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(14.0);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmOnAtHighPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(25.0);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmOffAtNormalPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(19.0);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }
}
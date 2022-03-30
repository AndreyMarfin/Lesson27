import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class PedometerManagerTest {
    @Test
    public void compareToTest() {
        PedometerManager p1 = new PedometerManager();
        PedometerManager p2 = new PedometerManager();

        p1.add(1, 12);
        p1.add(2, 8);

        p2.add(1, 25);
        p2.add(2, 32);

        int expected = -37;
        int actual = p1.compareTo(p2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareTest(){
        PedometerManager p1 = new PedometerManager();
        PedometerManager p2 = new PedometerManager();

        p1.add(1, 12);
        p1.add(2, 8);
        p1.add(3, 12);
        p1.add(-3, 12);

        p2.add(1, 25);
        p2.add(2, 32);
        p2.add(2, -32);
        p2.add(3, 8);
        p2.add(4, 12);
        p2.add(4, 12);

        PedometerManagerComparator comparator = new PedometerManagerComparator(10);
        int expected = -1;
        int actual = comparator.compare(p1,p2);
        Assertions.assertEquals(expected, actual);

    }
}

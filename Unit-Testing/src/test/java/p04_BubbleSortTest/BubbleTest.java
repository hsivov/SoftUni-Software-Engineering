package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testBubbleSort() {
        int[] numbers = {7, 9, 17, 0, -5, -13, 72, 1, 102, 43};
        int[] sorted = {-13, -5, 0, 1, 7, 9, 17, 43, 72, 102};

        Bubble.sort(numbers);

        assertArrayEquals(sorted, numbers);
    }

}
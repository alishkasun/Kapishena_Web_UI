package TriangleTest;

import Triangle.Calculation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculationTest {


    @ParameterizedTest
    @MethodSource("getTriangleSides")
    public void testTriangleArea(int sideA, int sideB, int sideC, double expectedArea) {
        double actualArea = Calculation.triangleArea(sideA, sideB, sideC);
        assertEquals(expectedArea, actualArea, 0);
    }

    private static Stream<Arguments> getTriangleSides() {
        return Stream.of(
                Arguments.of(0, 0, 0, 0),
                Arguments.of(1, 1, 2, 3)
        );
    }


}

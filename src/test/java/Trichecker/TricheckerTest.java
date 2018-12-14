package Trichecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TricheckerTest {

	@Test
	void illegalValuesShouldError() {
		assertEquals(Result.ERROR, Trichecker.Check(0,1,2));
		assertEquals(Result.ERROR, Trichecker.Check(Integer.MIN_VALUE,3,-1));
	}

	@Test
	void badArgumentNumberShouldError() {
		assertEquals(Result.ERROR, Trichecker.Check());
		assertEquals(Result.ERROR, Trichecker.Check(1,2,3,4,5));
	}

	@Test
	void maxIntValuesShouldNotOverflow() {
		assertEquals(Result.ISOCELES, Trichecker.Check(Integer.MAX_VALUE-1, Integer.MAX_VALUE-1, Integer.MAX_VALUE));
	}

	@Test
	void shouldNoTriangle() {
		assertEquals(Result.NO_TRIANGLE, Trichecker.Check(100,2,3));
		assertEquals(Result.NO_TRIANGLE, Trichecker.Check(Integer.MAX_VALUE,1,1));
	}

	@Test
	void shouldEquilateral() {
		assertEquals(Result.EQUILATERAL, Trichecker.Check(1,1,1));
		assertEquals(Result.EQUILATERAL, Trichecker.Check(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE));
	}

	@Test
	void shouldIsoceles() {
		assertEquals(Result.ISOCELES, Trichecker.Check(1,2,2));
		assertEquals(Result.ISOCELES, Trichecker.Check(Integer.MAX_VALUE,Integer.MAX_VALUE,1));
	}

	@Test
	void shouldScalene() {
		assertEquals(Result.SCALENE, Trichecker.Check(1,2,3));
		assertEquals(Result.SCALENE, Trichecker.Check(Integer.MAX_VALUE,1,Integer.MAX_VALUE-1));
	}

	@Test
	void main2() {

	}
}
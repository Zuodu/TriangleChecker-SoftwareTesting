package Trichecker;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

class Trichecker {

	/**
	 * @param in Array of 3 Integers forming the sides of the triangle
	 * @return Result of the analysis which is a type of triangle
	 */
	static Result Check(Integer... in) {
		ArrayList<Integer> args = new ArrayList<>(Arrays.asList(in));
		//sanity check
		if (args.size() < 3 || args.size() > 3 || Arrays.stream(in).anyMatch(n -> n <= 0)) {
			System.err.println("Wrong number of arguments. Must be 3 positive integers > 0");
			return Result.ERROR;
		}
		//Parsing of the arguments
		Collections.sort(args);
		if ((long) args.get(0) + (long) args.get(1) < (long) args.get(2)) {
			System.out.println("The triangle is No-triangle.");
			return Result.NO_TRIANGLE;
		}
		//remove duplicates
		args = args.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
		//identifying the triangle properties
		switch (args.size()) {
			case 1:
				System.out.println("The triangle is Equilateral.");
				return Result.EQUILATERAL;
			case 2:
				System.out.println("The triangle is Isoceles.");
				return Result.ISOCELES;
			default:
				System.out.println("The triangle is Scalene.");
				return Result.SCALENE;
		}
	}
}

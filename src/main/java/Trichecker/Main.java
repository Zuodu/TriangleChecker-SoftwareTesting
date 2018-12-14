package Trichecker;

import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Trichecker.Check(Stream.of(args).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new));
	}
}

package chapter3;

import java.util.Scanner;

import common.Log;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class Gugudan {

	public static void main(String[] args) {
		Gugudan example = new Gugudan();
		//example.reactiveV1();
		example.reactiveV2();
	}

	private void reactiveV1() {
		Scanner in = new Scanner(System.in);
		System.out.println("Gugudan Input:");
		int dan = Integer.parseInt(in.nextLine());
		
		Observable<Integer> source = Observable.range(1, 9);
		source.subscribe(row -> System.out.println(dan + " * " + row + " = " + dan*row));
		
	}
	
	private void reactiveV2() {
		Scanner in = new Scanner(System.in);
		System.out.println("Gugudan Input:");
		int dan = Integer.parseInt(in.nextLine());
		
		Function<Integer, Observable<String>> getGugudan = number -> Observable.range(1,9).map(row ->
			number + " * " + row + " = " + number*row
				);
		
		Observable<String> source = Observable.just(dan).flatMap(getGugudan);
		source.subscribe(System.out::println);
		
		
	}
}

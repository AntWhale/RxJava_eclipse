package rxjava;

import common.Order;
import io.reactivex.Observable;
import io.reactivex.Single;

public class SingleExample {

	public static void main(String[] args) {
		/*
		 * Single<String> source = Single.just("Hello Single");
		 * source.subscribe(System.out::println);
		 */
		
		Observable<String> source = Observable.just("Hello Single");
		Single.fromObservable(source)
		.subscribe(System.out::println);
		
		Observable.just("Hello Single2")
		.single("default item")
		.subscribe(System.out::println);
		
		String[] colors = {"Red", "Blue", "Gold"};
		Observable.fromArray(colors)
		.first("default value")
		.subscribe(System.out::println);
		
		Observable.empty()
		.single("default value")
		.subscribe(System.out::println);
		
		Observable.just(new Order("ORD-1"), new Order("ORD-2"))
		.take(1)
		.single(new Order("default order"))
		.subscribe(System.out::println);
	}
}

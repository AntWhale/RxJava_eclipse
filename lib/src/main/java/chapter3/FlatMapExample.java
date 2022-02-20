package chapter3;

import common.Log;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class FlatMapExample {

	public static void main(String[] args) {
		FlatMapExample example = new FlatMapExample();
		example.marbleDiagram();
	}
	
	private void marbleDiagram() {
		Function<String, Observable<String>> getDoubleDiamonds = 
				ball -> Observable.just(ball + "<>", ball + "<>");
				
		String[] balls = {"1", "3", "5"};
		
		Observable<String> source = Observable.fromArray(balls)
		.flatMap(getDoubleDiamonds);
		source.subscribe(Log::i);
	}

}

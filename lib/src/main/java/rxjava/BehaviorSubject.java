package rxjava;

public class BehaviorSubject {

	public static void main(String[] args) {
		BehaviorSubject example = new BehaviorSubject();
		example.marbleDiagram();
	}

	public void marbleDiagram() {
		io.reactivex.subjects.BehaviorSubject<String> subject = io.reactivex.subjects.BehaviorSubject.createDefault("6");
		subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
		subject.onNext("1");
		subject.onNext("3");
		subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
		subject.onNext("5");
		subject.onComplete();
	}
}

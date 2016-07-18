package name.yuhongliang.designpatterns.headfirst.strategy;

public class Squeak implements QuackBehavior {
	public void quack() {
		System.out.println("Squeak");
	}
}
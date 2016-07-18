package name.yuhongliang.designpatterns.headfirst.strategy;

public class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}

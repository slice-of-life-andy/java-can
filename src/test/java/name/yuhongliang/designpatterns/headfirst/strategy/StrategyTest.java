package name.yuhongliang.designpatterns.headfirst.strategy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andy on 16-7-18.
 */
public class StrategyTest {

    @Test
    public void test() {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
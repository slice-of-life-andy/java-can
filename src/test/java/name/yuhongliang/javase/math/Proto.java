package name.yuhongliang.javase.math;

import java.util.ArrayList;

/**
 * Created by andy on 16-9-27.
 */
public class Proto implements Cloneable{
    private final int i = 1;
    private ArrayList list = new ArrayList();
    @Override
    protected Proto clone() throws CloneNotSupportedException {
        Proto cloneObject = (Proto) super.clone();
        cloneObject.list = (ArrayList) this.list.clone();

        return cloneObject;
    }
}

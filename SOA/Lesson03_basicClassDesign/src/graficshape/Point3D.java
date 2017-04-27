package graficshape;

/**
 * Created by hackeru on 2/7/2017.
 */
public class Point3D extends Point {
    int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(int z) {
        this.z = z;
    }

    @Override
    protected String printMe() {
        return super.printMe()+","+z;
    }
}

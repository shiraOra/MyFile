package graficshape;

/**
 * Created by hackeru on 2/5/2017.
 */
public class Circle extends Shape{
    int x,y,radias;
    public Circle(){
        x=20;
        y=20;
        radias=10;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadias() {
        return radias;
    }

    /**
     * Set the value of the circle's radias
     * @param radias
     */
    public void setRadias(int radias) {
        this.radias = radias;
    }

    @Override
    public String toString() {
        return "center = ("+x+","+y+ ") and radias = "+radias;
    }
    @Override
    public double area(){
        return Math.PI*radias*radias;
    }
    void fillColor(){}

    @Override
    public double perimeter() {
        return 0;
    }
}


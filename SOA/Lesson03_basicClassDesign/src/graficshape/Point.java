package graficshape;

import java.lang.reflect.Field;

/**
 * Created by hackeru on 2/7/2017.
 */

public class Point {
    private int x;// FIXME: 2/7/2017
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point(){};
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

    // Clone Constructor
    public Point(Point other){
        this(other.x,other.y);
    }

    @Override
    public String toString() {
        return ("("+printMe()+")");
    }
    protected String printMe(){
        return(x+","+y);

    }

    public String toStringSarah() {
        StringBuilder res=new StringBuilder();
        res.append("(");
        Field[] fields = this.getClass().getSuperclass().getDeclaredFields();
        Field [] myFields=this.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                res.append(f.get(this));
                res.append(',');
            }
            for (int i = 0; i < myFields.length; i++) {
                res.append(myFields[i].get(this));
                if(i!=myFields.length-1)
                    res.append(',');
            }
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return res+")";
    }

}

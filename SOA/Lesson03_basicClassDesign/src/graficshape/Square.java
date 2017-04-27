package graficshape;

/**
 * Created by hackeru on 2/6/2017.
 */
public class Square extends Rectangle {
    public Square(){
        super(4,5);
    }
public void setSide(int side)
{
    super.setWidth(side);
    super.setHeight(side);
}
    @Override
    public void setHeight(int height) {
        setSide(height);
    }

    @Override
    public void setWidth(int width) {
        setSide(width);
    }

    /*רשימת המתודות שניתן להפעיל על אוביקט נקבעת על פי המצביע בג'אווה.
     סוג במצביע וסוג האוביקט לא חייבים להיות בדיוק אותו סוג
                הם יכולים להיות מסוגים שונים כל עוד יש בינהם קשר של ירושה    */
}

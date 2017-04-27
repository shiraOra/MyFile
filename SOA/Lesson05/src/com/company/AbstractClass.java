package com.company;

/**
 * Created by hackeru on 2/9/2017.
 */
public class AbstractClass {
//לא ניתן ליצור מופע ממחלקה אבסטרקטית אבל המצביע יכול להיות ממחלקה אבסטרקטטית
//המילה abstract לא מופיע ליד משתנים- רק ליד פונקציות אומחלקות
//מחלקה אבסטרקטית יכולה לירש ממחלקה לא אבסטרקטית ולהיפך
//מחלקה אבסטרקטית יכולה שיהיו לה מתודות לא אבסטרקטיות אבל מחלקה אבסטקטית לא יכולה שיהיו לה מתודות אבסטרקטיות


}

//המחלקה C יורשת מB שהיא אבסטרקטית B יורשת מA שגם היא אבסטרקטית
// מכיון שB היא אבסטרקטית היא צריכה לא חייבת לממש את המתודות של A
//אבל C חייבת לממש את המתודות האבסטרקטיות של A ושל B

abstract class A{
    abstract void func();
}

abstract class B extends A {
    abstract void func1();
}

class C extends B {

    // המילה  final בהגדרה של משתנה אומרת שלא ניתן לשנות את הערך במשתנה
    //לכן הוא לא מאפשר להגדיר מערך ריק כfinal כי זה מיותר.מה התועלת במערך שמצביע ל?null
    // ניתן להגדיר את הערך של final בעת ההגדרה של final או בבנאי של המחלקה. ואז הוא מאפשר ליצור מערל ריק
    private final int[][] numbers;

    public C(int[][] numbers) {
        this.numbers = numbers;
    }



    @Override
    void func1() {

    }

    @Override
    void func() {

    }
    // המילה final לפני מתודה אומרת שאי אפשר לדרוס את המתודה
    final void abc(){};
    }

    class D {
    static int x;
    final Point p;
    public D(Point p){
        this.p=p;
    }

    void func2()
    // מכיון שp הוגדר כ final לא ניתן לשנות את הערך שהוא מצביע אליו אבל ניתן לשנות את הערכים שבתוך הכתובת
    {
        //this.p=new Point(7,8);
        this.p.setX(8);
        //משתנה סטטי שייך למחלקה ולא למופע מהמחלקה
        D.x=9;


    }

    //פונקציה סטטית גם היא שייכת לאוביקט ולא למחלקה ולכן היא לא יודעת לטפל במשתנים של אוביקט אלא רק במשתנים סטטטים
        static void func3(){
        // הפונקציה מאפשרת להדפיס את x כי הוא סטטי
            System.out.println(x);
        // אבל לא מאפשרת להדפיס את p כי הוא משתנה של אוביקט
            //System.out.println(p);

        }
    }

//final אי אפשר לירש ממחלקות מסוג
// הביצועים של final משופרים אבל לא משתמשים בזה כדי לחסוך בביצועים
final class square {

}



//static -שייך למחלקה ולא לאוביקט שנוצר מהמחלקה





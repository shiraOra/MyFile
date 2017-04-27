package com.company;

public class Main {

    public static void main(String[] args) {
    // Anonymous Inner class
    //לא ניתן ליצור 2 אוביקטים מאותה המלחקה,
    // המחלקה מוגדרת רק ביצירת אוביקט
    Circle c=new Circle(){
        @Override
        public int area() {
            return 9;
        }
    };
    Circle cc=new Circle();
//    System.out.println(c.area()+" c");
//    System.out.println(cc.area()+" cc");
    Student Shira=new Student();
    Shira.cityId=Student.JERUSALEM;
    Shira.gender=Gender.FEMALE;
    //השמה למשתה מסוג ENUM זה יצירת אוביקט לא דרך הConstractor
    PrinterType myPrinterType=PrinterType.LASER;
        System.out.println(myPrinterType.name);
    /*switch (myPrinterType){
        case DOTMATRIX:
            System.out.println("dotmatrix");
            break;
        case INKJET:
            break;
        case LASER:
            break;
        case THERMAL:
            break;
        case THREE_DIMENSION:
            break;
    }*/
    }

    enum PrinterType{
        DOTMATRIX(4,"dotmatrix"),INKJET(3,"inkjet"),LASER(10,"laser"),THERMAL(1,"thermal"),THREE_DIMENSION(1,"3D");
        private int pageCapaciry;
        private String name;
        private PrinterType(int pageCapaciry,String name){
            this.pageCapaciry=pageCapaciry;
            this.name=name;
        }

        public int getPageCapaciry() {
            return pageCapaciry;
        }
    }
}

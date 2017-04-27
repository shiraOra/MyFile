package com.company;

/**
 * Created by hackeru on 2/12/2017.
 */



public class Shape {

    //static nested class
    //מחלקה שנמצאת בתוך מחלקה אחרת רק מטעמי ארגון וסדר,
    // ניתן להתיחס אליה בכל מקום אחר
    // רק צריך לתת את הקידומת של המחלקה שמכילה אותה

    public static class Color{
        private int red,green,blue;

        public Color(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public int getGreen() {
            return green;
        }

        public void setGreen(int green) {
            this.green = green;
        }

        public int getBlue() {
            return blue;
        }

        public void setBlue(int blue) {
            this.blue = blue;
        }
    }
}

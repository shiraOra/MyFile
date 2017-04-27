package com.company;

/**
 * Created by hackeru on 2/14/2017.
 */
/*public class MotionSensor {
    private motionListener listener;

    public void setListener(motionListener listener) {
        this.listener = listener;
    }
    void detectMotion(){
        if(listener!=null)
            listener.motionDetected(123);
    }
    interface motionListener{
    void motionDetected(int sensorId);
}
}*/
//המחלקה הזאת היא SENSOR היא יודעת לקלוט מידע מבחוץ. מידע זה חשוב לגורמים אחרים שהמחלקה לא מכירה--אותם גורמים הם הLISTENERS שלוף מאזינים למידע שהוא קולט
public class MotionSensor {
    private motionListener[] listeners;//מי שמאזין למידע שהSENSOR קולט
    int size;
    public MotionSensor() {
        listeners = new motionListener[10];
        size=0;
    }

    public void setListener(motionListener listener) {
        if(listener==null)
            return;
        if(size<this.listeners.length)
            this.listeners[size++] = listener;
    }
    void detectMotion(){
        for (int i=0;i<size;i++){
            this.listeners[i].motionDetected(123);
        }
    }
    //זה ממשך פנימי של LISTENER -- מגדיר פנקציות שמאפשרות להאזין לSENSOR
    interface motionListener{// nested interface--> we want to use API, not is-a or has-a relationship
        void motionDetected(int sensorId);
    }
}
//זה אזעקה שיודעת להאזין לגלאי תנועהץ מממשת את הממשק. ברגע שיש תנועה האזעקה מודעה לכך ותפעל בהתאם
class Siren implements MotionSensor.motionListener{

    @Override
    public void motionDetected(int sensorId) {
        System.out.println("ALERT AT" +sensorId);
    }
}

class View{}

class Button extends View{
    private OnClickListener listener;

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }
    void detectClick(){
        if (listener!=null)
            listener.onClick(this);
    }

    interface OnClickListener{
        void onClick(View view);
    }
}

class Police implements MotionSensor.motionListener{

    @Override
    public void motionDetected(int sensorId) {
        System.out.println("stop");

    }
}

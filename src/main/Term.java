package main;

import lab4.BasicTerm;

public class Term extends BasicTerm {
    private Day day;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getDuration() {
        return duration;
    }

    public Day getDay() {
        return day;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Term(int hour, int minute, Day day){
        this.hour=hour;
        this.minute=minute;
        this.duration=90;
        this.day=day;
    }
    @Override
    public String toString(){
        //minutes < 10 -> 0+ minutes
        if(this.minute<10)
            return "" + this.hour + ":" +"0"+this.minute + " [" + this.duration + "]";
        else
            return "" + this.hour + ":" +this.minute + " [" + this.duration + "]";

    }
    public boolean earlierThan(Term termin){
        if(this.hour < termin.hour) return true;
        if(this.hour > termin.hour) return false;
        else {
            if(this.minute <= termin.minute) return true;
            else return false;
        }
    }
    public boolean laterThan(Term termin){
        if(this.hour > termin.hour) return true;
        if(this.hour < termin.hour) return false;
        else {
            if(this.minute >= termin.minute) return true;
            else return false;
        }
    }
    public Term endTerm(Term termin) { //gdy podany termin jest wczesniej to wtedy duration -1
        if(this.earlierThan(termin)) {
            if(this.hour == termin.hour) this.duration = (termin.minute - this.minute);
            else {
                this.duration = (termin.hour - this.hour) * 60 + (termin.minute - this.minute);
            }
            return this;
        }
        else {
            this.duration = -1;
            return this;
        }
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        Term other = (Term) obj;
        if((other.hour == this.hour) && (this.minute == other.minute) && (this.duration == other.duration)) return true;
        else return false;
    }
    public Term endTerm() {
        Term termin = new Term(this.hour + (this.duration / 60),this.minute + (this.duration % 60),this.day);
        //this.hour = this.hour + (this.duration / 60);//this.hour + ((this.minute+this.duration)/60)
        //this.minute = this.minute + (this.duration % 60);
        if(termin.minute >= 60) {
            termin.hour = termin.hour + (termin.minute / 60);
            termin.minute = termin.minute % 60;
        }
        termin.duration = this.duration;
        return termin;
    }

}

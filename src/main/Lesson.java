package main;

import lab4.ITimetable;

public class Lesson {
    private Term term;
    private String name;
    private String teacherName;
    private int year;
    private boolean full_time;
    private ITimetable timetable;

    public ITimetable getTimetable() {
        return timetable;
    }

    public void setTimetable(ITimetable timetable) {
        this.timetable = timetable;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isFull_time() {
        return full_time;
    }

    public void setFull_time(boolean full_time) {
        this.full_time = full_time;
    }

    public static int checkStudies(Term term){  //method that checks if given term is whether full time studies valid-0 or not full time valid-1,exception returns 2
        if(term.getDay().ordinal()>=0 && term.getDay().ordinal() <4) {
            if(term.endTerm().earlierThan(new Term(20,0,term.getDay())) && term.laterThan(new Term(8,0,term.getDay()))) return 0;
            else return 2;
        }
        if(term.getDay().ordinal()==4) {
            if (term.endTerm().earlierThan(new Term(17, 0, term.getDay())) && term.laterThan(new Term(8, 0, term.getDay()))) return 0;
            if (term.endTerm().earlierThan(new Term(20, 0, term.getDay())) && term.laterThan(new Term(17, 0, term.getDay()))) return 1;
            else return 2;
        }
        if(term.getDay().ordinal()>4 && term.getDay().ordinal()<7){
            if(term.endTerm().earlierThan(new Term(20,0,term.getDay())) && term.laterThan(new Term(8,0,term.getDay()))) return 1;
            else return 2;
        }
        return 2;
    }
    public Lesson(ITimetable timetable,Term term, String name, String teacherName, int year){
        if(checkStudies(term)==0){
            this.term=term;
            this.name=name;
            this.teacherName=teacherName;
            this.year=year;
            this.full_time=true;
            this.timetable=timetable;
        }
        if(checkStudies(term)==1){
            this.term=term;
            this.name=name;
            this.teacherName=teacherName;
            this.year=year;
            this.full_time=false;
            this.timetable=timetable;
        }
        if(checkStudies(term)==2){
        }
    }

    @Override
    public String toString() { //tutaj dopisac to +0 przy minutach
        Day a=this.term.getDay();
        int b=this.term.getHour();
        String c;
        if(this.term.getMinute()<10) c="0"+this.term.getMinute();
        else c=""+this.term.getMinute();
        //int c=this.term.minute; //tu
        int d=this.term.endTerm().getHour();
        String e;
        if(this.term.endTerm().getMinute()<10) e = "0"+this.term.endTerm().getMinute();
        else e = ""+this.term.endTerm().getMinute();


        return this.name + " ("+a.toString()+" "+b+":"+c+"-"+d+":"+e+")";
    }
    public boolean earlierDay(){
        int type=checkStudies(this.term);
        this.term.setDay(this.term.getDay().prevDay());//=this.term.getDay().prevDay();
        if(checkStudies(this.term)==type){
            return true;
        }
        else{
            this.term.setDay(this.term.getDay().nextDay());//=this.term.getDay().nextDay();
            return false;
        }
    }
    public boolean laterDay(){
        int type=checkStudies(this.term);
        this.term.setDay(this.term.getDay().nextDay());//=this.term.getDay().nextDay();
        if(checkStudies(this.term)==type){
            return true;
        }
        else{
            this.term.setDay(this.term.getDay().prevDay());//=this.term.day.prevDay();
            return false;
        }
    }
    //public boolean earlierTime(){

    //}
    public boolean laterTime(){
        int type = checkStudies(this.term.endTerm());
        if(checkStudies(this.term)==type){
            this.term=this.term.endTerm();
            return true;
        }
        else{
            return false;
        }
    }
}

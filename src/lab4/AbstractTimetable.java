package lab4;

import main.Action;
import main.Lesson;
import main.Term;

import java.util.ArrayList;

import static main.Lesson.checkStudies;

public abstract class AbstractTimetable  implements ITimetable{

    public ArrayList<Lesson> Lessonlist;

    public void perform(Action[] Actions){
        //naprzemiennie kieruje procesem tranferowania zajęć
        int i=0;
        for(Action akcja: Actions){
            switch(akcja){
                //tutaj kazdy case i wywołanie metody later, earlier oraz day cosie, wołające canbetransferredto

            }
        }
    }
    public boolean busy(Term term){
        //czy istnieje termin w arrayliście
        for(Lesson lesson : Lessonlist){
            if(lesson.getTerm().equals(term)){
                return false;
            }
        }
        return true;
    }
    public boolean canBeTransferredTo(Lesson lesson,Term term){
        //przeszukuje tablicę zajęć pod względem zajętosci w danym terminie
        for(Lesson lekcja: Lessonlist){
            if(lekcja.getTerm().equals(term)) return false;
        }
        if(checkStudies(lesson.getTerm()) != checkStudies(term)) return false;
        return true;
    }
    public Object get(Term term){

        return null;
    }
    public boolean put(Lesson lesson){

        return true;
    }

}

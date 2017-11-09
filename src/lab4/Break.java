package lab4;

import main.Term;

public class Break extends BasicTerm{
    boolean skipBreaks;

    public Break(Term term,boolean skipBreaks){
        this.hour = term.getHour();
        this.minute = term.getMinute();
        this.duration = term.getDuration();
        this.skipBreaks = skipBreaks;
    }
    @Override
    public String toString(){
        return "Przerwa";
    }
    public Term getTerm(){
        Term term = new Term(this.hour,this.minute,null); //jezeli day jest nullem to wtedy obowiazuje caly tydzien
        term.setDuration(this.duration);
        return term;
    }

}

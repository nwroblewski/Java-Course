package lab4;

import main.Term;

public class Break extends BasicTerm{
    boolean skipBreaks;
    public Break(Term term){
        this.hour = term.getHour();
        this.minute = term.getMinute();
        this.duration = term.getDuration();
    }
    @Override
    public String toString(){
        return "Przerwa";
    }
    public Term getTerm(){
        Term term = new Term(this.hour,this.minute,null);
        term.setDuration(this.duration);
        return term;
    }

}

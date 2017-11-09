package main;

public enum Day {
    MON,
    TUE,
    WED,
    THU,
    FRI,
    SAT,
    SUN;
    @Override
    public String toString() {
        switch(this) {
            case MON: return "Poniedziałek";
            case TUE: return "Wtorek";
            case WED: return "Środa";
            case THU: return "Czwartek";
            case FRI: return "Piątek";
            case SAT: return "Sobota";
            case SUN: return "Niedziela";
        }
        return "";
    }
    public Day prevDay() {
        switch(this) {
            case MON: return Day.SUN;
            case TUE: return Day.MON;
            case WED: return Day.TUE;
            case THU: return Day.WED;
            case FRI: return Day.THU;
            case SAT: return Day.FRI;
            case SUN: return Day.SAT;
        }
        return null;
    }
    public  Day nextDay() {
        switch(this) {
            case MON: return Day.TUE;
            case TUE: return Day.WED;
            case WED: return Day.THU;
            case THU: return Day.FRI;
            case FRI: return Day.SAT;
            case SAT: return Day.SUN;
            case SUN: return Day.MON;
        }
        return null;
    }
}


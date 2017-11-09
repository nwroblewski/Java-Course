package test;

import main.Day;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DayTest{
    @Test
    public void nextdayTest(){
       assertEquals(Day.TUE,Day.MON.nextDay());
       assertEquals(Day.WED,Day.TUE.nextDay());
       assertEquals(Day.THU,Day.WED.nextDay());
       assertEquals(Day.FRI,Day.THU.nextDay());
       assertEquals(Day.SAT,Day.FRI.nextDay());
       assertEquals(Day.SUN,Day.SAT.nextDay());
       assertEquals(Day.MON,Day.SUN.nextDay());
       prevdayTest();
    }
    @Test
    public void prevdayTest(){
        assertEquals(Day.SUN,Day.MON.prevDay());
        assertEquals(Day.SUN,Day.MON.prevDay());
        assertEquals(Day.SUN,Day.MON.prevDay());
        assertEquals(Day.SUN,Day.MON.prevDay());
        assertEquals(Day.SUN,Day.MON.prevDay());
        assertEquals(Day.SUN,Day.MON.prevDay());
        assertEquals(Day.SUN,Day.MON.prevDay());
    }
}

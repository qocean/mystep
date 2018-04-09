package allTest;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Calendar {
    public static void main(String[] args){
        printCalendar(2018,4);
        getTime();
    }

    public static void printCalendar(int year , int month){
        LocalDate localDate = LocalDate.of(year , month , 1);
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        int dayLength = localDate.lengthOfMonth();     //获取当前月份天数
        for(int i=1 ; i<=dayLength ; i++){
            int dayValue = localDate.getDayOfWeek().getValue();
            if(dayValue!=6)
                System.out.print(i + "\t");
            else
                System.out.print(i + "\n");
            localDate = localDate.plusDays(1);
        }
        System.out.println();
    }

    public static void getTime(){
//        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        Clock clock = Clock.systemDefaultZone();
        LocalDateTime ldt = LocalDateTime.now(clock);
        System.out.println(ldt.toString());
    }
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADMIN;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author STAR
 */
public class FilterSearch {
        public static Timestamp dateToTimeStamp(String date_string) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Timestamp ts = new Timestamp(((java.util.Date)df.parse(date_string)).getTime());
        return ts;
    }

    public static Integer timestampToSeconds(String timestamp) {
        if (timestamp == null) return null;
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date dt = simpleDateFormat.parse(timestamp);
            long epoch = dt.getTime();
            return (int) (epoch/1000);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String searchByDate(String searchDate) throws Exception {
        
        int start_time = FilterSearch.timestampToSeconds(FilterSearch.dateToTimeStamp(searchDate).toString());
        int end_time = start_time + 86400;
            String select_all_for_specific_date = "SELECT `reg.no.` , `firstname`, `lastname` FROM student_records WHERE date BETWEEN " + start_time + " AND "  + end_time;
        System.out.println("search by date query is \n " + select_all_for_specific_date);
        return select_all_for_specific_date;
    }
    
    public static String filterByRange(String start_date, String end_date, String x) throws Exception{
        int start = FilterSearch.timestampToSeconds(FilterSearch.dateToTimeStamp(start_date).toString());
        int end = FilterSearch.timestampToSeconds(FilterSearch.dateToTimeStamp(end_date).toString());
        String query = "SELECT `reg.no.`,`firstname`,`lastname`,((COUNT(*)/"+x+")*100) AS ATTENDANCE\n" +
                        "FROM `student_records`      \n" +
                        "WHERE date BETWEEN  \n" + start + " AND " + end +
                        " GROUP BY `reg.no.`;";
        return query;
    }
    
    
    
    
    
    
}

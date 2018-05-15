package com.example.sachinsharma.cricfun;

import java.util.List;

/**
 * Created by sachinsharma on 1/2/18.
 */

public class ResultsView {
    List<ResultView> results;
    List<ResultView> teams;

    public ResultsView(){
        results=ResultView.listAll(ResultView.class);
        if(results.size()==0){
            ResultView result1=new ResultView("Ind \uD83C\uDDEE\uD83C\uDDF3", "\uD83C\uDDFF\uD83C\uDDE6 SA ", "290/All out", "2","Ind won by 30 runs");
            result1.save();
            ResultView result2=new ResultView("Aus \uD83C\uDDE6\uD83C\uDDFA", "\uD83C\uDDEC\uD83C\uDDE7 Eng", "171/2", "1","Aus won by 8 wickets");
            result2.save();
            ResultView result3=new ResultView("NZ \uD83C\uDDF3\uD83C\uDDFF", "\uD83C\uDDF9\uD83C\uDDF9 WI ", "289/9", "3","NZ won by 121 runs");
            result3.save();
            ResultView result4=new ResultView("Pak \uD83C\uDDF5\uD83C\uDDF0", "\uD83C\uDDEE\uD83C\uDDEA Ire ", "300/6", "2","Ire won by 8 runs");
            result4.save();
            ResultView result5=new ResultView("Sco \uD83C\uDFF4\uDB40\uDC67\uDB40\uDC62\uDB40\uDC73\uDB40\uDC63\uDB40\uDC74\uDB40\uDC7F", "\uD83C\uDDFF\uD83C\uDDE6 SA ", "171/All Out", "2","SA won by 30 runs");
            result5.save();
            ResultView result6=new ResultView("Ind \uD83C\uDDEE\uD83C\uDDF3", "\uD83C\uDDFF\uD83C\uDDE6 SA ", "252/6", "4","Ind won by 30 runs");
            result6.save();
            ResultView result7=new ResultView("Ind \uD83C\uDDEE\uD83C\uDDF3", "\uD83C\uDDE6\uD83C\uDDFA Aus", "290/All out", "2","Ind won by 30 runs");
            result7.save();
            ResultView result8=new ResultView("Ind \uD83C\uDDEE\uD83C\uDDF3", "\uD83C\uDDEE\uD83C\uDDEA Ire ", "190/All out", "2","Ind won by 130 runs");
            result8.save();
        }
    }

    public List<ResultView> getAllResults(){
        results=ResultView.listAll(ResultView.class);
        return results;
    }






    public List<ResultView> getResults(String team){
        results=ResultView.findWithQuery(ResultView.class,"select * from Result_View where team1=? || team2=?","team","team");
        return results;
    }

    public String toString(){
        return "ResultsView{"+
                "resultsview="+results+
                '}';
    }
}

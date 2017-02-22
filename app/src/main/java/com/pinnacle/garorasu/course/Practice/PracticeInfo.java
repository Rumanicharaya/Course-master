package com.pinnacle.garorasu.course.Practice;

import java.util.ArrayList;

/**
 * Created by Ideal on 2/20/2017.
 */

public class PracticeInfo {
    public static String[] practiceSerialno={"1","2","3","4","5","6","7","8","9","10"};
    private static String[] practiceTitle = {"Pinnacle","Pinnacle","Pinnacle","Pinnacle","Pinnacle","Pinnacle","Pinnacle","Pinnacle","Pinnacle","Pinnacle"};
    private static String practiceUrl = "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png";
    private static String practiceBrief = "comprehensive program";
    private static String[]practiceColor = {"#689F38","#FF8F00","#00B0FF","#F44336"};

    public static ArrayList<Practice> getAllLesson(){
        ArrayList<Practice> allPractice = new ArrayList<>();
        for(int i=0;i<practiceSerialno.length;i++){
            allPractice.add(new Practice(practiceSerialno[i], practiceTitle[i],practiceBrief));
        }
        return allPractice;
    }
}

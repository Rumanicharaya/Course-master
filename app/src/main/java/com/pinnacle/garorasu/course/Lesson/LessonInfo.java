package com.pinnacle.garorasu.course.Lesson;



import java.util.ArrayList;

/**
 * Created by Ideal on 2/18/2017.
 */

public class LessonInfo {
    private static String[] lessonSerialno={"1","2","3","4","5","6","7","8","9","10"};
    private static String[] lessonTitle = {"SSC CGL","SSC CGl","SSC CGL","SSC CGL","SSC CGL","SSC CGl","SSC CGL","SSC CGL","SSC CGL","SSC CGL"};
    private static String lessonBrief = "comprehensive program";
    private static String[] subjectColor = {"#689F38","#FF8F00","#00B0FF","#F44336"};
    private static String lessonUrl = "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png";


    public static ArrayList<Lesson> getAllLesson(){
        ArrayList<Lesson> allLessons = new ArrayList<>();
        for(int i=0;i<lessonSerialno.length;i++){
            allLessons.add(new Lesson(lessonTitle[i],lessonUrl,lessonBrief,lessonSerialno[i] ));
        }
        return allLessons;
    }
}

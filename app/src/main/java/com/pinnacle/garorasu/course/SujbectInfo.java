package com.pinnacle.garorasu.course;

import com.pinnacle.garorasu.course.Explore.Subject;

import java.util.ArrayList;



public class SujbectInfo {
    private static String[] subjectsTitle = {"English","Math","Reasoning","GK"};
    private static String subjectsUrl = "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/book-icon.png";
    private static String subjectsBrief = "A comprehensive program to boost your SSC CGL Preparations";
    private static String[] subjectColor = {"#689F38","#FF8F00","#00B0FF","#F44336"};

    public static ArrayList<Subject> getAllSubjects(){
        ArrayList<Subject> allSubjects = new ArrayList<>();
        for(int i=0;i<subjectsTitle.length;i++){
            allSubjects.add(new Subject(subjectsTitle[i],subjectsUrl,subjectsBrief,subjectColor[i]));
        }
        return allSubjects;
    }
}

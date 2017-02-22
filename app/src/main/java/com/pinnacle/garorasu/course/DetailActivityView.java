package com.pinnacle.garorasu.course;

import com.pinnacle.garorasu.course.Lesson.Lesson;
import com.pinnacle.garorasu.course.Practice.Practice;
import com.pinnacle.garorasu.course.Video.Video;

/**
 * Created by Ideal on 2/22/2017.
 */

public interface DetailActivityView {
    void lessonSelected(Lesson lesson);
    void practiceSelected(Practice practice);
    void videoSelected(Video video);
}

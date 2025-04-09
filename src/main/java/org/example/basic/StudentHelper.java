package org.example.basic;

public class StudentHelper {

    /* PROBLEM 1 */
    /*
     * You get a grade B if marks are between 51 and 80 (both inclusive). Except for Maths where the upper limit is increased by 10.
     */

    public boolean isGradeB(int marks, boolean isSubjectMaths) {
        return isSubjectMaths ? marks >= 51 && marks <= 90 : marks >= 51 && marks <= 80;
    }

    /* PROBLEM 2 */
	/*
	You are awarded a grade based on your marks.
	Grade A = 91 to 100, Grade B = 51 to 90, Otherwise Grade C
	Except for Maths where marks to get a Grade are 5 higher than required for other subjects.
	*/

    public String getGrade(int marks, boolean isSubjectMaths) {
        String grade = "C";

        if (isGradeA(marks, isSubjectMaths)) {
            grade = "A";
        } else if (isBGrade(marks, isSubjectMaths)) {
            grade = "B";
        }
        return grade;
    }

    private boolean isGradeA(int marks, boolean isSubjectMaths) {
        int lowerLimit = isSubjectMaths ? 95 : 90;
        return marks > lowerLimit;
    }

    private boolean isBGrade(int marks, boolean isSubjectMaths) {
        int lowerLimit = isSubjectMaths ? 55 : 50;
        return marks > lowerLimit && marks < 90;
    }

    /*  PROBLEM 3
     * You and your Friend are planning to enter a Subject Quiz.
     * However, there is a marks requirement that you should attain to qualify.
     *
     * Return value can be YES, NO or MAYBE.
     *
     * YES If either of you are very good at the subject(has 80 or more marks)
     * However, there is an exception that if either of you is not good in the subject(20 or less marks), it is NO.
     * In all other conditions, return MAYBE.
     *
     * However, the definition for good and not good are 5 marks higher if the subject is Mathematics.
     *
     * myMarks - your marks
     * friendsMarks - your friends marks
     */

    public String willQualifyForQuiz(int myMarks, int friendsMarks, boolean isSubjectMaths) {
        if ((isSubjectMaths ? myMarks <= 25 : myMarks <= 20) || (isSubjectMaths ? friendsMarks <= 25 : friendsMarks <= 20)) {
            return "NO";
        }
        if ((isSubjectMaths ? myMarks >= 85 : myMarks >= 80) || (isSubjectMaths ? friendsMarks >= 85 : friendsMarks >= 80)) {
            return "YES";
        }
        return "MAYBE";
    }

}
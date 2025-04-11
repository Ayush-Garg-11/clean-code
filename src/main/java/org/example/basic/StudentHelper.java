package org.example.basic;

public class StudentHelper {
    private static final int LOWER_LIMIT_GRADE_B = 51;
    private static final int UPPER_LIMIT_GRADE_B_NON_MATH = 80;
    private static final int UPPER_LIMIT_GRADE_B_MATH = 90;
    private static final int LOWER_LIMIT_B_GRADE_MATH = 55;
    private static final int LOWER_LIMIT_B_GRADE_NON_MATH = 50;
    private static final int LOWER_LIMIT_A_GRADE_MATH = 95;
    private static final int LOWER_LIMIT_A_GRADE_NON_MATH = 90;
    private static final int UPPER_LIMIT_NOT_GOOD_MARKS_NON_MATH = 20;
    private static final int UPPER_LIMIT_NOT_GOOD_MARKS_MATH = 25;
    private static final int LOWER_LIMIT_GOOD_MARKS_MATH = 85;
    private static final int LOWER_LIMIT_GOOD_MARKS_NON_MATH = 80;
    /* PROBLEM 1 */
    /*
     * You get a grade B if marks are between 51 and 80 (both inclusive). Except for Maths where the upper limit is increased by 10.
     */
    public boolean isGradeB(int marks, boolean isMaths) {
        return marks >= LOWER_LIMIT_GRADE_B && marks<=( isMaths ? UPPER_LIMIT_GRADE_B_MATH : UPPER_LIMIT_GRADE_B_NON_MATH);
    }

    /* PROBLEM 2 */
	/*
	You are awarded a grade based on your marks.
	Grade A = 91 to 100, Grade B = 51 to 90, Otherwise Grade C
	Except for Maths where marks to get a Grade are 5 higher than required for other subjects.
	*/

    public String getGrade(int mark, boolean isMaths) {
        String grade = "C";

        if (isGradeA(mark, isMaths))
            grade = "A";
        else if (isBGrade(mark, isMaths)) {
            grade = "B";
        }
        return grade;
    }

    private boolean isGradeA(int mark, boolean isMaths) {
        int lowerLimitForAGrade = isMaths ? LOWER_LIMIT_A_GRADE_MATH : LOWER_LIMIT_A_GRADE_NON_MATH;
        return mark > lowerLimitForAGrade;
    }

    private boolean isBGrade(int mark, boolean isMaths) {
        int lowerLimitGradeB = isMaths ? LOWER_LIMIT_B_GRADE_MATH : LOWER_LIMIT_B_GRADE_NON_MATH;
        int upperLimitGradeB = isMaths ? LOWER_LIMIT_A_GRADE_MATH : LOWER_LIMIT_A_GRADE_NON_MATH;
        return mark > lowerLimitGradeB && mark <= upperLimitGradeB;
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
     * marks1 - your marks
     * marks2 - your friends marks
     */

    public String willQualifyForQuiz(int marks1, int marks2, boolean isMaths) {
        if (isNotGood(marks1, isMaths) || isNotGood(marks2,isMaths)) return "NO";
        if (isGood(marks1, isMaths) || isGood(marks2, isMaths)) return "YES";
        return "MAYBE";
    }

    private static boolean isGood(int marks, boolean isMaths) {
        return marks >= (isMaths ? LOWER_LIMIT_GOOD_MARKS_MATH : LOWER_LIMIT_GOOD_MARKS_NON_MATH);
    }

    private static boolean isNotGood(int marks, boolean isMaths) {
        return marks <= (isMaths ? UPPER_LIMIT_NOT_GOOD_MARKS_MATH : UPPER_LIMIT_NOT_GOOD_MARKS_NON_MATH);
    }

}
package com.student.payload.messages;

// Class containing error messages related to student and grades operations
public class ErrorMessages {

    private ErrorMessages(){
    }

    //------------------------------------------STUDENT---------------------------------------------------
    public static final String STUDENT_REQUEST_NULL = "Error: StudentRequest cannot be null";
    public static final String NAME_NULL_EMPTY_DIGITS = "Error: Name must not be null, empty or contain digits. ";
    public static final String SURNAME_NULL_EMPTY_DIGITS = "Error: Surname must not be null, empty or contain digits.";
    public static final String STD_NUMBER_NULL_OR_EMPTY = "Error: StdNumber cannot be null or empty";
    public static final String STD_NUMBER_ALREADY_EXISTS = "Error: Student with the same student number already exists";

    //------------------------------------------GRADES----------------------------------------------------
    public static final String GRADES_NULL = "Error: Grades cannot be null";
    public static final String CODE_NULL_OR_EMPTY = "Error: Code cannot be null or empty";
    public static final String VALUE_NULL = "Error: Value cannot be null";
    public static final String VALUE_RANGE = "Error: The value cannot be greater than 100 or less than 0";
}

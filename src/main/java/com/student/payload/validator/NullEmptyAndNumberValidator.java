package com.student.payload.validator;

import com.student.payload.messages.ErrorMessages;
import com.student.payload.request.GradesRequest;
import com.student.payload.request.StudentRequest;

// Validator class for validating student requests and grades
public class NullEmptyAndNumberValidator {

    // Method to validate the student request
    public static void validateStudentRequest(StudentRequest studentRequest){
        if (studentRequest == null){
            throw new IllegalArgumentException(ErrorMessages.STUDENT_REQUEST_NULL);
        }

        if (isEmptyOrNull(studentRequest.getName())||studentRequest.getName().matches(".*\\d.*")){
            throw new IllegalArgumentException(ErrorMessages.NAME_NULL_EMPTY_DIGITS);
        }

        if (isEmptyOrNull(studentRequest.getSurname())||studentRequest.getSurname().matches(".*\\d.*")){
            throw new IllegalArgumentException(ErrorMessages.SURNAME_NULL_EMPTY_DIGITS);
        }

        if (isEmptyOrNull(studentRequest.getStdNumber())){
            throw new IllegalArgumentException(ErrorMessages.STD_NUMBER_NULL_OR_EMPTY);
        }
    }

    // Method to validate grades
    public static void validateGradesRequest(GradesRequest gradesRequest){
        if (gradesRequest==null){
            throw new IllegalArgumentException(ErrorMessages.GRADES_NULL);
        }

        if (isEmptyOrNull(gradesRequest.getCode())){
            throw new IllegalArgumentException(ErrorMessages.CODE_NULL_OR_EMPTY);
        }

        if (gradesRequest.getValue() == null){
            throw new IllegalArgumentException(ErrorMessages.VALUE_NULL);
        }
        if (gradesRequest.getValue()>100||gradesRequest.getValue()<0){
            throw new IllegalArgumentException(ErrorMessages.VALUE_RANGE);
        }
    }

    // Method to check if a string is empty or null
    private static boolean isEmptyOrNull(String str){
        return str == null || str.trim().isEmpty();
    }
}

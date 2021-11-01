package com.mentzikof.myPetClinic.model.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;

//https://newbedev.com/java-string-validation-using-enum-values-and-annotation
/*	
Usage of the above annotation is very simple

@ValidateString(acceptedValues={"Integer", "String"}, message="Invalid dataType")
String dataType;

*/
@Documented
@Constraint(validatedBy = ValidateStringImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@NotNull(message = "Value cannot be null")
@ReportAsSingleViolation
public @interface ValidateString {

    String[] acceptedValues();

    String message() default "Value is not valid";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { }; 
}

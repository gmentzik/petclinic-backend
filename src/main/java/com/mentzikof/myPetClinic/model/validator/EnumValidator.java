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

@JsonProperty("lead_id")
@EnumValidator(
    enumClazz = DefaultEnum.class,
    message = "This error is coming from the enum class"
)
private String leadId;

*/
@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@NotNull(message = "Value cannot be null")
@ReportAsSingleViolation
public @interface EnumValidator {

  Class<? extends Enum<?>> enumClazz();

  String message() default "Value is not valid";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}

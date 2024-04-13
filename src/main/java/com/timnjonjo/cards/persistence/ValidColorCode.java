package com.timnjonjo.cards.persistence;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ColorCodeValidator.class)
public @interface ValidColorCode {

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message()  default "Invalid hex color code";
}

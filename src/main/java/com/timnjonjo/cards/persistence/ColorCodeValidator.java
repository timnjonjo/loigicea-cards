package com.timnjonjo.cards.persistence;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ColorCodeValidator implements ConstraintValidator<ValidColorCode, String> {
    private static final String HEX_PATTERN = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

    @Override
    public boolean isValid(String hexCode, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(HEX_PATTERN);
        Matcher matcher = pattern.matcher(hexCode);

        if (!matcher.matches()) {
            return false;
        }

        try {
            Color.decode(hexCode);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

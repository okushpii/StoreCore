package com.soft.storecore.facade.validation;

import com.soft.storecore.facade.user.facade.UserFacade;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueConstraintValidator implements ConstraintValidator<EmailUniqueConstraint, String> {

    @Resource
    private UserFacade userFacade;

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return !userFacade.isUserExist(field);
    }
}

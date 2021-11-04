package validator;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import service.validation.UserValidationService;
import validator.constraint.NameAreadyExist;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class NameAreadyExistValidator implements ConstraintValidator<NameAreadyExist,String> {

    @Inject
    private UserValidationService userValidationService;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        try {
            userValidationService.findByName(name);
            return false;
        }catch (Exception e){
            log.error(e.getMessage());
            return true;
        }

    }
}

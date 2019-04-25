package entity;

import java.util.Objects;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AdditionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AddtionEntity.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AddtionEntity user = (AddtionEntity) target;
		if(Objects.nonNull(user.getValueOne()))
			{
			String s = String.valueOf(user.getValueOne());
			if(StringUtils.isEmpty(s))
				errors.rejectValue("valueOne","errorCode1","Should not be empty");
			}
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valueOne", "errorCode1", "Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valueTwo", "", "valueTwo is required");
//		ValidationUtils.rejectIfEmpty(errors, "gender", "gender.required");
//		ValidationUtils.rejectIfEmpty(errors, "country", "country.required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "aboutYou", "aboutYou.required");
//		AddtionEntity user = (AddtionEntity) target;
//		if(user.getCommunity().length == 0)
//		{
//			errors.rejectValue("community","community.required");
//		}
	}


}

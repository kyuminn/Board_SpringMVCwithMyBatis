package member.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import member.vo.MemberVo;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberVo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		
	}

}

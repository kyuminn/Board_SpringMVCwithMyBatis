package member.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import member.vo.MemberVo;

public class RegistValidator implements Validator {
	private static final String emailRegExp= "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
	private Pattern pattern;
	
	public RegistValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberVo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		MemberVo vo =(MemberVo)target;
		if (vo.getEmail()==null|| vo.getEmail().trim().isEmpty()) {
			errors.rejectValue("email","required");
		}else {
			Matcher matcher = pattern.matcher(vo.getEmail());
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad");
			}
		}
	}

}

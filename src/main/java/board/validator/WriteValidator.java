package board.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import board.vo.BoardVo;


public class WriteValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BoardVo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "required");
		ValidationUtils.rejectIfEmpty(errors, "writer", "required");
		ValidationUtils.rejectIfEmpty(errors, "content", "required");
		ValidationUtils.rejectIfEmpty(errors,"password" , "required");
		
	}
	
}

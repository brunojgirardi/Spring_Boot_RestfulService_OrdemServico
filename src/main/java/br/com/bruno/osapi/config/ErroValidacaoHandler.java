package br.com.bruno.osapi.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.bruno.osapi.config.dto.ErroFormularioDto;
import br.com.bruno.osapi.config.dto.MensagemDeErro;

@RestControllerAdvice
public class ErroValidacaoHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormularioDto> handle(MethodArgumentNotValidException exception) {
		List<ErroFormularioDto> dto = new ArrayList<>();

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroFormularioDto erro = new ErroFormularioDto(e.getField(), mensagem);
			dto.add(erro);
		});

		return dto;

	}

	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {

		String errorMessageDescription = ex.getLocalizedMessage();
		if (errorMessageDescription == null)
			//errorMessageDescription = ex.toString();
			errorMessageDescription = "Null Pointer Exception";
		MensagemDeErro mensagemErro = new MensagemDeErro(new Date(), errorMessageDescription);
		return new ResponseEntity<>(mensagemErro, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

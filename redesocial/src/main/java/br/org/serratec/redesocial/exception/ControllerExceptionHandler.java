package br.org.serratec.redesocial.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<String> erros = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			erros.add(error.getField() + ": " + error.getDefaultMessage());
		}

		ErroResposta erroResposta = new ErroResposta(status.value(), "Campos inválidos, verifique se está correto",
				LocalDateTime.now(), erros);

		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}

	@ExceptionHandler(EmailException.class)
	protected ResponseEntity<Object> handleEmailException(EmailException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}

	@ExceptionHandler(SenhaException.class)
	protected ResponseEntity<Object> handleEmailException(SenhaException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}

	@ExceptionHandler(NotFoundException.class)
	protected ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}

	@ExceptionHandler(FollowException.class)
	protected ResponseEntity<Object> handleFollowException(FollowException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}

	@ExceptionHandler(InvalidDateException.class)
	protected ResponseEntity<Object> handleInvalidDateException(InvalidDateException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}

}

package com.talk.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException {

		private static final long serialVersionUID = 1L;
		
		public RessourceNotFoundException (String message) {
			super(message);
		}
}

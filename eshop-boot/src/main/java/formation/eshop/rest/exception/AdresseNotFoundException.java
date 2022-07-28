package formation.eshop.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Adresse non trouvée")
public class AdresseNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

}

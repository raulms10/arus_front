package arus_frontend.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validaSoloLetras")
public class ValidadorSoloLetras implements Validator {
	
	private static final String MENSAJE_SOLO_LETRAS = "Por favor solo ingrese letras en el campo: ";

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object valor) throws ValidatorException {
		String labelInput = ""; 
		if (!String.valueOf(valor).matches("[a-zA-ZñÑ]*")) {
			labelInput = ((HtmlInputText) uiComponent).getLabel();
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, MENSAJE_SOLO_LETRAS+labelInput, MENSAJE_SOLO_LETRAS+labelInput));
		}
		
	}

}

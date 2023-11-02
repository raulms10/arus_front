package arus_frontend.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validaObligatorio")
public class ValidadorObligatorio implements Validator {
	
	private static final String MENSAJE_OBLIGATORIO = "Por favor ingrese la información de este campo";
	
	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object valor) throws ValidatorException {
		//HtmlInputText input = ((HtmlInputText) uiComponent);
		//System.out.println(input.getTitle() + " -- " + input.getLabel() + " -- " + input.getValidatorMessage());
		if (valor == null || String.valueOf(valor) == null || String.valueOf(valor).isEmpty()) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, MENSAJE_OBLIGATORIO, MENSAJE_OBLIGATORIO));
		}
		
	}

}

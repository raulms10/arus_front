package arus_frontend.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validaNumeroDocumento")
public class ValidaNumeroDocumento implements Validator {

	private static final String ID_TIPO_DOCUMENTO = "idTipoDoc";
	
	private static final String MENSAJE_CC = "Para el tipo de documento 'Cédula', solo está permitido ingresar máximo 10 caracteres de tipo número";
	private static final String MENSAJE_CE = "Para el tipo de documento 'Cédula de extranjería', solo está permitido ingresar máximo 14 caracteres entre letras y números";
	private static final String MENSAJE_RC = "Para el tipo de documento 'Registro Civil', solo está permitido ingresar caracteres de tipo número";
	private static final String MENSAJE_TI = "Para el tipo de documento 'Tarjeta de Identidad', solo está permitido ingresar caracteres de tipo número";
	
	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object valor) throws ValidatorException {
		String numDoc = String.valueOf(valor);
//		System.out.println("ValorNum: " + numDoc + " -- " + uiComponent.getClass() + " -- " + uiComponent.findComponent(ID_TIPO_DOCUMENTO).getClass()) ;
		HtmlSelectOneMenu selectTipoDoc = ((HtmlSelectOneMenu) uiComponent.findComponent(ID_TIPO_DOCUMENTO));
		String tipoDoc = String.valueOf(selectTipoDoc.getValue());
//		System.out.println("Tipo doc: " + tipoDoc);
		
		if("CC".equals(tipoDoc) && !numDoc.matches("\\d{1,10}")) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, MENSAJE_CC, MENSAJE_CC));
		} else if ("CE".equals(tipoDoc) && !numDoc.matches("[0-9a-zA-ZñÑ]{1,14}")) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, MENSAJE_CE, MENSAJE_CE));
		} else if ("RC".equals(tipoDoc) && !numDoc.matches("\\d*")) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, MENSAJE_RC, MENSAJE_RC));
		} else if ("TI".equals(tipoDoc) && !numDoc.matches("\\d*")) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, MENSAJE_TI, MENSAJE_TI));
		}		
	}
	
	

}

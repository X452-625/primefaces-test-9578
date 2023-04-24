package org.primefaces.test;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@Named
@FacesConverter(value = "selectItemConverter", managed = true)
public class SelectItemConverter implements Converter<TestView.SelectItem> {

  @Override public TestView.SelectItem getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
    if (value != null && value.trim().length() > 0) {
      try {
        return TestView.listAutoComplete.get(Integer.parseInt(value));
      }
      catch (NumberFormatException e) {
        throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid item."));
      }
    }
    else {
      return null;
    }
  }

  @Override public String getAsString(FacesContext facesContext, UIComponent uiComponent, TestView.SelectItem selectItem) {
    return selectItem != null ? selectItem.getLabel() : null;
  }
}

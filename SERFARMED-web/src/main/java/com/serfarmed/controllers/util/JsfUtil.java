package com.serfarmed.controllers.util;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

public class JsfUtil {

  public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
    int size = selectOne ? entities.size() + 1 : entities.size();
    SelectItem[] items = new SelectItem[size];
    int i = 0;
    if (selectOne) {
      items[0] = new SelectItem("", "---");
      i++;
    }
    for (Object x : entities) {
      items[i++] = new SelectItem(x, x.toString());
    }
    return items;
  }

  public static boolean isValidationFailed() {
    return FacesContext.getCurrentInstance().isValidationFailed();
  }

  public static void addErrorMessage(Exception ex, String defaultMsg) {
    String msg = ex.getLocalizedMessage();
    if (msg != null && msg.length() > 0) {
      addErrorMessage(msg);
    } else {
      addErrorMessage(defaultMsg);
    }
  }

  public static void addErrorMessages(List<String> messages) {
    for (String message : messages) {
      addErrorMessage(message);
    }
  }

  public static void addErrorMessage(String msg) {
    FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
    FacesContext.getCurrentInstance().addMessage(null, facesMsg);
  }
  
  public static void addWarnMessage(String msg) {
    FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN,msg, msg);
    FacesContext.getCurrentInstance().addMessage("Info", facesMsg);
  
  }
  

  public static void addSuccessMessage(String msg) {
    FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
    FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
  }
  
  public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
    }
     
    public void warn() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for PrimeFaces."));
    }
     
    public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
    }
     
    public void fatal() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
    }
  
  
  

  public static String getRequestParameter(String key) {
    return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
  }

  public static Object getObjectFromRequestParameter(String requestParameterName, Converter converter, UIComponent component) {
    String theId = JsfUtil.getRequestParameter(requestParameterName);
    return converter.getAsObject(FacesContext.getCurrentInstance(), component, theId);
  }

  public static enum PersistAction {

    CREATE,
    DELETE,
    UPDATE
  }
}

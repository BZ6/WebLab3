package web.twillice.lab3.converters;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

import java.util.regex.Pattern;


@FacesConverter(value = "YCoordinateConverter", managed = true)
public class YCoordinateConverter implements Converter<Double> {
    @Override
    public Double getAsObject(FacesContext facesContext, UIComponent uiComponent, String y) {
        if (y == null || y.isEmpty()) return null;
        if (!Pattern.matches("(?:-3|\\+?3)(?:[.,]0{1,15})?|(?:-[210]|\\+?[012])(?:[.,]\\d{1,15})?", y))
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "y: Value doesn't match the pattern.", ""));
        return Double.parseDouble(y.replace(",", "."));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Double y) {
        return y == null ? "" : y.toString();
    }
}

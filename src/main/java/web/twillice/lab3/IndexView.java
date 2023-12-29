package web.twillice.lab3;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Named @ViewScoped
@Getter
public class IndexView implements Serializable {
    private String currentTime;
    private String currentDate;
    { updateTime(); }

    public void updateTime() {
        currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM-dd-yyyy", Locale.ENGLISH));
    }
}

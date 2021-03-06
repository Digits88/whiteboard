package whiteboard.domain.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity(name = "Announcements")
public class Announcement extends Content implements Serializable {

    @NotEmpty
    @Column(length = 4000)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

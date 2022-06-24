package suptech.miag.bookservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BookModel {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ISBN;
    @Column(unique = true)
    private String title;
    private Long id_author;
    private Date date;
}

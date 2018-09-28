package hu.elte.keza.issuetracker.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "issues")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Issue extends BaseWithCreatedInfo implements Serializable{
    @Column
    @NotNull
    private String title;
        
    @NotNull
    @Column
    private String description;
    
    @NotNull
    @Column
    private String place;

    @NotNull
    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    @OneToMany(targetEntity = Message.class, mappedBy = "issue")
    private List<Message> messages;
    
    @ManyToMany(targetEntity = Label.class)
    @JoinTable
    private List<Label> labels;

}

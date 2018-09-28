package hu.elte.keza.issuetracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "labels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Label extends BaseEntity implements Serializable{
    
    @Column
    @NotNull
    private String text;
    
    @Column(updatable = false)
    @CreationTimestamp
    protected LocalDateTime createdAt;
    
    @JsonIgnore
    @ManyToMany(targetEntity = Issue.class, mappedBy = "labels")
    private List<Issue> issues;
    
}

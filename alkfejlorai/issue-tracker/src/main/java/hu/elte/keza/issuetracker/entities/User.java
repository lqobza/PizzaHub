package hu.elte.keza.issuetracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User extends BaseEntity implements Serializable{
    
    @NotNull
    @Column
    private String userName;
    
    @NotNull
    @Column
    private String password;
    
    @NotNull
    @Column
    private String emailAddress;
    
    @NotNull
    @Column
    private String permissionRuleCode;

    @JsonIgnore
    @OneToMany(targetEntity = Issue.class, mappedBy = "createdBy")
    private List<Issue> issues;
    
    @JsonIgnore
    @OneToMany(targetEntity = Message.class, mappedBy = "createdBy")
    private List<Message> messages;
}

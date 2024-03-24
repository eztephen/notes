package com.example.notes.models.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Table(name= "notes")
@SuperBuilder
@Entity
@DynamicUpdate //added so that only the modified parameters/columns are updated. not the whole row
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Note extends AbstractAuditingEntity {
    @NotEmpty(message = "Title cannot be empty")
    private String title;
    @NotBlank(message = "Body cannot be blank")
    @Size(min = 5, max= 2000, message = "Body size should 5 and 2000")
    private String body;
}

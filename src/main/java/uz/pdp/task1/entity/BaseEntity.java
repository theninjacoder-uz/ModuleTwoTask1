package uz.pdp.task1.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean active = true;

//    @CreatedBy
//    @Column(updatable = false)
//    private String createdBy;
//
//    @CreatedDate
//    @Column(updatable = false)
//    private Timestamp createdDate;
//
//    @LastModifiedBy
//    private String lastModifiedBy;
//
//    @LastModifiedDate
//    private Timestamp lastModifiedDate;

}

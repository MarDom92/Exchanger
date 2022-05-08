package pl.mardom92.Exchanger.model.entity;

import lombok.Getter;
import lombok.Setter;
import pl.mardom92.Exchanger.model.enums.OperationStatus;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class OperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    OperationStatus operationStatus;
    Date creationDate;
}

package com.hazalyarimdunya.audit;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//Lombok
@Getter
@Setter

public class AuditingAwareBaseDto {

    // Kim Ekledi
    private String createdBy;

    // Kim Ne zaman Ekledi
    private Date createdDate;

    // Kim Güncelledi
    private String lastUserBy;

    // Kim Ne Zaman Güncelledi
    private Date lastUserDate;
}

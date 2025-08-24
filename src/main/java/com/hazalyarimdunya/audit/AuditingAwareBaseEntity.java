package com.hazalyarimdunya.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter

// AUDITING
@EntityListeners(AuditingEntityListener.class)

// SUPER CLASS
@MappedSuperclass //ilgili sınıf veritabanında tablo oluşturmaz.alanlar ve getter/setter metotları, onu miras alan sınıfların tablolarında sütun olarak yer alır.

@JsonIgnoreProperties(value = {"created_date","last_user_date"},allowGetters = true)  // Backend'ten Frontend'e bu veriler gitmesin

abstract public class AuditingAwareBaseEntity implements Serializable {

    // SERILEŞTIRME
    public static final Long serialVersionUID = 1L;

    // Kim Ekledi
    @CreatedBy
    @Column(name = "created_by")
    @JsonIgnore
    private String createdBy;

    // Kim Ne zaman Ekledi
    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    // Kim Güncelledi
    @LastModifiedBy
    @Column(name = "last_user_by")
    @JsonIgnore
    private String lastUserBy;

    // Kim Ne Zaman Güncelledi
    @LastModifiedDate
    @Column(name = "last_user_date")
    private Date lastUserDate;

}

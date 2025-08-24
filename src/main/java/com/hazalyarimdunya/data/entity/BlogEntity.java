package com.hazalyarimdunya.data.entity;

import com.hazalyarimdunya.audit.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity(name = "Blog")
@Table(name = "blog")
public class BlogEntity extends AuditingAwareBaseEntity implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long blogId;

    @Column(name = "header")
    private String header;

    @Lob //Buyuk veri saklamak icin (CLOB-BLOB)
    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date SystemCreatedDate;

}

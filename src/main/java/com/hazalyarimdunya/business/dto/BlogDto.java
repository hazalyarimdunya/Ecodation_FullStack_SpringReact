package com.hazalyarimdunya.business.dto;

import com.hazalyarimdunya.audit.AuditingAwareBaseDto;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder

public class BlogDto extends AuditingAwareBaseDto implements Serializable{

    public static final Long serialVersionUID=1L;//versiyon kontrolü için kullanılır. Farklı sürümler arasında uyumsuzluk olmasını önler.

    private Long blogId;


    @Builder.Default //varsayılan değerin korunmasını sağlar.Yoksa Lombok otomatik null yapar.
    private Date systemCreatedDate=new Date(System.currentTimeMillis());

    @NotEmpty(message = "Header field cannot be empty")
    @Size(min = 3, max = 15, message = "Header field should be between 3-15 characters")
    private String header;

    @NotEmpty(message = "Title field cannot be empty")
    @Size(min = 3, max = 10, message = "Title field should be between 3-10 characters")
    private String title;

//    @NotEmpty(message = "Content field cannot be empty")
//    @Size(min = 20, max = 100, message = "Title field should be between 20-100 characters")
//    private String content;

    @NotEmpty(message = "Should add an image")
    @Builder.Default
    private String image="image.png";

    //N->1
    @OneToOne
    private BlogCategoryDTO blogCategoryDTO;
}


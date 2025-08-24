package com.hazalyarimdunya.business.services.impl;

import com.hazalyarimdunya.bean.ModelMapperBean;
import com.hazalyarimdunya.business.dto.BlogDto;
import com.hazalyarimdunya.business.dto.RoleDto;
import com.hazalyarimdunya.business.services.interfaces.IBlogServices;
import com.hazalyarimdunya.data.entity.BlogEntity;
import com.hazalyarimdunya.data.entity.RoleEntity;
import com.hazalyarimdunya.data.mapper.GenericMapper;
import com.hazalyarimdunya.data.repository.IBlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Log4j2

@Service
@Component("blogSevicesImpl")
public class BlogServicesImpl implements IBlogServices<BlogDto, BlogEntity>  {
 //repostorye erisim nesnesi
// Otomatik dto<->entity donusumu saglayan bean cagirilir.


    private final IBlogRepository iBlogRepository;
    private final GenericMapper genericMapper;

    @Override
    public BlogDto objectServiceCreate(BlogDto blogDto) {
        // DTO -> Entity
        BlogEntity blogEntity = genericMapper.mapDtoToEntity(blogDto, BlogEntity.class);

        // Kaydet
        BlogEntity savedBlog = iBlogRepository.save(blogEntity);

        // Entity -> DTO
        return genericMapper.mapEntityToDto(savedBlog, BlogDto.class);

    }

    @Override
    public List<BlogDto> objectServiceList() {
        List<BlogEntity> blogEntityList= iBlogRepository.findAll(); //findAll ile DB den getirdigim tum verilerimi Entity turunde bir listede tuttum.
        List<BlogDto> blogDtoList = new ArrayList<>(); //Dtolu verileri kaydedecegim bos listem.

        // Entity To Dto
        for (BlogEntity entityTemp : blogEntityList) {
            //RoleDto roleDto = entityToDto(entityTemp);
             BlogDto blogDto = genericMapper.mapEntityToDto(entityTemp, BlogDto.class);
            blogDtoList.add(blogDto);
        }
        return blogDtoList;

    }

    @Override
    public BlogDto objectServiceFindById(Long id) {

        return null;
    }

    @Override
    public BlogDto objectServiceUpdate(Long id, BlogDto blogDto) {
        return null;
    }

    @Override
    public BlogDto objectServiceDelete(Long id) {
        return null;
    }


}

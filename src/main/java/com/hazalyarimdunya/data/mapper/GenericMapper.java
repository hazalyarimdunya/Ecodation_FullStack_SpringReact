package com.hazalyarimdunya.data.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GenericMapper {

    // Entity -> DTO

    public <E, D> D mapEntityToDto(E entity, Class<D> dtoClass) {
        try {
            D dto = dtoClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Entity -> DTO mapping error", e);
        }
    }

         // DTO -> Entity

        public <D, E> E mapDtoToEntity(D dto, Class<E> entityClass) {
            try {
                E entity = entityClass.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(dto, entity);
                return entity;
            } catch (Exception e) {
                throw new RuntimeException("DTO -> Entity mapping error", e);
            }
        }


    }

package com.hazalyarimdunya.business.services;


// D: Dto
// E: Entity
public interface IModelMapperService<D,E> {
  // Model Mapper
    public D entityToDto(E e);
    public E dtoToEntity(D d);
}

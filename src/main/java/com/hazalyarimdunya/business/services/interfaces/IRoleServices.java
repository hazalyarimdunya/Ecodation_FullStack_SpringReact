package com.hazalyarimdunya.business.services.interfaces;

import com.hazalyarimdunya.business.services.ICrudService;
import com.hazalyarimdunya.business.services.IModelMapperService;

// D: Dto
// E: Entity
public interface IRoleServices<D, E> extends IModelMapperService<D, E>, ICrudService<D, E> {

    @Override
    default E dtoToEntity(D d) {
        return null;
    }
} // end IRoleServices

package com.hazalyarimdunya.data.repository;

import com.hazalyarimdunya.data.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<BlogEntity, Long> {

}

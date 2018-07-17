package com.joyson.imagegallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joyson.imagegallery.model.Images;

/**
 * DAO for Images
 * 
 * @author Joyson De Souza
 *
 */
@Repository
public interface ImageRepository extends JpaRepository<Images, Long> {

}

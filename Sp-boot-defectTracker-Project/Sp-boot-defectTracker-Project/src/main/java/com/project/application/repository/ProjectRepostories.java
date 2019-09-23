package com.project.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.application.model.Project;

@Repository
public interface ProjectRepostories extends JpaRepository<Project, Long> {

}

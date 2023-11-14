package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Proyecto;

@Repository
public interface IProyectoDAO extends JpaRepository<Proyecto, String>{

}
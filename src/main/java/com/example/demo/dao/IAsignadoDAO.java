package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Asignado;

@Repository
public interface IAsignadoDAO extends JpaRepository<Asignado, Integer>{

}
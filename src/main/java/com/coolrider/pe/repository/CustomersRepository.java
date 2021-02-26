package com.coolrider.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coolrider.pe.entity.CustomersEntity;

public interface CustomersRepository extends JpaRepository<CustomersEntity, Integer>
{

}

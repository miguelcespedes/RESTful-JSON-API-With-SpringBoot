package com.coolrider.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coolrider.pe.entity.CustomersEntity;

/**
 * <h1>CustomersRepository</h1>
 *
 * @author Miguel Céspedes
 * @version 1.0
 * @since february 2021
 */
public interface CustomersRepository extends JpaRepository<CustomersEntity, Integer>
{

}

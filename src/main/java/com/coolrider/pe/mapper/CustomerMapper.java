package com.coolrider.pe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.coolrider.pe.model.CustomerModel;

@Mapper
public interface CustomerMapper
{

	@Select("SELECT * FROM tbl_customers")
	public List<CustomerModel> findAll();
	
	@Select("SELECT * FROM tbl_customers WHERE customer_id = #{id}")
	public List<CustomerModel> findById(@Param("id") String id);

}
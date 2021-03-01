package com.coolrider.pe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.coolrider.pe.model.GenericMap;

@Mapper
@ConfigurationProperties(prefix = "ms.db.queries")
public interface CustomerMapper
{
	

	@Select("SELECT * FROM tbl_customers")
	public List<GenericMap> findAll();
	
	@Select("SELECT * FROM tbl_customers WHERE customer_id = #{id}")
	public List<GenericMap> findById(@Param("id") String id);

}
package com.ssafy.plan.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.plan.model.PlanDto;

@Mapper
public interface PlanMapper {

	PlanDto writePlan(PlanDto planDto);

}
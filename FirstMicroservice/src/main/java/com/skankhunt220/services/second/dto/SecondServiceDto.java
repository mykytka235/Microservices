package com.skankhunt220.services.second.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecondServiceDto {
	private String id;
	private String middleName;
	private String lastName;
}
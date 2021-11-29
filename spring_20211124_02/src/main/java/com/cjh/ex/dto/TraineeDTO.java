package com.cjh.ex.dto;

import java.sql.Date;
import lombok.Data;

@Data
public class TraineeDTO {
	private long t_number;
	private String t_name;
	private int t_age;
	private String t_phone;
	private String t_gender;
	private Date t_birth;
	private String t_address;
}
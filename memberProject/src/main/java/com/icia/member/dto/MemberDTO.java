package com.icia.member.dto;

import lombok.Data;

// lombok 사용하겠다고 선언
// 겟터셋터등 알아서 생성해줌.
@Data
public class MemberDTO {
	
	private long m_number;
	private String m_id;
	private String m_password;
	private String m_name;
	private String m_email;
	private String m_phone;
	
}

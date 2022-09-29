package com.chicken.project.email.model.service;

import com.chicken.project.member.model.dto.EmployeeDTO;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EmailService {
    int updateEmailCode(EmployeeDTO emp) throws MessagingException, UnsupportedEncodingException;

    EmployeeDTO selectEmailCode(EmployeeDTO emp);

    int updatePwd(EmployeeDTO emp);
}

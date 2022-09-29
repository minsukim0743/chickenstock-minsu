package com.chicken.project.email.model.service;

import com.chicken.project.email.common.MailHandler;
import com.chicken.project.email.common.TempKey;
import com.chicken.project.member.model.dao.EmployeeMapper;
import com.chicken.project.member.model.dto.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
public class EmailServiceImpl implements EmailService{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final EmployeeMapper employeeMapper;
    private final JavaMailSender mailSender;

    @Autowired
    public EmailServiceImpl(EmployeeMapper employeeMapper, JavaMailSender mailSender) {
        this.employeeMapper = employeeMapper;
        this.mailSender = mailSender;
    }

    @Override
    public int updateEmailCode(EmployeeDTO emp) throws MessagingException, UnsupportedEncodingException {

        String emailCode = new TempKey().getKey(10,false);
        emp.setEmailCode(emailCode);

        log.info("[MemberService] emp = " + emp);

        int result = employeeMapper.updateEmailCode(emp);

        if(result > 0){
            MailHandler sendMail = new MailHandler(mailSender);
            sendMail.setSubject("[치킨스톡 인증 이메일입니다.]");
            sendMail.setText(
                    "<h1>치킨스톡 이메일 인증</h1>" +
                            "<br>치킨스톡 비밀번호를 재설정하기 위한 인증 이메일입니다." +
                            "<br>아래 인증번호를 입력해주세요." +
                            "<br>[" + emailCode + "]"
            );
            sendMail.setFrom("ybusiness39@naver.com","치킨스톡");
            sendMail.setTo(emp.getEmpEmail());
            sendMail.send();
        }

        return result;
    }

    @Override
    public EmployeeDTO selectEmailCode(EmployeeDTO emp) {

        EmployeeDTO emailCode = employeeMapper.selectEmailCode(emp);

        return emailCode;
    }

    @Override
    public int updatePwd(EmployeeDTO emp) {

        int result = employeeMapper.updatePwd(emp);

        return result;
    }
}

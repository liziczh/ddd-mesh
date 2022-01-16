package com.liziczh.archetype.ref.mail.service;

import com.liziczh.archetype.ref.mail.dto.MailSendRequest;
import com.liziczh.archetype.ref.mail.dto.MailSendResult;

public interface MailService {

    /**
     * 发送文本邮件
     *
     * @param request
     * @return com.liziczh.archetype.ref.mail.dto.MailSendResult
     * @author chenzhehao
     * @date 2022/1/16 7:10 下午
     */
    MailSendResult sendTextMail(MailSendRequest request);

    /**
     * 发送MIME邮件
     *
     * @param request
     * @return com.liziczh.archetype.ref.mail.dto.MailSendResult
     * @author chenzhehao
     * @date 2022/1/16 7:10 下午
     */
    MailSendResult sendMimeMail(MailSendRequest request);
}

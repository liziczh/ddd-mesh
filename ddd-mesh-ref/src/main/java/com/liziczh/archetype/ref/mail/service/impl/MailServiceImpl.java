package com.liziczh.archetype.ref.mail.service.impl;

import java.io.File;
import java.util.Date;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.liziczh.archetype.ref.mail.dto.MailSendRequest;
import com.liziczh.archetype.ref.mail.dto.MailSendResult;
import com.liziczh.archetype.ref.mail.service.MailService;
import com.liziczh.ddd.mesh.common.util.JsonUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 邮件服务
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/8/23 9:23 下午
 */
@Slf4j
@Component
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public MailSendResult sendTextMail(MailSendRequest request) {
        log.info("MailService.sendTextMail, start, request={}", JsonUtils.toJson(request));

        boolean status = false;
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            // message
            message.setFrom(request.getFrom());
            message.setTo(request.getTo());
            message.setSubject(request.getSubject());
            message.setText(request.getContent());
            message.setCc(request.getCc());
            message.setBcc(request.getBcc());
            message.setSentDate(new Date());
            log.info("MailService.sendTextMail, send, message={}", JsonUtils.toJson(message));
            mailSender.send(message);
            status = true;
        } catch (Exception e) {
            log.error("MailService sendTextMail error, request={}", JsonUtils.toJson(request), e);
            status = false;
        }

        // result
        MailSendResult result = MailSendResult.builder()
                .status(status)
                .requestJson(JsonUtils.toJson(message))
                .responseJson(JsonUtils.toJson(status))
                .build();

        log.info("MailService.sendTextMail, end, request={}, result={}",
                JsonUtils.toJson(request), JsonUtils.toJson(result));

        return result;
    }

    @Override
    public MailSendResult sendMimeMail(MailSendRequest request) {
        log.info("MailService.sendMimeMail, start, request={}",
                JsonUtils.toJson(request));

        boolean status = false;
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(request.getFrom());
            helper.setTo(request.getTo());
            helper.setSubject(request.getSubject());
            helper.setText(request.getContent());
            // 添加抄送
            if (request.getCc() != null && request.getCc().length > 0) {
                helper.setCc(request.getCc());
            }
            // 添加密送
            if (request.getBcc() != null && request.getBcc().length > 0) {
                helper.setBcc(request.getBcc());
            }
            helper.setSentDate(new Date());
            // 添加行内图片
            if (!CollectionUtils.isEmpty(request.getImage())) {
                for (Map.Entry<String, String> image : request.getImage().entrySet()) {
                    helper.addInline(image.getKey(), new File(image.getValue()));
                }
            }
            // 添加附件
            if (!CollectionUtils.isEmpty(request.getAttachment())) {
                for (Map.Entry<String, String> attachment : request.getAttachment().entrySet()) {
                    helper.addAttachment(attachment.getKey(), new File(attachment.getValue()));
                }
            }
            log.info("MailService.sendMimeMail, send, message={}", JsonUtils.toJson(message));
            mailSender.send(message);
            status = true;
        } catch (Exception e) {
            log.error("MailService.sendMimeMail, error, request={}", JsonUtils.toJson(request), e);
            status = false;
        } finally {
            // 删除临时附件
            if (!CollectionUtils.isEmpty(request.getAttachment())) {
                for (Map.Entry<String, String> attachment : request.getAttachment().entrySet()) {
                    this.delTempFile(attachment.getValue());
                }
            }
        }

        // result
        MailSendResult result = MailSendResult.builder()
                .status(status)
                .requestJson(JsonUtils.toJson(request))
                .responseJson(JsonUtils.toJson(status))
                .build();

        log.info("MailService.sendMimeMail, end, request={}, result={}",
                JsonUtils.toJson(request), JsonUtils.toJson(result));

        return result;
    }

    /**
     * 删除临时文件
     *
     * @author chenzhehao
     * @date 2021/11/22 9:36 下午
     */
    public boolean delTempFile(String tempFilePath) {
        log.info("MailService.delTempFile, start, tempFilePath={}", tempFilePath);
        boolean deleteFlag = false;
        File tmpFile = new File(tempFilePath);
        if (tmpFile.exists()) {
            deleteFlag = tmpFile.delete();
            log.info("MailService.delTempFile, success, tempFilePath={}, deleteFlag={}", tempFilePath, deleteFlag);
        } else {
            log.error("MailService.delTempFile, file does not exist, tempFilePath={}", tempFilePath);
        }
        log.info("MailService.delTempFile end, tempFilePath={}, deleteFlag={}", tempFilePath, deleteFlag);
        return deleteFlag;
    }
}

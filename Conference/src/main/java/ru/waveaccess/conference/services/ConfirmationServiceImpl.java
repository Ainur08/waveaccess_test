package ru.waveaccess.conference.services;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import ru.waveaccess.conference.dto.EmailDto;
import ru.waveaccess.conference.models.State;
import ru.waveaccess.conference.models.User;
import ru.waveaccess.conference.repositories.UsersRepository;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@EnableAsync
public class ConfirmationServiceImpl implements ConfirmationService {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private Configuration configuration;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Async
    public void send(EmailDto emailDto) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    false,
                    StandardCharsets.UTF_8.name());

            Template t = configuration.getTemplate(emailDto.getTemplate());
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, emailDto.getMap());

            helper.setTo(emailDto.getTo());
            helper.setText(html, true);
            helper.setSubject(emailDto.getSubject());

            emailSender.send(message);
        } catch (MailException | IOException | TemplateException | MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void checkConfirmation(String token) {
        Optional<User> optionalUser = usersRepository.findByToken(token);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setState(State.CONFIRMED);
            usersRepository.save(user);
        }
    }
}

package ru.waveaccess.conference.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.waveaccess.conference.dto.EmailDto;
import ru.waveaccess.conference.dto.SignUpDto;
import ru.waveaccess.conference.generators.ConfirmationTokenGenerator;
import ru.waveaccess.conference.models.Role;
import ru.waveaccess.conference.models.State;
import ru.waveaccess.conference.models.User;
import ru.waveaccess.conference.repositories.UsersRepository;
import java.util.HashMap;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ConfirmationService confirmationService;

    @Override
    @Transactional
    public void signUp(SignUpDto signUpDto) {
        User user = usersRepository.save(User.builder()
                .name(signUpDto.getName())
                .email(signUpDto.getEmail())
                .hashPassword(passwordEncoder.encode(signUpDto.getPassword()))
                .state(State.NOT_CONFIRMED)
                .role(Role.LISTENER)
                .token(ConfirmationTokenGenerator.generate())
                .build());

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("token", user.getToken());
        confirmationService.send(EmailDto.builder()
                .to(user.getEmail())
                .subject("Confirm email")
                .map(parameters)
                .template("confirmationEmail.ftlh")
                .build());
    }
}

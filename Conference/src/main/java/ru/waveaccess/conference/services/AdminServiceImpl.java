package ru.waveaccess.conference.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.waveaccess.conference.dto.UserDto;
import ru.waveaccess.conference.models.Role;
import ru.waveaccess.conference.models.User;
import ru.waveaccess.conference.repositories.UsersRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> findAllUser() {
        return UserDto.from(usersRepository.findAll());
    }

    @Override
    @Transactional
    public void makePresenter(Long id) {
        Optional<User> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setRole(Role.PRESENTER);
            usersRepository.save(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateNameAndEmail(Long id, String name, String email) {
        usersRepository.updateNameAndEmail(name, email, id);
    }
}

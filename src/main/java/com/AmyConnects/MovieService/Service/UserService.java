package com.AmyConnects.MovieService.Service;
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String registerUser(String name, String email) {

        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        String token = UUID.randomUUID().toString();

        User user = User.builder()
                .name(name)
                .email(email)
                .token(token)
                .build();

        userRepository.save(user);

        return token;
    }

    public User validateToken(String token) {
        return userRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid token"));
    }
}

package nexttravelcompanyuser.service.service.impl;

import lombok.RequiredArgsConstructor;
import nexttravelcompanyuser.service.dto.AuthenticateRequest;
import nexttravelcompanyuser.service.dto.AuthenticationResponse;
import nexttravelcompanyuser.service.dto.RegisterRequest;
import nexttravelcompanyuser.service.entity.Role;
import nexttravelcompanyuser.service.entity.Traveler;
import nexttravelcompanyuser.service.repository.TravelerRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {

    private final TravelerRepo userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse userRegister(RegisterRequest request) {

            var traveler = Traveler.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            userRepository.save(traveler);
            var jwtToken = jwtService.generateToken(traveler);
            return AuthenticationResponse
                    .builder()
                    .token(jwtToken)
                    .build();

    }

    public AuthenticationResponse userAuthenticate(AuthenticateRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}

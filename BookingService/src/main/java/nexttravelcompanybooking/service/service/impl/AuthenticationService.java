//package nexttravelcompanybooking.service.service.impl;
//
//import lombok.RequiredArgsConstructor;
//import nexttravelcompanybooking.service.dto.AuthenticateRequest;
//import nexttravelcompanybooking.service.dto.AuthenticationResponse;
//import nexttravelcompanybooking.service.dto.RegisterRequest;
//import nexttravelcompanybooking.service.entity.Role;
//import nexttravelcompanybooking.service.entity.Traveler;
//import nexttravelcompanybooking.service.repository.TravelerRepo;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class AuthenticationService {
//
//    private final TravelerRepo userRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    private final JwtService jwtService;
//
//    private final AuthenticationManager authenticationManager;
//
//    public AuthenticationResponse userRegister(RegisterRequest request) {
//
//            var traveler = Traveler.builder()
//                    .firstName(request.getFirstName())
//                    .lastName(request.getLastName())
//                    .email(request.getEmail())
//                    .password(passwordEncoder.encode(request.getPassword()))
//                    .role(Role.USER)
//                    .build();
//            userRepository.save(traveler);
//            var jwtToken = jwtService.generateToken(traveler);
//            return AuthenticationResponse
//                    .builder()
//                    .token(jwtToken)
//                    .build();
//
//    }
//
//    public AuthenticationResponse userAuthenticate(AuthenticateRequest request) {
//
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        request.getEmail(),
//                        request.getPassword()
//                )
//        );
//
//        var user = userRepository.findByEmail(request.getEmail())
//                .orElseThrow();
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse
//                .builder()
//                .token(jwtToken)
//                .build();
//    }
//}

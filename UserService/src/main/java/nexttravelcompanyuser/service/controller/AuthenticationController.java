package nexttravelcompanyuser.service.controller;

import lombok.RequiredArgsConstructor;
import nexttravelcompanyuser.service.dto.AuthenticateRequest;
import nexttravelcompanyuser.service.dto.AuthenticationResponse;
import nexttravelcompanyuser.service.dto.RegisterRequest;
import nexttravelcompanyuser.service.service.impl.AuthenticationService;
import nexttravelcompanyuser.service.util.ResponseUtility;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/authentication")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://127.0.0.1:5500"})
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(value = "/register", consumes =MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtility userRegister(@RequestBody RegisterRequest request){
        AuthenticationResponse authenticationResponse = authenticationService.userRegister(request);
        return new ResponseUtility(200,"Token Received",authenticationResponse);

    }

    @PostMapping("/authenticate")
    public ResponseUtility userAuthenticate(@RequestBody AuthenticateRequest request){
        AuthenticationResponse authenticationResponse = authenticationService.userAuthenticate(request);
        return new ResponseUtility(200,"Token Received",authenticationResponse);
    }

}

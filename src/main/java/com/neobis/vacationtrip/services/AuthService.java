package com.neobis.vacationtrip.services;




import com.neobis.vacationtrip.dtos.JwtRequestDto;
import com.neobis.vacationtrip.dtos.JwtResponseDto;
import com.neobis.vacationtrip.exceptions.InvalidCredentialException;
import com.neobis.vacationtrip.util.CustomUserDetails;
import com.neobis.vacationtrip.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetails customUserDetails;

    public ResponseEntity<JwtResponseDto> authentication(JwtRequestDto authRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new InvalidCredentialException("Invalid username or password");

        }
        UserDetails userDetails = customUserDetails.loadUserByUsername(authRequest.getEmail());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponseDto(token));
    }







}
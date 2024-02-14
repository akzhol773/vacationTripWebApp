package com.neobis.vacationtrip.util;



import com.neobis.vacationtrip.entities.Employee;
import com.neobis.vacationtrip.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetails implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format("Employee with email '%s'  not found", email)));
        if(employee != null){
            return new org.springframework.security.core.userdetails.User(
                    employee.getEmail(),
                    employee.getPassword(),
                    employee.getRoles().stream().map((role)-> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList())
            );
        }else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }
}

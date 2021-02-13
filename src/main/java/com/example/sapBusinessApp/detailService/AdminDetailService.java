package com.example.sapBusinessApp.detailService;

import com.example.sapBusinessApp.domain.Administrator;
import com.example.sapBusinessApp.domain.MyUserDetails;
import com.example.sapBusinessApp.repos.AdministratorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AdminDetailService implements UserDetailsService {
    @Autowired
    private AdministratorRepo administratorRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator administrator = administratorRepo.getAdminByName(username);

        if (administrator == null){
            throw new UsernameNotFoundException("Could not find admin");
        }
        return new MyUserDetails(administrator);
    }
}

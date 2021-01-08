package com.example.inklow.security;

import com.example.inklow.entities.Permission;
import com.example.inklow.entities.Role;
import com.example.inklow.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MyUserDetail implements UserDetails {
    private final User user;

    public MyUserDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = user.getRoles();

        return getPermissions(roles);
    }

    public UUID getId() {
        return user.getId();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    private List<? extends GrantedAuthority> getPermissions(List<Role> roles) {
        return getGrantedAuthorities(getStringPermissions (roles));
    }

    private List<String> getStringPermissions(List<Role> roles) {
        List<Permission> setOfPermissions = new ArrayList<>();

        for (Role role : roles) {
            setOfPermissions.addAll(role.getPermissions());
        }

        List<String> stringPermissions = new ArrayList<>();

        for (Permission permission : setOfPermissions) {
            stringPermissions.add(permission.getName());
        }

        return stringPermissions;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> permissions) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission));
        }

        return authorities;
    }
}

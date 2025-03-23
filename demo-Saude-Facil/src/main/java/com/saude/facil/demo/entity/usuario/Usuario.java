package com.saude.facil.demo.entity.usuario;

import com.saude.facil.demo.entity.enums.UserRole;
import com.saude.facil.demo.service.dto.DadosAutenticacao;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public Usuario(DadosAutenticacao dadosAutenticacao) {
        this.login = dadosAutenticacao.login();
        this.senha = dadosAutenticacao.senha();
        this.role = dadosAutenticacao.role();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.COMUM){
            return List.of(new SimpleGrantedAuthority("ROLE_COMUM"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_COMUM"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}

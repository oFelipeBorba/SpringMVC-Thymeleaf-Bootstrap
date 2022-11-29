package br.com.alura.mvc.mudi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //uso o http que e obj de httpSecurity
        http
                //os requests autorizados, precisam estar autenticados, qualquer um deles
                .authorizeRequests()
                    .anyRequest().authenticated()
                .and()
                //alem desses autenticados os httpBasic
                    .httpBasic();
    }
//para autenticar precisa de usuario e senha
    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("felipe")
                        .password("felipe")
                        .roles("ADM")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }
}

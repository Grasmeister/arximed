package com.example.bidding;

import com.example.bidding.authorization.FrontendEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
//@EnableWebSecurity
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig  {


    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(bCryptPasswordEncoder.encode("userPass"))
                .roles("USER")
                .build());
        manager.createUser(User.withUsername("admin")
                .password(bCryptPasswordEncoder.encode("adminPass"))
                .roles("USER", "ADMIN")
                .build());
        return manager;
    }
//
//    /**
//     * Зависимость на реализацию UserDetailService.
//     */
//    @Autowired
//    private FrontendEmployeeService frontendEmployeeService;
//
//    /**
//     * Настраиваем параметры доступов к URL.
//     *
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http
//                .anonymous()
//                .authorities("ROLE_ANON")
//                .and()
//                .authorizeHttpRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/*").hasAuthority("ROLE_ANON")
//                .antMatchers("/user/student/**").hasAuthority("STUDENT")
//                .antMatchers("/user/teacher/**").hasAuthority("TEACHER")
//                .antMatchers("/user/administrator/**").hasAuthority("ADMINISTRATOR")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .csrf().disable(); //отключаем защиту от Cross-Site Request Forgery
//
//        /*
//         * Если не отключать csrf, под каждую форму придется добавлять токен вида:
//         * <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
//         */
//
//
//        // При необходимости можно кастомизировать страницу с формой логина и адрес обработчика этой формы
//        // .loginPage("/login").loginProcessingUrl("/process")
//
//    }
//
//    /**
//     * Настраиваем пользователей.
//     *
//     * @param auth
//     * @throws Exception
//     */
////    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//               auth.userDetailsService(frontendEmployeeService);
//    }

}

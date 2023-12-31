//package my.project.library.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class AuthProviderImpl implements AuthenticationProvider {
//
//    private final UserDetailsService userDetailsServiceImpl;
//
//    @Autowired
//    public AuthProviderImpl(UserDetailsService userDetailsServiceImpl) {
//        this.userDetailsServiceImpl = userDetailsServiceImpl;
//    }
//
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        System.out.println("authProviderImpl");
//        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
//
//        String password = authentication.getCredentials().toString();
//
//        if(!password.equals(userDetails.getPasswordText()))
//            throw new BadCredentialsException("Incorrect password!");
//
//
//        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return true;
//    }
//}

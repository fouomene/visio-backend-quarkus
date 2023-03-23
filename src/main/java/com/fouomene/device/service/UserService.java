package com.fouomene.device.service;

import com.fouomene.device.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@AllArgsConstructor
@Slf4j
public class UserService {

	private final UserRepository userRepository;
	public String signin(String username, String password) {
		/*try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
		} catch (final AuthenticationException e) {
			throw new OneLogicTechnicalException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}*/
		return "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sImlhdCI6MTY3OTQyMTE3MSwiZXhwIjoxNjc5NDI0NzcxfQ.C0ghv-qg_oAnI5WKmrS7iUlhbYOf6tQeMOLJb6T6lq8";
	}

}

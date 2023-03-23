package com.fouomene.device.resource;


import com.fouomene.device.resource.request.UserRequest;
import com.fouomene.device.resource.response.TokenJWTResponse;
import com.fouomene.device.service.UserService;
import lombok.AllArgsConstructor;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/visio/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class UserResource {

	private final UserService userService;

	@POST
	@Path("/signin")
	public TokenJWTResponse login(UserRequest userRequest) {
		return TokenJWTResponse.builder()
				.token(userService.signin(userRequest.getUsername(), userRequest.getPassword()))
				.build();
	}
}

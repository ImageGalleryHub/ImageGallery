package com.joyson.imagegallery.controllers;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample general controllers
 * 
 * TODO remove this class ! 
 * 
 * @author Jaison
 *
 */
@RestController
public class GeneralController extends ImageGalleryBaseController {

	@GetMapping("/")
	public RestMsg hello() {
		return new RestMsg("Hello World!");
	}

	@GetMapping("/test")
	public RestMsg apitest() {
		return new RestMsg("Hello apiTest!");
	}

	@GetMapping(value = "/hello", produces = "application/json")
	public RestMsg helloUser() {
		// The authenticated user can be fetched using the SecurityContextHolder
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return new RestMsg(String.format("Hello '%s'!", username));
	}

	@GetMapping("/admin")
	public RestMsg helloAdmin(Principal principal) {
		return new RestMsg(String.format("Welcome '%s'!", principal.getName()));
	}

	public static class RestMsg {
		private String msg;

		public RestMsg(String msg) {
			this.msg = msg;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
	}
}

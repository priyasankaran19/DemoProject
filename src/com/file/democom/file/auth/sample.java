package com.file.democom.file.auth;

public class sample {

	public static void main(String[] args) {
		String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AdQt8qhWLHVqvCMjPcL0GR2Lu7vn7RaDSEtMGmto0FwKUNnPWsWF9BwcU9IB7aMCGLfNfQ&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none#";
		String partialcode=url.split("code=")[1];
		String code=partialcode.split("&scope")[0];
		System.out.println(code);
	}
}

package com.ssafy.happyhouse.serivce;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ssafy.happyhouse.dto.UserDto;

import io.jsonwebtoken.*;

@Component
public class JwtService{	
	public static final Logger logger=LoggerFactory.getLogger(JwtService.class);
	
	private String signature="VUETOKEN";
	private Long expireMin=5L;

	//로그인 성공시 사용자 정보를 기반으로 JWTToken을 생성하여 반환.
	public String create(UserDto userDto) {
		JwtBuilder jwtBuilder=Jwts.builder();
		//JWT Token=Header+Payload+Signature

/*

https://jwt.io/#debugger-io 이동 확인가능

Encoded:
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

HEADER:ALGORITHM & TOKEN TYPE
{
  "alg": "HS256",
  "typ": "JWT"
}
.
PAYLOAD:DATA
{
  "sub": "1234567890",
  "name": "John Doe",
  "iat": 1516239022
}
.
VERIFY SIGNATURE
HMACSHA256(
  base64UrlEncode(header) + "." +
  base64UrlEncode(payload),  
  your-256-bit-secret
)

*/
		
		//Header 설정
		jwtBuilder.setHeaderParam("typ", "JWT"); // 토큰의 타입으로 고정 값.

		//Payload 설정
		jwtBuilder.setSubject("로그인토큰") // 토큰의 제목 설정
			      .setExpiration(new Date(System.currentTimeMillis()+1000*60*expireMin)) // 유효기간 설정
			      .claim("user", userDto)
			      .claim("greeting", "환영합니다. "+userDto.getUsername()); // 담고 싶은 정보 설정.
		
		//signature 설정
		jwtBuilder.signWith(SignatureAlgorithm.HS256, signature.getBytes());
		
		//마지막 직렬화 처리
		String jwt=jwtBuilder.compact();
		logger.info("jwt : {}", jwt);
		return jwt;
	}
	
	//전달 받은 토큰이 제대로 생성된것이니 확인하고 문제가 있다면 RuntimeException을 발생.
	public void checkValid(String jwt) {
		//예외가 발생하지 않으면 OK
		Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt);
	}
	
	//JWT Token을 분석해서 필요한 정보를 반환.
	public Map<String, Object> get(String jwt) {
        Jws<Claims> claims = null;
        try {
            claims = Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt);
        } catch (final Exception e) {
            throw new RuntimeException();
        }

        logger.info("claims : {}", claims);
        // Claims는 Map의 구현체이다.
        return claims.getBody();
    }
}

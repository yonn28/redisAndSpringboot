package com.example.redisConnection;

import com.example.redisConnection.models.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedisConectionApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName("127.0.0.1");
		redisStandaloneConfiguration.setPassword("mypass");
		redisStandaloneConfiguration.setPort(6379);
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
		return jedisConnectionFactory;
	}
	@Bean
	RedisTemplate<String,Student> redisTemplate(){
		final RedisTemplate<String,Student > redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

/*
	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		return jedisConnectionFactory;
	}

	@Bean
	RedisTemplate<String, Student> redisTemplate(RedisConnectionFactory connectionFactory){
		RedisTemplate<String,Student> redisTemplate = new RedisTemplate<String,Student>();
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}
*/


	public static void main(String[] args) {
		SpringApplication.run(RedisConectionApplication.class, args);
	}

}

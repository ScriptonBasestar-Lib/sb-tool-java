package com.scriptonbasestar.spring.security.rememberme;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author archmagece
 * @CreatedAt 2016-07-19 18
 */
@Slf4j
public class RedisRememberMeTokenRepository {

	private final RedisTemplate<String, RedisRememberMeToken> redisTemplate;
	private final String REDIS_KEY;

	public RedisRememberMeTokenRepository(RedisTemplate<String, RedisRememberMeToken> redisTemplate) {
		this.REDIS_KEY = "REDIS_REMEMBER_ME_KEY";
		this.redisTemplate = redisTemplate;
	}

	public RedisRememberMeTokenRepository(String redisKey, RedisTemplate<String, RedisRememberMeToken> redisTemplate) {
		this.REDIS_KEY = redisKey;
		this.redisTemplate = redisTemplate;
	}

	public boolean exists(String key) {
		RedisRememberMeToken current = (RedisRememberMeToken) this.redisTemplate.opsForHash().get(REDIS_KEY, key);
		return current == null ? true : false;
	}
	public void storeToken(String key, RedisRememberMeToken token) {
		this.redisTemplate.opsForHash().put(REDIS_KEY, key, token);
	}

	public RedisRememberMeToken getToken(String key) {
		return (RedisRememberMeToken) this.redisTemplate.opsForHash().get(REDIS_KEY, key);
	}

	public void removeToken(String key) {
		this.redisTemplate.opsForHash().delete(REDIS_KEY, key);
	}

	public void dumpAll() {
		this.redisTemplate.delete(REDIS_KEY);
	}

}

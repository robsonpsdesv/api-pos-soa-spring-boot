package br.com.robson.bibliotecaapi.api.config;

import br.com.robson.bibliotecaapi.api.token.CustomTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
public class AuthenticationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	private String secretKey = "$2a$10$CG48p7zyaG3n0zOGgJk8P.Pclgzc1XhvzHMpBh7V9g8dpKnpgXS3q";

	private String signingKey = "apiBiblioteca";

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory().withClient("apiBibliotecaClient").secret(secretKey).scopes("write", "read")
				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(600)
				.refreshTokenValiditySeconds(3600 * 24);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();

		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), getJwtAccessTokenConverter()));

		endpoints.tokenStore(getTokenStore()).tokenEnhancer(tokenEnhancerChain).reuseRefreshTokens(false)
				.userDetailsService(userDetailsService).authenticationManager(authenticationManager);
	}

	@Bean
	public JwtAccessTokenConverter getJwtAccessTokenConverter() {
		JwtAccessTokenConverter jwtConverter = new JwtAccessTokenConverter();

		jwtConverter.setSigningKey(signingKey);

		return jwtConverter;
	}

	@Bean
	public TokenStore getTokenStore() {
		return new JwtTokenStore(getJwtAccessTokenConverter());
	}

	@Bean
	public TokenEnhancer tokenEnhancer() {
		return new CustomTokenEnhancer();
	}
}

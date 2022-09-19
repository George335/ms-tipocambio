package com.yjmg.tipocambio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	static final String CLIEN_ID = "my-trusted-client";
	static final String AUTHORIZATION_CODE = "authorization_code";
	static final String REFRESH_TOKEN = "refresh_token";
	static final String IMPLICIT = "implicit";
	static final String SCOPE_READ = "read";
	static final String SCOPE_WRITE = "write";
	static final String TRUST = "trust";
	static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1200;
	static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 60 * 60 * 12; //60 (60 segundos)   -   60 * 60 * 12; (12 horas)  -   60 * 60 * 24 * 30; (30 días)
	
	
	@Value("${backend.grandtypepw}")
    private String grandtypepw;
	
	@Value("${backend.clientsecret}")
    private String client_password;
	
	@Value("${security.signing-key}")
    private String signingKey;

	@Autowired
	private AuthenticationManager authenticationManager;
        
        @Autowired
        private PasswordEncoder passwordEncoder;
        
        @Autowired
    	private TokenStore tokenStore;

    	@Autowired
    	private JwtAccessTokenConverter accessTokenConverter;
    	
    	
    	
    	
    	
    	@Value("${security.jwt.client-id}")
    	private String clientId;

    	@Value("${security.jwt.client-secret}")
    	private String clientSecret;

    	@Value("${security.jwt.grant-type}")
    	private String grantType;

    	@Value("${security.jwt.scope-read}")
    	private String scopeRead;

    	@Value("${security.jwt.scope-write}")
    	private String scopeWrite = "write";

    	@Value("${security.jwt.resource-ids}")
    	private String resourceIds;

    	@Autowired
    	private BCryptPasswordEncoder bcrypt;	

        /*
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("as466gf");
		return converter;
	}
	*/
        
    	/*
        @Bean
        public JwtAccessTokenConverter accessTokenConverter() {
            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            converter.setSigningKey(signingKey);
            return converter;
        }
        
	    @Bean
		public TokenStore tokenStore() {
			return new JwtTokenStore(accessTokenConverter());
		}
	    
		@Bean
	    @Primary //Making this primary to avoid any accidental duplication with another token service instance of the same name
	    public DefaultTokenServices tokenServices() {
	        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
	        defaultTokenServices.setTokenStore(tokenStore());
	        defaultTokenServices.setSupportRefreshToken(true);
	        return defaultTokenServices;
	    }
	    */
		
        /*
        @Bean
        public JwtAccessTokenConverter accessTokenConverter() {
            final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            return converter;
        }
        */
        
        
	
	
	/*
	@Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }
	*/
	
	
	

	
	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

		configurer
				.inMemory()
				.withClient(CLIEN_ID)
				.secret(passwordEncoder.encode(client_password))
				.authorizedGrantTypes(grandtypepw, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
				.scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
				.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).
				refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
	}
	
	
	/*
	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		configurer.inMemory().withClient(CLIEN_ID).secret(passwordEncoder.encode(CLIENT_SECRET)).authorizedGrantTypes(GRANT_TYPE_PASSWORD)
		.scopes(SCOPE_READ, SCOPE_WRITE).accessTokenValiditySeconds(100)
		.refreshTokenValiditySeconds(0);		
	}
	*/
	
	/*
	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		configurer.inMemory().withClient(clientId).secret(bcrypt.encode(clientSecret)).authorizedGrantTypes(grantType)
		.scopes(scopeRead, scopeWrite).accessTokenValiditySeconds(500)
		.refreshTokenValiditySeconds(0);		
	}
	*/

	//@Override
      //  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		/*endpoints
		.tokenStore(tokenStore())
			.authenticationManager(authenticationManager)
			.accessTokenConverter(accessTokenConverter());
			*/
		
		//endpoints
          //          .authenticationManager(authenticationManager);
                    
        //}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
		enhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
		endpoints
		.tokenStore(tokenStore)
		.accessTokenConverter(accessTokenConverter)
		.tokenEnhancer(enhancerChain)
		.authenticationManager(authenticationManager);
	}
        
	
	
	/*
        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
            security
                    .checkTokenAccess("isAuthenticated()");
        }
      */ 
        
}
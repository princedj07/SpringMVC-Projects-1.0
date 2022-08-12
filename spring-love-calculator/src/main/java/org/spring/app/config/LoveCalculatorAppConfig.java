package org.spring.app.config;

import java.util.Properties;

import org.spring.app.utility.PhoneNumberFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
//@ComponentScan(basePackages = "org.spring.app.controller")
@ComponentScan(basePackages = "org.spring.app")
@PropertySource("classpath:email.properties")
public class LoveCalculatorAppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;

	// Setup my view resolver

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		System.out.println("Setting View Resolver Name");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/webapp/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {
		System.out.println("LoveCalculatorAppConfig.messageSource() method executed >>>>");
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean()
	public LocalValidatorFactoryBean validator() {
		System.out.println("LoveCalculatorAppConfig.validatorFactoryBean() method executed >>>>");
		LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
		factoryBean.setValidationMessageSource(messageSource());
		return factoryBean;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("LoveCalculatorAppConfig.addFormatters()");
		registry.addFormatter(new PhoneNumberFormatter());
	}

	@Override
	public Validator getValidator() {
		return validator();
	}

	@Bean
	public JavaMailSender getJavaMailSender() {

		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();

		System.out.println("ENV---: " + env.getProperty("mail.host"));

		javaMailSenderImpl.setHost(env.getProperty("mail.host"));
		javaMailSenderImpl.setUsername(env.getProperty("mail.username"));
		javaMailSenderImpl.setPassword(env.getProperty("mail.password"));
		javaMailSenderImpl.setPort(Integer.parseInt(env.getProperty("mail.port")));
		javaMailSenderImpl.setJavaMailProperties(geMmailProperties());

		return javaMailSenderImpl;

	}

	private Properties geMmailProperties() {

		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		return mailProperties;
	}

}

package hello;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


@Service
@ConfigurationProperties(prefix="rabbitmq")
public class MQSender {

	
	private String mqServer;
	private String port;
	private String user;
	private String pw;
	private String queueName;
	
	private Channel logChannel;
	private Connection logConn;
	
	private String errorMessage;
	
	public void sendLogMessage(String message) throws IOException, TimeoutException{
		try{
			if(logConn == null || logChannel == null || !logConn.isOpen() || !logChannel.isOpen()){
				init();
			}
			
			logChannel.queueDeclare(queueName, false, false, false, null);
			logChannel.basicPublish("", queueName, null, message.getBytes());		
		}catch (Exception e) {
			System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
			System.out.println(errorMessage);
			e.printStackTrace();
		}
	}
	
	
	private void init() throws IOException, TimeoutException{
		
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost(mqServer);	
			
			errorMessage = "Unable to connect to mq server: " + mqServer + ":" + factory.getPort();
				
			logConn = factory.newConnection();
			logChannel = logConn.createChannel();		
	}
	
	@PreDestroy
	private void cleanUp(){
		try {
			if(logConn != null){
				logConn.close();
			}
			if(logChannel != null){
				logChannel.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public String getMqServer() {
		return mqServer;
	}


	public void setMqServer(String mqServer) {
		this.mqServer = mqServer;
	}


	public String getPort() {
		return port;
	}


	public void setPort(String port) {
		this.port = port;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getQueueName() {
		return queueName;
	}


	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	
	
	
}
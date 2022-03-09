package com.unix;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.junit.Test;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class getunixlog {

	
	public static void main(String[] args )  throws  JSchException, Exception {
	
		JSch jsch = new JSch();
		Session session = jsch.getSession("nsadm", "10.64.16.111", 22);
		session.setPassword("nsadm123");
		
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.connect();
		Thread.sleep(5000);
		Channel channel = session.openChannel("exec");
		
		InputStream is=channel.getExtInputStream();
		
		((ChannelExec) channel).setCommand("ls");
		
		((ChannelExec) channel).setErrStream(System.err);
		channel.connect();
	BufferedReader reader	= new BufferedReader(new InputStreamReader(is));
	
	String line;
	
	while((line = reader.readLine()) != null){
		
		System.out.println(line);
		
	}
	
	
	
	
		channel.disconnect();
		session.disconnect();
	}

}

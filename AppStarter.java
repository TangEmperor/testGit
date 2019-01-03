package com.test.rabbit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.rabbit.spring.TestQueueProducer;

public class AppStarter
{
	public static void main(String[] args)
	{
		onStart();
	}
	
	/**
	 * 系统启动
	 */
	public static void onStart(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:conf/spring/spring-*.xml");
		TestQueueProducer producer = context.getBean(TestQueueProducer.class);

		for (int i = 0; i < 5; i++)
		{
			new Thread(producer).start();
		}
	}
	
	/**
	 * 系统停止
	 */
	public static void onStop()
	{
		
	}
}

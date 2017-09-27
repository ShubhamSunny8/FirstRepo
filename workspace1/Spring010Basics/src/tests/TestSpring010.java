package tests;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import entities.CommonInfo;
import entities.Employee;
//XmlBeaFactory  was depriciated
//Alteration 
//xml bean factory cretaes bean lazily
public class TestSpring010 {
	public static void main(String[] args) {
		//creates memory object of configuration
		//Resource resource=new ClassPathResource("EmpManagement.xml");
		//create spring container
		//BeanFactory  factory=new XmlBeanFactory(resource);
		
		//application context creates bean eagerly by default
		ApplicationContext factory =new  ClassPathXmlApplicationContext("EmpManagement.xml");
		
		System.out.println("Factory created");
		/*CommonInfo info1 =(Employee)factory.getBean("employee");
		System.out.println(info1);*/
		/*CommonInfo info2 =(CommonInfo)factory.getBean("commonInfo");
		System.out.println(info2);*/
		
		Employee emp1=(Employee)factory.getBean("employee");
		System.out.println(emp1.hashCode());
		
		Employee emp2=(Employee)factory.getBean("employee");
		System.out.println(emp2.hashCode());
	}
	
	
	
}

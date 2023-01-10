package com.iesvdc.acceso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iesvdc.acceso.beans.*;

@RestController
@RequestMapping("api")
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);

    }

    @GetMapping(value = "moto")
        public Moto findmoto(){
            ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
            Moto miMoto = (Moto) ac.getBean("mi_moto");
            return miMoto;
        }
}

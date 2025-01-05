package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component//bu classın objeleri spring tarafından olusturulur ve yonetilir
//spring bean adı verilir
public class SmsService implements MessageService{

//    //field injection
//    @Autowired // bağlantının enjekte edilmesini sağlar.
//@Qualifier("fileRepository")//birden fazla aynı data tipinde bean varsa belirleyici kullanılır
//    private Repository repo;
    //---------------------------------
    //setter injection
//@Autowired
//@Qualifier("fileRepository")
//    public void setRepo(Repository repo) {
//        this.repo = repo;
//    }
//
//    private Repository repo;
//------------------------------------------------------
private Repository repo;

@Autowired
    public SmsService(@Qualifier("dbRepository") Repository repo) {
        this.repo = repo;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız sms ile gönderiliyor. Mesaj : "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {

    }
    @PostConstruct
    public void postContructor(){
        System.out.println("-----------Sms service objesi oluşturuldu");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("-----------Sms service objesi imha edildi");
    }
}

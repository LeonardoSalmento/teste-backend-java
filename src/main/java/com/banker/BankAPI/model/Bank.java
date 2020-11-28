package com.banker.BankAPI.model;


import javax.persistence.*;

@Entity
@Table(name="Bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigo_compensacao")
    private String compensationCode;
    @Column(name = "nome")
    private String name;

    public Bank(){
    }

    public Bank(int id, String compensationCode, String nome){
        this.id = id;
        this.compensationCode = compensationCode;
        this.name = nome;
    }

    public long getId(){
        return id;
    }

    public String getCompensationCode(){
        return this.compensationCode;
    }

    public void setCompensationCode(String compensationCode){
        this.compensationCode = compensationCode;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }


}

package com.example.Dispenser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "denoms")
@EntityListeners(AuditingEntityListener.class)

//Columns for Denom Table

public class Denoms {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
	
	@Column(name = "Denoms")
    private String[] denoms;
	 
    @Column(name = "Total_Amount")
    private String amount;
    
    @Column(name = "R100")
    private String _100;
    
    @Column(name = "R50")
    private String _50;
    
    @Column(name = "R20")
    private String _20;
    
    @Column(name = "R10")
    private String _10;
    
    @Column(name = "R5")
    private String _5;
    
    @Column(name = "R2")
    private String _2;
    
    @Column(name = "R1")
    private String _1;
    
	public String[] getDenoms() {
		return denoms;
	}
	
	public void setDenoms(String[] denoms) {
		this.denoms = denoms;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String get_100() {
		return _100;
	}

	public void set_100(String _100) {
		this._100 = _100;
	}

	public String get_50() {
		return _50;
	}

	public void set_50(String _50) {
		this._50 = _50;
	}

	public String get_20() {
		return _20;
	}

	public void set_20(String _20) {
		this._20 = _20;
	}

	public String get_10() {
		return _10;
	}

	public void set_10(String _10) {
		this._10 = _10;
	}

	public String get_5() {
		return _5;
	}

	public void set_5(String _5) {
		this._5 = _5;
	}

	public String get_2() {
		return _2;
	}

	public void set_2(String _2) {
		this._2 = _2;
	}

	public String get_1() {
		return _1;
	}

	public void set_1(String _1) {
		this._1 = _1;
	}
    
    

}

package com.slk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "equity")
public class EquityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer equityId;
	String equityName;
	String symbol;
	String series;
	Double high52;
	Double low52;
	Double todayOpen;
	Double todayClose;
	Double todayHigh;
	Double todayLow;
	Double price;
	Integer activeInd;
	Integer buysellInd;
	String industryName;

}

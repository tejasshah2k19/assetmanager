package com.slk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDTOList{
    public int sId;
    public String sn;
    public String sc;
    public String in;
    public Object mc;
    public double cp;
    public double pchg;
    @JsonProperty("52h") 
    public double _52h;
    @JsonProperty("52l") 
    public double _52l;
    public Lt lt;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getSc() {
		return sc;
	}
	public void setSc(String sc) {
		this.sc = sc;
	}
	public String getIn() {
		return in;
	}
	public void setIn(String in) {
		this.in = in;
	}
	public Object getMc() {
		return mc;
	}
	public void setMc(Object mc) {
		this.mc = mc;
	}
	public double getCp() {
		return cp;
	}
	public void setCp(double cp) {
		this.cp = cp;
	}
	public double getPchg() {
		return pchg;
	}
	public void setPchg(double pchg) {
		this.pchg = pchg;
	}
	public double get_52h() {
		return _52h;
	}
	public void set_52h(double _52h) {
		this._52h = _52h;
	}
	public double get_52l() {
		return _52l;
	}
	public void set_52l(double _52l) {
		this._52l = _52l;
	}
	public Lt getLt() {
		return lt;
	}
	public void setLt(Lt lt) {
		this.lt = lt;
	}
    
}


package com.uangteman.model;

	
public class Artikel {
	private int id;
	private String title;
	private String tanggal;
	private String content;
	private Penulis penulis;	
	
	public Artikel(){}

	public Artikel(int id, String title, String tanggal, String content, Penulis penulis) {
		super();
		this.id = id;
		this.title = title;
		this.tanggal = tanggal;
		this.content = content;
		this.penulis = penulis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Penulis getPenulis() {
		return penulis;
	}

	public void setPenulis(Penulis penulis) {
		this.penulis = penulis;
	}
	
	
}

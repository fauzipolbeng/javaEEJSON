package com.mini.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tbl_sembako")
public class Sembako implements Serializable {
	static final long serialVersionUID = 123489l;

	@Id
	int id;
	int harga;
    int stok;
	String jenis;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public int getStok() {
		return this.stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}
}

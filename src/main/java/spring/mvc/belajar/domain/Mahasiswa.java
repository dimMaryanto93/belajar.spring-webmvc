package spring.mvc.belajar.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mahasiswa {

	@Id
	private String id;
	private String nim;
	private String nama;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

}

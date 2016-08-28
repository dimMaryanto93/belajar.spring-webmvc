package spring.mvc.belajar.dao;

import org.springframework.data.repository.CrudRepository;

import spring.mvc.belajar.domain.Mahasiswa;

public interface MahasiswaDao extends CrudRepository<Mahasiswa, String> {

	public Mahasiswa findByNim(String nim);

}

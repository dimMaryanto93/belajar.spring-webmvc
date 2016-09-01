package spring.mvc.belajar.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import spring.mvc.belajar.domain.Jurusan;

public interface JurusanDao extends PagingAndSortingRepository<Jurusan, String> {

}

package spring.mvc.belajar.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import spring.mvc.belajar.domain.Kelas;

public interface KelasDao extends PagingAndSortingRepository<Kelas, String> {

}

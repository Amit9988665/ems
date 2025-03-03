package com.cats.ems.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cats.ems.model.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Long>{

	@Query(value="   select * from holiday a where TO_TIMESTAMP(a.start, 'dd-MM-yyyy HH24:MI:ss') >= \r\n"
			+ " TO_TIMESTAMP(:startDate, 'dd-MM-yyyy HH24:MI:ss') and  ( TO_TIMESTAMP(a.start, 'dd-MM-yyyy HH24:MI:ss') <= \r\n"
			+ " TO_TIMESTAMP(:endDate, 'dd-MM-yyyy HH24:MI:ss') ) ", nativeQuery = true )
	List<Holiday> findByStartAndEndDate(@Param("startDate") String startDate,@Param("endDate") String endDate);

	List<Holiday> findByType(String string);
	
}

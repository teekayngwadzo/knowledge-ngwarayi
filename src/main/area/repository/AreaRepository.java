package zw.co.econet.assessment.area.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.co.econet.assessment.area.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
}

package zw.co.econet.area.service;

import zw.co.econet.area.Area;

import java.util.List;
import java.util.Optional;

public interface AreaService {

    Optional<Area> save(Area area);


    List<Area> findAll();

    Optional<Area> findById(Long id);



}

package zw.co.econet.assessment.area.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.econet.assessment.area.Area;
import zw.co.econet.assessment.area.repository.AreaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public Optional<Area> save(Area area) {
        return Optional.ofNullable(areaRepository.save(area));
    }

    @Override
    public Optional<Area> findById(Long id) {
        return areaRepository.findById(id);
    }

    @Override
    public List<Area> findAll() {
        return areaRepository.findAll();
    }
}

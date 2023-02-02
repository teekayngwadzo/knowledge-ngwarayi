package zw.co.econet.area.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.econet.area.Area;
import zw.co.econet.area.repository.AreaRepository;
import zw.co.econet.common.BusinessRuntimeException;

import java.util.List;
import java.util.Optional;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public Optional<Area> save(Area area) {
        var savedName = areaRepository.findByName(area.getName());

        if (savedName.isPresent())
            throw new BusinessRuntimeException("Area with name" + area.getName() + " already Exist");

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

    @Override
    public Optional<Area> findByName(String name) {
        return areaRepository.findByName(name);
    }
}

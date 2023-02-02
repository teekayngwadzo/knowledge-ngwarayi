package zw.co.econet.area.rest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zw.co.econet.area.Area;
import zw.co.econet.area.service.AreaService;
import zw.co.econet.common.ApiResponse;
import zw.co.econet.common.BusinessRuntimeException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/area")
@Slf4j
public class AreaRestApi {

    @Autowired
    private AreaService service;


    @PostMapping
    public ApiResponse<Area> saveArea(@RequestBody Area area) {
        log.info("Area to be saved {}", area);
        Optional<Area> optionalArea = service.save(area);
        area = optionalArea.orElseThrow(() -> new BusinessRuntimeException("Internal Error Occurred While Creating Area"));
        return new ApiResponse<>(HttpStatus.OK.value(), "Transaction Processed Successfully", area);

    }


    @GetMapping
    public ApiResponse<List<Area>> findAllAreas() {
        List<Area> areas = service.findAll();
        return new ApiResponse<>(HttpStatus.OK.value(), "Transaction Processed Successfully", areas);
    }

    @GetMapping("/findById/{areaId}")
    public ApiResponse<Area> findById(@PathVariable("areaId") Long areaId) {
        Area area = service.findById(areaId).orElseThrow(() -> new BusinessRuntimeException("Internal Error Occurred While Creating Invoice"));

        return new ApiResponse<>(HttpStatus.OK.value(), "Transaction Processed Successfully", area);
    }

}

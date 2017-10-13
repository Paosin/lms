package com.octave.controller.order;

import com.octave.service.order.CityService;
import com.octave.vo.CityVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Paosin Von Scarlet on 2017/10/13.
 */
@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 获取相应市
     * @return
     */
    @GetMapping("/cities")
    public @ResponseBody List<CityVo> listCity(Integer provinceId) {
        return this.cityService.listByParent(provinceId);
    }

    @GetMapping("/contry")
    public @ResponseBody List<CityVo> listContry(Integer cityId) {
        return this.cityService.listByParent(cityId);
    }
}

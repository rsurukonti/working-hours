package app.springbootdemo.controller.mapper;

import app.springbootdemo.controller.model.IllView;
import app.springbootdemo.service.model.IllBO;

public class IllViewMapper {
    public static IllView from (IllBO illBO) {

        IllView ill = new IllView();

        ill.setEmpId(illBO.getEmpId());
        ill.setIllDate(illBO.getIllDate());

        return ill;
    }
}



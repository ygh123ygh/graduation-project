package com.example.login.service;

import com.example.login.entity.MedicineBean;
import com.example.login.mapper.MedicineMapper;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
@Service
public class medicineService {
    @Resource
    private MedicineMapper medicineMapper;


    public List<MedicineBean> findallmdicine() {

        return  medicineMapper.findallmdicine();
    }

    public boolean med_add(Integer id, String name, String taste, String effect,String dosage,String taboo){

        try {
            medicineMapper.med_add(id,name,taste,effect,dosage,taboo);
            return true;
        } catch (Exception e){
            return false;
        }

    }
    public boolean med_up(Integer id, String name, String taste, String effect,String dosage,String taboo){

        try {
            medicineMapper.med_update(id,name,taste,effect,dosage,taboo);
            return true;
        } catch (Exception e){
            return false;
        }

    }

    public boolean med_del(Integer id ){
        try {
            medicineMapper.med_del(id);
            return true;
        } catch (Exception e){
            return false;
        }

    }
}


package com.weilinyang.controller;

import com.weilinyang.pojo.Depart;
import com.weilinyang.service.ImportService;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/import")
public class ImportController {

    @Autowired
    private ImportService importService;

    @RequestMapping("/depart")
    public String importData(MultipartFile file){
        try {
            //获取上传的excel文件
            Workbook workbook = WorkbookFactory.create(file.getInputStream());
            //创建保存数据的集合
            List<Depart> departs = new ArrayList<Depart>();
            for (int i = 0; i <workbook.getNumberOfSheets(); i++) {
                //获取一个sheet对象
                Sheet sheet = workbook.getSheetAt(i);
                //遍历表里的行,第一行是标题，从第二行开始
                System.out.println(sheet.getLastRowNum());
                for (int j = sheet.getFirstRowNum()+1; j <= sheet.getLastRowNum(); j++) {
                    //获取行对象
                    Row row = sheet.getRow(j);
                    //获取行内列的数据值
                    String provinceName = null;
                    if (row.getCell(0)!=null){
                        provinceName = row.getCell(0).getStringCellValue();
                    }
                    System.out.println(provinceName);
                    String cityName = null;
                    if (row.getCell(1)!=null){
                        cityName=row.getCell(1).getStringCellValue();
                    }
                    double bank=0;
                    if (row.getCell(2)!=null){
                        bank=row.getCell(2).getNumericCellValue();
                    }


                    //创建一个数据的接收对象
                    Depart depart = new Depart();
                    if (provinceName!=null){
                        depart.setProvinceCode("p001");
                    }
                    if (cityName!=null){
                        depart.setCityCode("c001");
                    }
                    //把表中的行内数据封装进接收对象
                    depart.setProvinceName(provinceName);
                    depart.setCityName(cityName);
                    depart.setBank(String.valueOf(bank));
                    //将接收对象添加至接收对象列表
                    departs.add(depart);
                }
            }
            importService.importData(departs);
            return "OK";
        }catch (Exception e){
            e.printStackTrace();
            return "FAIL";
        }
    }
}

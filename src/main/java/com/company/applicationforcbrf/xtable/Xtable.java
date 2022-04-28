package com.company.applicationforcbrf.xtable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Xtable {
    @Id
    private String id;
    private String typeEd;
    private String xtime;
    private String idTrans;
    private String code1;
    private String type2;


    public Xtable(String id, String typeEd, String xtime, String idTrans, String code1, String type2, String conditions,
                  String reg, String date, String length, String offset) {
        this.id = id;
        this.typeEd = typeEd;
        this.xtime = xtime;
        this.idTrans = idTrans;
        this.code1 = code1;
        this.type2 = type2;
        this.conditions = conditions;
        this.reg = reg;
        this.date = date;
        this.length = length;
        this.offset = offset;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTypeEd(String typeEd) {
        this.typeEd = typeEd;
    }

    public void setXtime(String xtime) {
        this.xtime = xtime;
    }

    public void setIdTrans(String idTrans) {
        this.idTrans = idTrans;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    private String conditions;
    private String reg;
    private String date;
    private String length;
    private String offset;
    private String bic;
    private String data1;
    private String name;

    public Xtable() {
    }



    public void setBic(String bic) {
        this.bic = bic;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getTypeEd() {
        return typeEd;
    }

    public String getXtime() {
        return xtime;
    }

    public String getIdTrans() {
        return idTrans;
    }

    public String getCode1() {
        return code1;
    }

    public String getType2() {
        return type2;
    }

    public String getConditions() {
        return conditions;
    }

    public String getReg() {
        return reg;
    }

    public String getDate() {
        return date;
    }

    public String getLength() {
        return length;
    }

    public String getOffset() {
        return offset;
    }

    public String getBic() {
        return bic;
    }

    public String getData1() {
        return data1;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id +
                "|" + typeEd +
                "|" + xtime +
                "|" + idTrans +
                "|" + code1 +
                "|" + type2 +
                "|" + conditions +
                "|" + reg +
                "|" + date +
                "|" + length +
                "|" + offset;
    }
}

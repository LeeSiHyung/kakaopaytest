package com.kakao.kakaopay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kakao.kakaopay.value.DeviceType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

@Getter
@Setter
@ToString
public class CsvMappingBanking {

    @JsonProperty("기간")
    private String year;
    @JsonProperty("이용률")
    private Double rate;
    @JsonProperty("스마트폰")
    private Double smartPhone;
    @JsonProperty("데스크탑 컴퓨터")
    private Double desktop;
    @JsonProperty("노트북 컴퓨터")
    private Double notebook;
    @JsonProperty("기타")
    private Double etc;
    @JsonProperty("스마트패드")
    private Double smartPad;

    public Banking getBanking(Device device){
        Banking banking = new Banking(device);
        banking.setYear(this.getYear());
        if(DeviceType.SMARTPHONE.getDescription().equals(device.getDevice_name())){
            banking.setRate(this.getSmartPhone());
        }
        if(DeviceType.DESKTOP.getDescription().equals(device.getDevice_name())){
            banking.setRate(this.getDesktop());
        }
        if(DeviceType.NOTEBOOK.getDescription().equals(device.getDevice_name())){
            banking.setRate(this.getNotebook());
        }
        if(DeviceType.ETC.getDescription().equals(device.getDevice_name())){
            banking.setRate(this.getEtc());
        }
        if(DeviceType.SMARTPAD.getDescription().equals(device.getDevice_name())){
            banking.setRate(this.getSmartPad());
        }
        return banking;
    }
    public void setRate(String rate){
        this.rate =  StringUtils.isEmpty(rate) ? 0.0 :
                Double.parseDouble(rate.replace("-", "0"));
    }

    public void setSmartPhone(String smartPhone){
        this.smartPhone =  StringUtils.isEmpty(smartPhone) ? 0.0 :
                Double.parseDouble(smartPhone.replace("-", "0"));
    }

    public void seDesktop(String desktop){
        this.desktop =  StringUtils.isEmpty(desktop) ? 0.0 :
                Double.parseDouble(desktop.replace("-", "0"));
    }

    public void setNotebook(String notebook){
        this.notebook =  StringUtils.isEmpty(notebook) ? 0.0 :
                Double.parseDouble(notebook.replace("-", "0"));
    }

    public void setSmartPad(String smartPad){
        this.smartPad =  StringUtils.isEmpty(smartPad) ? 0.0 :
                Double.parseDouble(smartPad.replace("-", "0"));
    }


}

package com.example.busoffline;

public class BusData {

    private String BUS_NAME;
    private String ROUTE_START;
    private String ROUTE_END;
    private String ROUTE_MAP;

    public BusData() {

    }

    public BusData(String BUS_NAME, String ROUTE_START, String ROUTE_END, String ROUTE_MAP) {
        this.BUS_NAME = BUS_NAME;
        this.ROUTE_START = ROUTE_START;
        this.ROUTE_END = ROUTE_END;
        this.ROUTE_MAP = ROUTE_MAP;
    }

    public String getBUS_NAME() {
        return BUS_NAME;
    }

    public void setBUS_NAME(String BUS_NAME) {
        this.BUS_NAME = BUS_NAME;
    }

    public String getROUTE_START() {
        return ROUTE_START;
    }

    public void setROUTE_START(String ROUTE_START) {
        this.ROUTE_START = ROUTE_START;
    }

    public String getROUTE_END() {
        return ROUTE_END;
    }

    public void setROUTE_END(String ROUTE_END) {
        this.ROUTE_END = ROUTE_END;
    }

    public String getROUTE_MAP() {
        return ROUTE_MAP;
    }

    public void setROUTE_MAP(String ROUTE_MAP) {
        this.ROUTE_MAP = ROUTE_MAP;
    }



}

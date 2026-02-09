package com.campus.backendproject.dto.admin;

public class AdminIngresoMensualResponse {

    private Integer anio;
    private Integer mes;
    private Long total;

    public AdminIngresoMensualResponse(Number anio, Number mes, Number total) {
        this.anio = anio != null ? anio.intValue() : null;
        this.mes = mes != null ? mes.intValue() : null;
        this.total = total != null ? total.longValue() : 0L;
    }

    public Integer getAnio() { return anio; }
    public Integer getMes() { return mes; }
    public Long getTotal() { return total; }

    public void setAnio(Integer anio) { this.anio = anio; }
    public void setMes(Integer mes) { this.mes = mes; }
    public void setTotal(Long total) { this.total = total; }
}

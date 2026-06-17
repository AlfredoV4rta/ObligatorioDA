package obligatoriodisenio.ObligatorioDisenio.DTOs;

import obligatoriodisenio.ObligatorioDisenio.model.Jornada;

public class TableroAdminDTO {
    private String fecha;
    private double totalApostado;
    private double totalPagado;
    private double comisiones;
    private double balance;
    private int cantidadCarreras;
    private int finalizadas;
    private int faltanCorrer;

    public TableroAdminDTO(Jornada jornada, double comision) {
        if (jornada == null) {
            this.fecha = "";
            return;
        }
        this.fecha = jornada.getFecha().toString();
        this.totalApostado = jornada.totalApostado();
        this.totalPagado = jornada.totalPagado();
        this.comisiones = totalApostado * comision;
        this.balance = totalApostado - totalPagado;
        this.cantidadCarreras = jornada.getCarreras().size();
        this.finalizadas = jornada.cantidadFinalizadas();
        this.faltanCorrer = cantidadCarreras - finalizadas;
    }

    public String getFecha() {
        return fecha;
    }

    public double getTotalApostado() {
        return totalApostado;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public double getComisiones() {
        return comisiones;
    }

    public double getBalance() {
        return balance;
    }

    public int getCantidadCarreras() {
        return cantidadCarreras;
    }

    public int getFinalizadas() {
        return finalizadas;
    }

    public int getFaltanCorrer() {
        return faltanCorrer;
    }
}

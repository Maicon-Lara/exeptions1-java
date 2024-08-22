package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    // Atributos da classe Reservation
    private Integer roomNumber; 
    private Date checkIn; 
    private Date checkOut; 

    // Cria um objeto SimpleDateFormat para formatar as datas de check-in e check-out
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Construtor da classe Reservation
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber; // Atribui o número do quarto ao atributo roomNumber
        this.checkIn = checkIn; // Atribui a data de check-in ao atributo checkIn
        this.checkOut = checkOut; // Atribui a data de check-out ao atributo checkOut
    }

    // Métodos getters e setters para os atributos da classe Reservation
    public Integer getRoomNumber() {
        return roomNumber; // Retorna o número do quarto
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber; // Define o número do quarto
    }

    public Date getCheckIn() {
        return checkIn; // Retorna a data de check-in
    }

    public Date getCheckOut() {
        return checkOut; // Retorna a data de check-out
    }

    // Método para calcular a duração da reserva em dias
    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime(); // Calcula a diferença de tempo entre check-out e check-in em milissegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Converte a diferença de tempo de milissegundos para dias e retorna o resultado
    }

    // Método para atualizar as datas de check-in e check-out da reserva
    public void updateDates(Date checkIn, Date checkOut) {
        this.checkIn = checkIn; // Atribui a nova data de check-in ao atributo checkIn
        this.checkOut = checkOut; // Atribui a nova data de check-out ao atributo checkOut
    }

    // Sobrescreve o método ToString() para retornar uma string que representa a reserva em um formato legível
    @Override
    public String toString() {
        return "Room "
            + roomNumber
            + ", checkin: "
            + sdf.format(checkIn)
            + ", checkout: "
            + sdf.format(checkOut)
            + ", "
            + duration()
            + " nights";
    }

}

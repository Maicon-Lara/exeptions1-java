package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

    public static void main(String[] args) throws ParseException {

        
        Scanner sc = new Scanner(System.in);

        // Cria um objeto SimpleDateFormat para formatar as datas de check-in e check-out
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        // Solicita ao usuário a data de check-in e a converte para um objeto Date
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        // Solicita ao usuário a data de check-out e a converte para um objeto Date
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        // Verifica se a data de check-out é posterior à data de check-in
        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            // Se for, cria um objeto Reservation com as informações fornecidas pelo usuário
            Reservation reservation = new Reservation(number, checkIn, checkOut);

            System.out.println("Reservation: " + reservation);

            // Solicita ao usuário novas datas de check-in e check-out para atualizar a reserva
            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            // Cria um objeto Date para representar a data e hora atuais
            Date now = new Date();

            // Verifica se as novas datas são datas futuras e se a data de check-out é posterior à data de check-in
            if(checkIn.before(now) || checkOut.before(now)) {
                // Se alguma dessas condições não for atendida, exibe uma mensagem de erro
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }
            else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else {
                // Se todas as condições forem atendidas, atualiza a reserva com as novas datas e exibe a reserva atualizada
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }

        sc.close();
    }

}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dam1campostello_daniel_ejercicio099900dias;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author daniel campos
 */
public class DAM1CamposTello_Daniel_Ejercicio099900Dias {

  /**
   * @param args the command line
   * arguments
   */
  public static void main(String[] args) {

    //se obtiene la fecha actual.
    Calendar fechaActual = Calendar.getInstance();
    fechaActual.set(2022,3,11);//fecha realizacion del ejercicio
    //se crea una fecha a incrementar
    Calendar fechaModificada = fechaActual;
    //se crea una fecha fin
    Calendar fechaFin = Calendar.getInstance();
    fechaFin.set(2024, 5, 24);
    //se calcula los dias restantes
    long diasRestantes = ChronoUnit.DAYS.between(fechaActual.toInstant(), fechaFin.toInstant());
    //creamos una coleccion  donde almacenar las fechas
    ArrayList<String> fechas = new ArrayList<>();
    //se van sumandos dias hasta la fecha fin
    for (int i = 0; i <= diasRestantes; i++) {
      //se crea un formato para la fecha
      SimpleDateFormat formatoFecha = new SimpleDateFormat("EEEE',' dd 'de' MMMM 'de' YYYY'.'");
      //se aplica el formato a la fecha
      String fechaFormateada = formatoFecha.format(fechaModificada.getTime());
      //se aniade la fecha a la coleccion
      fechas.add(fechaFormateada);
      //se incrementa en 1 la fecha
      fechaModificada.add(Calendar.DATE, 1);
    }
    //se crea un patron para filtrar un dia en concreto
    String patron = "^martes.*";//que empiece por martes seguido de cualquier caracter repetido N veces.
    Pattern p = Pattern.compile(patron);
    //se crea un arraylist para almacenar dichos dias
    ArrayList<String> seleccionFechas = new ArrayList<>();
    //imprimimos la coleccion de fechas
    for (String f : fechas) {
      System.out.println(f);
      //usamos el patron, si conicide almacenaremos en el nuevo array list
      Matcher m = p.matcher(f);
      if(m.matches()) seleccionFechas.add(f);
    }
    System.out.println("Seleccion de dias que son 'martes':");
    for (String f : seleccionFechas) {
      System.out.println(f);
    }
  }
}

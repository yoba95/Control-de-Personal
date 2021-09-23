import java.time.LocalDate
import java.time.LocalTime
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities

data class Asistencias(val id: Personal,var horaREntrada: Array<LocalTime>,val horaRSalida: Array<LocalTime>,val dia: Array<LocalDate>) {
    fun diasTrabajados(): Array<LocalDate> {
        for (x in dia.indices) {
            println("Fecha: ${dia.get(x)} Hora de Entrada: ${horaREntrada.get(x)} Salida: ${horaRSalida.get(x)}")
        }
        return dia
    }

    fun asistencias(fIngreso: LocalDate,feInicio: LocalDate, feFin: LocalDate) {
        val x = 0
        var faltas: Int = 0
        var faltas2: Int = 0
        var antiguedad: Int
        var fActual: LocalDate = LocalDate.now()
        antiguedad = fActual.year-fIngreso.year
        val fechainicio=feInicio.plusDays(15)

        for (x in dia.indices) {
            if (dia.get(x).dayOfMonth <= fechainicio.dayOfMonth) {
                if (horaREntrada.get(x).hour == 8 ) {
                    if (horaREntrada.get(x).minute >= 11) {
                        if (horaREntrada.get(x).minute <= 59) {
                            faltas++
                        }
                    }
                }
                if(horaREntrada.get(x).hour >8){
                    faltas++
                }
                //SalidaP
                if (horaRSalida.get(x).hour < 17) {
                    if (horaRSalida.get(x).minute <=59) {
                        if(horaRSalida.get(x).second ==0) {
                         if (horaRSalida.get(x).second <=59){
                            faltas++
                        }
                        }
                    }
                }
            }
                if (dia.get(x).dayOfMonth > fechainicio.dayOfMonth) {
                    if (horaREntrada.get(x).hour == 8) {
                        if (horaREntrada.get(x).minute >= 11) {
                            if (horaREntrada.get(x).minute <= 20 || horaREntrada.get(x).minute > 20) {
                                faltas2++
                            }
                        }
                    }
                    if(horaREntrada.get(x).hour >8){
                        faltas2++
                    }
                    if (horaRSalida.get(x).hour < 17) {
                        if (horaRSalida.get(x).minute <=59) {
                            if(horaRSalida.get(x).second ==0) {
                                if (horaRSalida.get(x).second <=59){
                                    faltas2++
                                }
                            }
                        }
                    }
                }
        }
        println("Primera Quincena---- Faltas Totales: $faltas \nSegunda Quincena---- Faltas Totales: $faltas2 \nAntiguedad: $antiguedad años ")
    }













    fun ide():Personal{
        return id
    }
}

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities

class Horario(val horaEntrada: LocalTime,val horaSalida: LocalTime,var fechaInicio: LocalDate,var fechaFin: LocalDate){
    fun fechaInicioFin(): LocalDate{
        println("Fecha de Inicio: $fechaInicio")
        return fechaInicio
    }
    fun fechaFin(): LocalDate{
        println("Fecha de Fin: $fechaFin")
        return fechaFin
    }
    fun horarioEntrada(): LocalTime{
        val horarioAm: LocalTime
        val horarioPm: LocalTime
        horarioAm = LocalTime.parse("09:00:00")
        val horaios: String
        return horarioAm
    }
    fun horarioSalida(): LocalTime{
        val horarioPm: LocalTime
        horarioPm = LocalTime.parse("16:00:00")
        return horarioPm

    }
    fun getEntrada(): LocalTime{
        val hora: LocalTime
        return horaEntrada
    }
    fun getSalida(): LocalTime{
        return horaSalida
    }
}
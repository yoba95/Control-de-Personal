import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class Personal (val fulname: Person,val id: Int,val gradoAcademico: String,val fechaIngreso: LocalDate,val curp: String,val claveP: String,val horario: Horario){

    fun fulname(): Person{
        return fulname
    }
    fun getIdentificador(): Int{
        return id
    }
    fun nivelEstudios(): String{
        return gradoAcademico
        }
    fun FechaIngreso(): LocalDate {
        return fechaIngreso
    }
    fun imprimirHorario(): Horario{
        val entrada= horario.horarioEntrada()
        val salida= horario.horarioSalida()
        println("Horario: "+entrada+" am  "+salida+" pm")
        return horario
    }

}
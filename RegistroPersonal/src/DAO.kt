import org.junit.Test
import java.time.LocalDate
import java.time.LocalTime
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class DAO{
    private val repositoryCRUD: AbstractRespositoryCrud<Person> by lazy { PersonsCrud() }
    private val empleadosCRUD: AbstractRespositoryCrud<Personal> by lazy { EmpleadoCrud() }
    private val horariosCRUD: AbstractRespositoryCrud<Horario> by lazy { HorarioCrud() }
    private val inicistenciasCRUD: AbstractRespositoryCrud<Asistencias> by lazy { AsistenciasCRUD() }

@Test
fun inizialize_iscorrect() {
    empleadosCRUD.cleanAll()
    repositoryCRUD.cleanAll()
    horariosCRUD.cleanAll()
    val horarios= Horario(LocalTime.MIN,
        LocalTime.MAX,LocalDate.MIN, LocalDate.MAX)

    empleadosCRUD.insert(Personal(fulname = Person("Yobany Chavez Olivera"),1,"Ingenieria", LocalDate.parse("2019-09-08"),"YOB18293TSRR","0101-67-YCO",horarios))
    empleadosCRUD.insert(Personal(fulname = Person("Carlos Bustamante Cruz"),2,"Doctorado", LocalDate.parse("2019-09-02"),"CBC650HSH879","0202-68-CBC",horarios))
    empleadosCRUD.insert(Personal(fulname = Person("Alberto Ramirez Ruiz"),3,"Bachillerato", LocalDate.parse("2021-09-03"),"ALRR85903J50","0303-69-ARR",horarios))

    val id = Personal(fulname = Person(" "),2," ", LocalDate.MIN," ","",horarios)
    val listEntrada = arrayOf(LocalDate.parse("2021-09-07"), LocalDate.parse("2021-09-09"), LocalDate.parse("2021-09-10"))
    val listEntrada2 = arrayOf(LocalDate.parse("2021-09-04"), LocalDate.parse("2021-09-05"), LocalDate.parse("2021-09-06"),LocalDate.parse("2021-09-07"),LocalDate.parse("2021-09-08"),LocalDate.parse("2021-09-09"),LocalDate.parse("2021-09-27"))
    val horaRegis= arrayOf(LocalTime.parse("08:00:00"),LocalTime.parse("08:00:00"),LocalTime.parse("08:40:00"),LocalTime.parse("08:15:00"),LocalTime.parse("08:21:00"),LocalTime.parse("08:30:00"),LocalTime.parse("08:00:00"))
    val horaSalida= arrayOf(LocalTime.parse("17:00:00"),LocalTime.parse("16:59:59"),LocalTime.parse("17:00:00"),LocalTime.parse("16:00:00"),LocalTime.parse("17:00:00"),LocalTime.parse("17:00:00"),LocalTime.parse("17:00:00"))
    inicistenciasCRUD.insert(Asistencias( id,horaRegis, horaSalida, listEntrada2))
    horariosCRUD.insert(Horario(LocalTime.MIN, LocalTime.MAX, LocalDate.parse("2021-09-01"), LocalDate.parse("2021-10-01")))
    assertEquals(3, empleadosCRUD.dataList.size)
    assertEquals(1, inicistenciasCRUD.dataList.size)
}

    @Test
fun getAll_isCorrect(){
    inizialize_iscorrect()
    val personas = repositoryCRUD.getAll()
    val empleados =empleadosCRUD.getAll()
    val horarios = horariosCRUD.getAll()
    val inicistencias = inicistenciasCRUD.getAll()

    val id = empleados.first{person -> person.id.toString().contains("2") }
    val idA = inicistencias.first {idA -> idA.id.id.toString().contains("2")  }
    val fInicio = horarios.first { inicio-> inicio.horaEntrada.toString().contains("00:00")}
    val datosI= PrintPersonal().printPersonal(id)
        idA.ide()
        id.imprimirHorario()
    val inicio= fInicio.fechaInicioFin()
    val final=fInicio.fechaFin()
        idA.diasTrabajados()
        idA.asistencias(id.FechaIngreso(),inicio,final)
        assertNotNull(id)
        assertTrue{ id is Personal }
}
}
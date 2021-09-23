class EmpleadoCrud : AbstractRespositoryCrud<Personal>() {
    override fun filter(param: String): ArrayList<Personal> {
        dataList.filter { empleado -> empleado.fulname.fulname.contains(param) or empleado.gradoAcademico.contains(param) or
               empleado.curp.contains(param) or empleado.claveP.contains(param) or empleado.fechaIngreso.toString().contains(param) or empleado.id.toString().contains(param) or empleado.fechaIngreso.toString().contains(param)}
        return dataList
    }
}

class AsistenciasCRUD :  AbstractRespositoryCrud<Asistencias>() {
    override fun filter(param: String): ArrayList<Asistencias> {
        dataList.filter { asistencia -> asistencia.id.id.toString().contains(param)}
        return dataList
    }
}
abstract class AbstractRespositoryCrud  <T> {

    var dataList : ArrayList<T> = arrayListOf()

    fun insert(element: T){
        dataList.add(element)
    }
    fun insertHorario(element: T){
        dataList.add(element)
    }

    fun update(element: T){
        dataList[dataList.indexOf(element)] = element
    }

    fun delete(element: T){
        dataList.remove(element)
    }

    fun getByIndex(index: Int) : T {
        return dataList[index]
    }

    fun getAll() : ArrayList<T> {
        return dataList
    }
    fun cleanAll() {
        dataList = arrayListOf()
    }

    abstract fun filter(param: String): ArrayList<T>

}
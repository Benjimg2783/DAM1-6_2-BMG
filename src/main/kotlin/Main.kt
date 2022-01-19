abstract class ArmasFuego {
    abstract val nombre:String
    abstract  var municion:Int
    abstract var municionARestar: Int
    abstract val danio:Int
    override fun toString(): String = "El arma $nombre le queda $municion y hace un daño de $danio"
    fun disparar() = if (municion >= municionARestar) municion - municionARestar else municion
    fun recargar(r: Int): Int {
        municion += r
        return municion
    }
}

class Casa(private val direccion: String, override var municion: Int, override var municionARestar: Int,
           override val nombre: String, override val danio: Int ) : ArmasFuego()
class Coche(private val matricula: String, override var municion: Int, override var municionARestar: Int, override val nombre:String,
            override val danio: Int) : ArmasFuego()
class Bocadillo(private val sabor:String, override var municion: Int, override var municionARestar: Int, override val nombre:String,
                override val danio: Int):ArmasFuego()

fun main() {
    val casa = Casa("Avd.Segunda Aguanda 10", 30, 5,"paco",10)
    val coche = Coche("A123", 20, 3,"pepe",5)
    val bocadillo=Bocadillo("chorizo",10,2, "jose", 1)
    val lista = listOf(casa,coche,bocadillo)
    val disparos = mutableMapOf<String, ArmasFuego>()
    for (i in 0 until 6) {
        disparos["$i"] = lista.random()
    }
    disparos.mapValues { it.value.disparar(); println(it.value) }
}
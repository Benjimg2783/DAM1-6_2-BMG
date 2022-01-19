abstract class ArmasFuego(
    val nombre: String,
    var municion: Int,
    var municionARestar: Int,
    val danio: Int
) {
    override fun toString(): String = "El arma $nombre le queda $municion y hace un daño de $danio"
     open fun disparar(): Int {
        if (municion >= municionARestar) municion - municionARestar else municion
        return municion
    }


    fun recargar(r: Int): Int {
        municion += r
        return municion
    }
}

class Casa(
    private val direccion: String, municion: Int, municionARestar: Int,
    nombre: String, danio: Int
) : ArmasFuego(nombre, municion, municionARestar, danio) {
}

class Coche(
    private val matricula: String,
    municion: Int,
    municionARestar: Int,
    nombre: String,
    danio: Int
) : ArmasFuego(nombre, municion, municionARestar, danio) {
}

class Bocadillo(
    sabor: String,
    municion: Int,
    municionARestar: Int,
    nombre: String,
    danio: Int
) : ArmasFuego(nombre, municion, municionARestar, danio) {

}

class Pistola(
    nombre: String,
    municion: Int,
    municionARestar: Int,
    danio: Int
) :
    ArmasFuego(nombre, municion, municionARestar, danio) {
    override fun disparar(): Int {
        val resta = municionARestar * 1
        if (municion >= resta) municion -= resta else municion
        return municion
    }
}

class Rifle(
    nombre: String,
    municion: Int,
    municionARestar: Int,
    danio: Int
) :
    ArmasFuego(nombre, municion, municionARestar, danio) {
    override fun disparar(): Int {
        val resta = municionARestar * 2
        if (municion >= resta) municion -= resta else municion
        return municion
    }

}

class Bazooka(
    nombre: String,
    municion: Int,
    municionARestar: Int,
    danio: Int
) :
    ArmasFuego(nombre, municion, municionARestar, danio) {
    override fun disparar(): Int {
        val resta = municionARestar * 3
        if (municion >= resta) municion -= resta else municion
        return municion
    }
}

fun main() {
    val casa = Casa("Avd.Segunda Aguanda 10", 80, 5, "paco", 10)
    val coche = Coche("A123", 20, 3, "pepe", 5)
    val bocadillo = Bocadillo("chorizo", 10, 2, "jose", 1)
    val pistola = Pistola("juan", 15, 1, 3)
    val rifle = Rifle("naim", 40, 2, 70)
    val bazooka = Bazooka("Edu", 3, 1, 100)
    val lista = listOf(casa, coche, bocadillo, pistola, rifle, bazooka)
    val disparos = mutableMapOf<String, ArmasFuego>()
    for (i in 0 until 6) {
        disparos["$i"] = lista.random()
    }
    disparos.mapValues { it.value.disparar(); println(it.value) }
}
/**
 *  Clase Arma de fuego con sus atributos correspondientes. Implementará la interfaz ComportamientoArmas y
 *  por tanto los métodos que tenga y también lo tendrán que implementar las subclases.
 *
 *  @property nombre del arma
 *  @property municion del arma
 *  @property municionARestar al arma cuando dispara
 *  @property tipoDeMunicion del arma
 *  @property danio que haga el arma
 *  @property radio del arma que puede ser amplio o pequeno.
 *
 *  @constructor primario de la clase con los atributos que heredaran todas las clases hijas.
 */
abstract class ArmaDeFuego (
    var nombre: String = "",
    var municion: Int,
    var municionARestar: Int,
    var tipoDeMunicion: String,
    var danio: Int,
    var radio: String = ""
): ComportamientoArmas {

    init {
        require(radio == "Pequeño" || radio == "Amplio") {"El radio tiene que ser pequeño o amplio"}
    }

    var disparos = 0


    /**
     * Metodo dispara para indicar cuantas balas se le resta al objeto de comportamiento arma en las
     * clases hijas y contar los disparos que realiza.
     */
    override fun dispara(): String {
        disparos += 1
        return "Se ha realizado $disparos disparo\n"
    }


    /**
     * Metodo recarga para indicar cuantas balas se le suma al objeto en las clases
     * hijas e imprimir que el arma ha recargado.
     */
    override fun recarga(): String {
        return "Se ha recargado el arma"
    }


    override fun toString(): String {
        return "El arma de nombre: $nombre, con municion: $municion, tipo de municion: $tipoDeMunicion, danio: $danio y radio: $radio"
    }



}


/**
 * La clase Pistola hereda de Arma de fuego y por tanto tambien todos sus atributos y metodos. Con la diferencia
 * de que en este caso se especifica la municion que se resta al disparar y la que se suma al recargar.
 */
class Pistola(
    nombre: String = "",
    municion: Int,
    municionARestar: Int,
    tipoDeMunicion: String,
    danio: Int,
    radio: String = ""
): ArmaDeFuego(nombre,municion, municionARestar, tipoDeMunicion,danio,radio) {

    override fun dispara(): String {
        municion -= (municionARestar * 1)
        return super.dispara() + "La municion actual es $municion"
    }

    override fun recarga(): String {
        municion += 2
        return "La municion actual tras recargar es $municion"
    }


}


/**
 * La clase Rifle hereda de Arma de fuego y por tanto tambien todos sus atributos y metodos. Con la diferencia
 * de que en este caso se especifica la municion que se resta al disparar (en este caso el doble)
 * y la que se suma al recargar.
 */
class Rifle(
    nombre: String = "",
    municion: Int,
    municionARestar: Int,
    tipoDeMunicion: String,
    danio: Int,
    radio: String = ""
): ArmaDeFuego(nombre,municion, municionARestar, tipoDeMunicion,danio,radio) {



    override fun dispara(): String {
        municion -= (municionARestar * 2)
        return super.dispara() + "La municion actual es $municion"
    }

    override fun recarga(): String {
        municion += 4
        return "La municion actual tras recargar es $municion"
    }




}


/**
 * La clase Bazooka hereda de Arma de fuego y por tanto tambien todos sus atributos y metodos. Con la diferencia
 * de que en este caso se especifica la municion que se resta al disparar (en este caso el triple)
 * y la que se suma al recargar.
 */
class Bazooka(
    nombre: String = "",
    municion: Int,
    municionARestar: Int,
    tipoDeMunicion: String,
    danio: Int,
    radio: String = ""
): ArmaDeFuego(nombre,municion, municionARestar, tipoDeMunicion,danio,radio) {



    override fun dispara(): String {
        municion -= (municionARestar * 3)
        return super.dispara() + "La municion actual es $municion"
    }

    override fun recarga(): String {
        municion += 6
        return "La municion actual tras recargar es $municion"
    }



}


fun main() {

    val pistola1 = Pistola("Glock 17",6,1,"Ligera",20,"Pequeño")

    val rifle1 = Rifle("Rifle de cerrojo",18,1,"Pesada",40,"Amplio")

    val bazooka1 = Bazooka("Lanzacohetes",22,1,"Pesada",200,"Amplio")

    println("Pistola: ${pistola1.recarga()}")

    println("Rifle: ${rifle1.recarga()}")

    println("Bazooka: ${bazooka1.recarga()}")

    val armas: MutableList<ArmaDeFuego> = mutableListOf()

    armas.add(pistola1)

    armas.add(rifle1)

    armas.add(bazooka1)

    var armaAleatoria : ArmaDeFuego

    //var contador = 0

    val disparoArmas = mutableMapOf<ArmaDeFuego,String>()

    for(paso in 1..6) {
        armaAleatoria = armas.random()
        disparoArmas[armaAleatoria] = armaAleatoria.dispara()
    }


    for(disparo in disparoArmas) {
        println(disparo)
    }

}





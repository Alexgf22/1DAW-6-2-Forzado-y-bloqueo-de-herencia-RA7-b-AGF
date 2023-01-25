/**
 * Como puede observarse, no hay que ponerle open a la clase sino abstract (ya que open lo trae
 * por defecto la clase abstracta) y tambien
 * a los metodos que tenga. De esta forma no pueden crearse instancias de la clase padre, pero
 * si de las clases que hereden de ella. Ya que el metodo de la clase padre no tiene cuerpo
 * debido a que solamente especificamos el comportamiento en las clases hijas. Ademas
 * de que las propiedades y metodos abstractos seran exigidos en las subclases con el override.
 *
 * Por otro lado los atributos del constructor primario los ponemos en protected ya que al heredarlos
 * las clases hijas no es recomendable que sean abiertos.
 *
 * La ventaja de usar la interfaz es que una clase puede heredar a la vez los metodos y atributos
 * de varias interfaces y de esa forma hereda el comportamiento de cada una.
 *
 * Tambien tenemos la delegacion de interfaces, lo que significa que a un atributo del constructor
 * de la clase podemos decirle que es del tipo 'interfaz1' por ejemplo y por tanto ese
 * atributo podra acceder a los metodos de esa interfaz.
 *
 * Todas los métodos definidos por las interfaces se pueden sobrescribir sin tener que ser marcados
 * con open
 *
 * Las interfaces pueden contener propiedades abstractas y regulares pero sin campos
 * de respaldo
 */


/**
 * La interfaz ComportamientoArmas incluye los metodos dispara y recarga que al no inicializarlos
 * los tienen que cumplir de manera obligatoria todas las clases que hereden de ella.
 */
interface ComportamientoArmas {


    fun dispara(): String

    fun recarga(): String


}


/**
 * La clase Bocadillo hereda de la interfaz comportamientoArmas por lo que hace un override de sus metodos.
 * En el metodo dispara va sumando 1 a la variable disparosDelObjeto cada vez que realiza un disparo y va
 * restando municion segun la clase que sea en este caso 1 bala. En el metodo recarga va sumando las balas
 * correspondientes en este caso 1. Tambien el metodo toString para diferenciar de que clase proviene.
 *
 * @property municion del objeto Bocadillo.
 *
 */
class Bocadillo(
    var municion: Int = 0
) : ComportamientoArmas  {
    var disparosDelObjeto: Int = 0

    override fun dispara(): String {
        disparosDelObjeto += 1
        municion -= 1
        return "Ha realizado $disparosDelObjeto disparo y le quedan $municion balas restantes\n"
    }

    override fun recarga(): String {
        municion += 1
        return "La municion actual tras recargar es $municion"
    }

    override fun toString(): String {
        return "El objeto bocadillo "
    }



}



/**
 * La clase Coche hereda de la interfaz comportamientoArmas por lo que hace un override de sus metodos.
 * En el metodo dispara va sumando 1 a la variable disparosDelObjeto cada vez que realiza un disparo y va
 * restando municion segun la clase que sea en este caso 2 balas. En el metodo recarga va sumando las balas
 * correspondientes en este caso 2. Tambien el metodo toString para diferenciar de que clase proviene.
 *
 * @property municion del objeto Coche.
 */
class Coche(
    var municion: Int = 0
) : ComportamientoArmas  {
    var disparosDelObjeto: Int = 0

    override fun dispara(): String {
        disparosDelObjeto += 1
        municion -= 2
        return "Ha realizado $disparosDelObjeto disparo y le quedan $municion balas restantes\n"
    }

    override fun recarga(): String {
        municion += 2
        return "La municion actual tras recargar es $municion"
    }


    override fun toString(): String {
        return "El objeto coche "
    }


}




/**
 * La clase Casa hereda de la interfaz comportamientoArmas por lo que hace un override de sus metodos.
 * En el metodo dispara va sumando 1 a la variable disparosDelObjeto cada vez que realiza un disparo y va
 * restando municion segun la clase que sea en este caso 3 balas. En el metodo recarga va sumando las balas
 * correspondientes en este caso 3. Tambien el metodo toString para diferenciar de que clase proviene.
 *
 * @property municion del objeto Casa.
 */
class Casa(
    var municion: Int = 0
) : ComportamientoArmas  {
    var disparosDelObjeto: Int = 0

    override fun dispara(): String {
        disparosDelObjeto += 1
        municion -= 3
        return "Ha realizado $disparosDelObjeto disparo y le quedan $municion balas restantes\n"
    }

    override fun recarga(): String {
        municion += 3
        return "La municion actual tras recargar es $municion"
    }


    override fun toString(): String {
        return "El objeto casa "
    }

}




fun main() {

    val coche1 = Coche(5)
    val casa1 = Casa(8)
    val bocadillo1 = Bocadillo(10)

    val pistola2 = Pistola("Glock 22",8,1,"Ligera",20,"Pequeño")
    val rifle2 = Rifle("Rifle de mirilla",20,1,"Pesada",40,"Amplio")
    val bazooka2 = Bazooka("Bazooka",26,1,"Pesada",200,"Amplio")


    val objetosQueDisparan = mutableListOf<ComportamientoArmas>()

    objetosQueDisparan.add(coche1)
    objetosQueDisparan.add(casa1)
    objetosQueDisparan.add(bocadillo1)

    objetosQueDisparan.add(pistola2)
    objetosQueDisparan.add(rifle2)
    objetosQueDisparan.add(bazooka2)

    var disparoRandom : ComportamientoArmas

    val disparosAleatorios = mutableMapOf<ComportamientoArmas,String>()


    for(paso in 1..6) {
        //contadorNuevo += 1
        disparoRandom = objetosQueDisparan.random()
        disparosAleatorios[disparoRandom] = disparoRandom.dispara()
    }

    for(disparo in disparosAleatorios) {
        println(disparo)
    }


}





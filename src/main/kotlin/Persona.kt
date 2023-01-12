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
abstract class Persona(
    protected var nombre: String,
    protected val apellido: String,
    protected val edad: Int
) {

    abstract fun quienSoy(): String

    abstract fun cambiarNombre(nombreNuevo: String): String

    override fun toString(): String {
        return "$nombre $apellido de $edad anos"
    }


}


class Estudiante(
    nombre: String,
    apellido: String,
    edad: Int): Persona(nombre, apellido, edad) {

    override fun quienSoy(): String {
        return "Soy un estudiante"
    }

    override fun cambiarNombre(nombreNuevo: String): String {
        if(edad > 18) {
            this.nombre = nombreNuevo
        }
        return "El nuevo nombre del estudiante es: $nombre"
    }

}




class Trabajador(
    nombre: String,
    apellido: String,
    edad: Int): Persona(nombre, apellido, edad) {

    override fun quienSoy(): String {
        return "Soy un trabajador"
    }

    override fun cambiarNombre(nombreNuevo: String): String {
        if(edad > 18) {
            this.nombre = nombreNuevo
        }
        return "El nuevo nombre del trabajador es: $nombre"
    }

}



fun main() {

    val trabajador1 = Trabajador("Juan","Marquez",34)

    val estudiante1 = Estudiante("Marcos","Peralta",19)

    println(trabajador1.quienSoy())

    println(estudiante1.quienSoy())

    println(trabajador1.cambiarNombre("Alberto"))

    println(estudiante1.cambiarNombre("Alvaro"))

    println(trabajador1)
    println(estudiante1)

}
package acuario

fun construirAcuario() {
    println(" Construcción de Acuarios ")

    val acuario1 = Acuario()
    acuario1.imprimirTamano()

    val acuario2 = Acuario(ancho = 25)
    acuario2.imprimirTamano()

    val acuario3 = Acuario(alto = 35, largo = 110)
    acuario3.imprimirTamano()

    val acuario4 = Acuario(ancho = 25, alto = 35, largo = 110)
    acuario4.imprimirTamano()

    val acuario5 = Acuario(numeroDePeces = 29)
    acuario5.imprimirTamano()
    println("Volumen: ${acuario5.ancho * acuario5.largo * acuario5.alto / 1000} l")

    val acuario6 = Acuario(numeroDePeces = 29)
    acuario6.imprimirTamano()
    acuario6.volumen = 70
    acuario6.imprimirTamano()

    val acuario7 = Acuario(largo = 25, ancho = 25, alto = 40)
    acuario7.imprimirTamano()

    val torre = TanqueTorre(diametro = 25, alto = 40)
    torre.imprimirTamano()
}

fun crearPeces() {
    println("\n=== Creación de Peces ===")

    val tiburon = Tiburon()
    val pezPayaso = PezPayaso()

    println("Tiburón color: ${tiburon.color}")
    tiburon.comer()

    println("Pez Payaso color: ${pezPayaso.color}")
    pezPayaso.comer()
}

fun main() {
    construirAcuario()
    crearPeces()
}

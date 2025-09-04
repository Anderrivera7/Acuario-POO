package Acuario


class ConsolaAcuarioApp {
    private val acuarios = mutableListOf<Acuario>()

    fun run() {
        while (true) {
            println(
                """
                
                ========== MENÚ ACUARIO ==========
                1) Crear Acuario rectangular (largo, ancho, alto)
                2) Crear Tanque Torre (diámetro, alto)
                3) Crear Acuario por número de peces
                4) Listar acuarios (volumen, agua, forma)
                5) Cambiar volumen (setter) de un acuario
                6) Demostración de peces (abstracta + interfaz)
                7) Salir
                Selección: 
                """.trimIndent()
            )

            when (readLine()?.trim()) {
                "1" -> crearAcuarioRect()
                "2" -> crearTorre()
                "3" -> crearPorPeces()
                "4" -> listar()
                "5" -> cambiarVolumen()
                "6" -> demoPeces()
                "7" -> {
                    println("Hasta luego 👋")
                    return
                }
                else -> println("Opción inválida")
            }
        }
    }

    private fun crearAcuarioRect() {
        val largo = leerEntero("Largo (cm): ")
        val ancho = leerEntero("Ancho (cm): ")
        val alto  = leerEntero("Alto (cm): ")

        val a = Acuario(largo = largo, ancho = ancho, alto = alto)
        acuarios += a
        println("Creado:")
        a.imprimirTamano()
    }

    private fun crearTorre() {
        val diametro = leerEntero("Diámetro (cm): ")
        val alto     = leerEntero("Alto (cm): ")

        val t = TanqueTorre(diametro = diametro, alto = alto)
        acuarios += t
        println("Creado:")
        t.imprimirTamano()
    }

    private fun crearPorPeces() {
        val n = leerEntero("Número de peces: ")
        val a = Acuario(numeroDePeces = n)
        acuarios += a
        println("Creado con constructor secundario (por nº de peces):")
        a.imprimirTamano()
    }

    private fun listar() {
        if (acuarios.isEmpty()) {
            println("No hay acuarios aún.")
            return
        }
        acuarios.forEachIndexed { idx, a ->
            print("#${idx + 1} -> ")
            a.imprimirTamano()
        }
    }

    private fun cambiarVolumen() {
        if (acuarios.isEmpty()) {
            println("No hay acuarios para modificar.")
            return
        }
        listar()
        val idx = leerEntero("Seleccione índice de acuario (1..${acuarios.size}): ")
        val volumenNuevo = leerEntero("Nuevo volumen (litros): ")

        val i = idx - 1
        if (i !in acuarios.indices) {
            println("Índice inválido.")
            return
        }
        val a = acuarios[i]
        a.volumen = volumenNuevo 
        println("Actualizado:")
        a.imprimirTamano()
    }

    private fun demoPeces() {
        val tiburon = Tiburon()
        val payaso  = PezPayaso()
        println("Tiburón -> color: ${tiburon.color}")
        tiburon.comer()
        println("Pez Payaso -> color: ${payaso.color}")
        payaso.comer()
    }

    private fun leerEntero(prompt: String): Int {
        while (true) {
            print(prompt)
            val v = readLine()?.trim()
            val n = v?.toIntOrNull()
            if (n != null && n > 0) return n
            println("Ingrese un entero positivo.")
        }
    }
}

fun main() {
    ConsolaAcuarioApp().run()
}

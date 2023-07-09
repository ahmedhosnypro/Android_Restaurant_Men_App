data class Vector2(var x: Int, var y: Int)

interface PhysicalBody2D {
    val affectedByGravity: Boolean
        get() = true
    val simulated: Boolean
        get() = true

    val mass: Double
    val gravityStrength: Double

    val velocity: Vector2

    fun simulate()
    fun stopSimulation()
    fun setVelocityToZero()
}

class Stone(
    override val mass: Double = 0.25,
    override val gravityStrength: Double = 9.8,
    override val velocity: Vector2 = Vector2(0, 0)
) : PhysicalBody2D {
    override fun simulate() {
        TODO()
    }

    override fun stopSimulation() {
        TODO()
    }

    override fun setVelocityToZero() {
        TODO()
    }
}
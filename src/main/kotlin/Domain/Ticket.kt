package Domain

import java.time.LocalDateTime

abstract class Ticket (val priceEvent: Double, val currentDateAndTime: LocalDateTime) {

    protected val commissionNormalPro: Double = 0.75
    protected val commissionNormalElite: Double = 1.00
    protected val commissionExtraElite: Double = 3.00
    protected val commissionNormalUltimateEvent = 0.75
    protected val commissionExtraUltimateEvent = 3.00

    abstract fun calculateCommission(): Double

    abstract fun calculateAmountToPay(): Double

    abstract fun getCommission(): Double
}
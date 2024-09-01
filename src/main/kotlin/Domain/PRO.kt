package Domain

import java.time.LocalDateTime

class PRO (priceEvent: Double, currentDateAndTime: LocalDateTime): Ticket(priceEvent, currentDateAndTime) {

    override fun calculateCommission(): Double {
        return super.commissionNormalPro
    }

    override fun calculateAmountToPay(): Double {
        val finalCommission: Double = calculateCommission()
        return totalToPay(priceEvent, finalCommission)
    }
    override fun getCommission(): Double {
        return calculateCommission()
    }

    private fun totalToPay(priceEvent: Double, finalCommission: Double): Double = priceEvent+((priceEvent * finalCommission)/100)
}
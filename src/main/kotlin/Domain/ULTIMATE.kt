package Domain

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class ULTIMATE (priceEvent: Double, currentDateAndTime: LocalDateTime): Ticket(priceEvent, currentDateAndTime) {

    override fun calculateCommission(): Double {

        if (currentDateAndTime.dayOfWeek.name == DayOfWeek.SATURDAY.name || currentDateAndTime.dayOfWeek.name == DayOfWeek.SUNDAY.name) {
            return super.commissionExtraUltimateEvent
        }
        return super.commissionNormalUltimateEvent
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
package Domain

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class ELITE (priceEvent: Double, currentDateAndTime: LocalDateTime): Ticket(priceEvent, currentDateAndTime) {

    override fun calculateCommission(): Double {

        val startTime = "20:00"; val finalHour = "23:59"
        val initialTimeRange: LocalTime = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"))
        val endTimeRange: LocalTime = LocalTime.parse(finalHour, DateTimeFormatter.ofPattern("HH:mm"))
        if (currentDateAndTime.toLocalTime()>=initialTimeRange && currentDateAndTime.toLocalTime()<=endTimeRange){
            return super.commissionNormalElite
        }
        return super.commissionExtraElite
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
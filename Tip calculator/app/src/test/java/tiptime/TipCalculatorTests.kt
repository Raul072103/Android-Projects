package tiptime

import com.example.tiptime.calculateTip
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercetnRoundup() {
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val amount = 10.00
        val tipPercent = 20.00
        val actualTip = calculateTip(amount, tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }

}
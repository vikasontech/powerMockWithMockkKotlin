package com.example.powerMockWithMockkKotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.api.mockito.PowerMockito.mockStatic
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import java.time.Clock
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@RunWith(PowerMockRunner::class)
@PrepareForTest(LocalDateTime::class)
class LocalDateTimeUnitTest {

    @Test
    fun givenLocalDateTimeMock_whenNow_thenGetFixedLocalDateTime() {
        val dateTimeToParse = "2014-12-22T10:15:30.00Z"
        val dateTimeExpected = "2014-12-22T10:15:30"
        customizedDateTime(dateTimeValue = dateTimeToParse , zoneId = "UTC")
        val now = LocalDateTime.now()
        assertThat(now).isEqualTo(dateTimeExpected)
    }

    private fun customizedDateTime(dateTimeValue: String, zoneId:String): Unit{
        val clock = Clock.fixed(Instant.parse(dateTimeValue), ZoneId.of(zoneId))
        val dateTime = LocalDateTime.now(clock)
        mockStatic(LocalDateTime::class.java)
        PowerMockito.`when`(LocalDateTime.now()).thenReturn(dateTime)
    }
}
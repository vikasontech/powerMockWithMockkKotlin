package com.example.powerMockWithMockkKotlin

import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockkStatic
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.api.mockito.PowerMockito.mockStatic
import java.time.*

@ExtendWith(MockKExtension::class)
class SampleTestUsingMockk {

    @Test
    fun sample() {
        mockkStatic(LocalDateTime::class)
        every { LocalDateTime.now() }.answers { LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.now()) }
        println(LocalDateTime.now())

    }
}


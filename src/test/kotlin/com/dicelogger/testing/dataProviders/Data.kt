package com.dicelogger.testing.dataProviders

import com.dicelogger.testing.utils.UtilMethods
import org.junit.jupiter.params.provider.Arguments
import java.util.stream.Stream

object Data {
    @JvmStatic
    fun registrationData(): Stream<Arguments> = Stream.of(
        Arguments.of(
            UtilMethods.getRandomUsername(), "Andy", UtilMethods.getRandomEmail(), "Password123"
        )
    )

    @JvmStatic
    fun loginData(): Stream<Arguments> = Stream.of(
        Arguments.of(
            "8il.andre@gmail.com", "Password123"
        )
    )

    @JvmStatic
    fun campaignData(): Stream<Arguments> = Stream.of(
        Arguments.of(
            "Campaign 1", "This is a test campaign", "dungeons-and-cats.jpg", listOf("excuse-meow.jpg", "dungeon-meowster.jpg")
        )
    )

    @JvmStatic
    fun characterData(): Stream<Arguments> = Stream.of(
        Arguments.of(
            "Character 1", "This is a test character"
        )
    )
}
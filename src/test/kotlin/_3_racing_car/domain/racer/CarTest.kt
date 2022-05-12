package _3_racing_car.domain.racer

import _3_racing_car.domain.Position
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class CarTest : ExpectSpec() {
    init {
        context("move") {
            expect("전진 조건에 만족하면 위치가 변한다.") {
                forAll(
                    row(Position(1), 4, 2),
                    row(Position(1), 5, 2),
                    row(Position(2), 5, 3),
                ) {
                    position, power, expected ->

                    val car = Car(position = position)

                    car.move(power)

                    car.location shouldBe expected
                }
            }

            expect("전진 조건에 만족하지 않으면 위치가 유지한다.") {
                forAll(
                    row(Position(1), 3, 1),
                    row(Position(2), 3, 2),
                ) {
                    position, power, expected ->

                    val car = Car(position = position)

                    car.move(power)

                    car.location shouldBe expected
                }
            }
        }
    }
}

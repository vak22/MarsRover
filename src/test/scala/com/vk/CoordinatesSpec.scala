package com.vk

import org.scalatest.{FunSpec, Matchers}

class CoordinatesSpec extends FunSpec with Matchers {

  describe("moving coordinates") {

    it("should be able to move in a direction") {

      Coordinates(5, 5).moveUp shouldEqual Coordinates.moveUp(Coordinates(5, 5))

    }

    it("should be able to move in any direction") {

      val actual =
        Coordinates(5, 5).moveLeft.moveRight.moveUp.moveUp.moveDown

      val expected =
        Coordinates(5, 6)

      actual shouldEqual expected

    }

    it("should be able to add up a list of coordinates") {

      val l: List[Coordinates] =
        List(
          Coordinates(0, 0),
          Coordinates(1, 1),
          Coordinates(2, 2),
          Coordinates(3, 3),
          Coordinates(4, 4),
          Coordinates(5, 5)
        )

      val expected: Coordinates =
        Coordinates(15, 15)

      val f: (Coordinates, Coordinates) => Coordinates =
        (totalSoFar, next) => totalSoFar + next

      val actual: Coordinates =
        l.foldLeft(Coordinates.zero)(f)

      actual shouldEqual expected

    }

    it("should be able to move a number of steps in any direction") {
      val actual =
        Rover.moveForwardBy(Rover(Coordinates(0, 0), Direction.North), 7)

      val expected =
        Rover(Coordinates(0, 7), Direction.North)

      actual shouldEqual expected

      val actual1 =
        Coordinates.moveUpBy(Coordinates(0, 0), 7)

      val expected1 =
        Coordinates(0, 7)

      actual1 shouldEqual expected1
    }
  }

}

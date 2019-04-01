package com.vk

import org.scalatest.{FunSpec, Matchers}

class RoverSpec extends FunSpec with Matchers {

  describe("moving rover") {

    it("should move up 1 coordinate when facing north") {

      val rover = Rover(Coordinates(0, 0), Direction.North)

      val expected = Rover(Coordinates(0, 1), Direction.North)

      val actual = rover.moveForward

      actual shouldEqual expected

    }

    it("should move up 10 coordinate when facing north") {

      val rover = Rover(Coordinates(0, 0), Direction.North)

      val steps = 10

      val expected = Rover(Coordinates(0, 10), Direction.North)

      val actual = rover.moveForwardBy(steps)

      actual shouldEqual expected

    }

    describe("grid") {

      it("should not move off grid") {

        val rover = Rover(Coordinates(0, 0), Direction.North)

        val expected = Rover(Coordinates(0, 5), Direction.North)

        val actual = rover.moveForwardBy(15)

        actual shouldEqual expected

      }

      it("should be able to wrap around the grid") {
        val rover = Rover(Coordinates(0, 32), Direction.North)

        val expected = Rover(Coordinates(0, 2), Direction.North)

        val actual = Rover.stayOnGrid(rover, Coordinates.default)

        actual shouldEqual expected

      }
    }
  }
}

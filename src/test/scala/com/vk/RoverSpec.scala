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

      val expected = Rover(Coordinates(0, 10), Direction.North)

      val actual = rover.moveForwardBy(10)

      actual shouldEqual expected

    }

  }
}
